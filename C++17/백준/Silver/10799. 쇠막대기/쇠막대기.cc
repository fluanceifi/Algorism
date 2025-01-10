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

    cin >> s;
    int size = s.length();
    
    for(int i = 0 ; i < size ; i++){
        if(s[i] == '(') st.push(s[i]);
        else{
            if(s[i-1] == '('){
                st.pop();
                rod += st.size();
            }
            else{
                st.pop();
                rod++;
            }
        }
    }
    cout << rod << '\n';
    return 0;
}