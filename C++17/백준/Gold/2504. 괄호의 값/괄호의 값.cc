//
//  sTack.cpp
//  imbest
//
//  Created by Seung jun Yoo on 11/21/24.
//

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <queue>
#include <list>
#include <map>
#include <set>
#include <cmath>
#include <stack>
#include <cstring>
using namespace std;

stack<char> st;
string s;
int rod = 0;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int sum = 0;
    int num = 1;
    cin >> s;
    int size = s.length();
    
    for(int i = 0 ; i < size ; i++){
        if(s[i] == '(' || s[i] == '['){
            st.push(s[i]);
            if(s[i] == '(') num *= 2;
            if(s[i] == '[') num *= 3;
        }
        else if(s[i] == ')'){
            if(st.empty() || st.top() != '('){
                cout << 0;
                return 0;
            }
            else if(s[i-1] == '(') sum += num;
            st.pop();
            num /= 2;
        }
        else if(s[i] == ']'){
            if(st.empty() || st.top() != '['){
                cout << 0;
                return 0;
            }
            else if(s[i-1] == '[') sum += num;
            st.pop();
            num /= 3;
        }
    }
    if(st.empty()) cout << sum << '\n';
    else cout << 0;
    return 0;
}