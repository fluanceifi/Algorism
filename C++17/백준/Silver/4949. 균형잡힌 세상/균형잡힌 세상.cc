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


int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while(1){
        char arr[101];
        cin.getline(arr, sizeof(arr));
        if (arr[0] == '.' && arr[1] == '\0') return 0;

        stack<char> s;
        bool isValid = true;

        for(char c : arr){
            if(c == '(' || c == '[') s.push(c);
            
            if(c == ')'){
                if(s.empty() || s.top() != '('){
                    isValid = false;
                    break;
                }
                s.pop();
            }

            if(c == ']'){
                if(s.empty() || s.top() != '['){
                    isValid = false;
                    break;
                }
                s.pop();
            }
            if(c == '.') break;
        }
        if(s.empty() && isValid && arr[strlen(arr) - 1] == '.') cout << "yes\n";
        else cout << "no\n";
    }
}