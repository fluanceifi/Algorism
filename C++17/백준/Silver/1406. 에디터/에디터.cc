//
//  linked_list_STL.cpp
//  imbest
//
//  Created by Seung jun Yoo on 11/20/24.
//

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <queue>
#include <stack>
#include <map>
#include <set>
#include <cmath>
#include <cstring>
#include <list>
using namespace std;

int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string s;
    cin >> s;
    
    list<char> L;
    for(auto c : s){
        L.push_back(c);
    }
    list<char>::iterator cursor = L.end();
    
    int n;
    cin >> n;
    while(n--){
        char cmd;
        cin >> cmd;
        
        switch(cmd){
            case 'L':
                if(cursor != L.begin()){
                    cursor--;
                }
                break;
            case 'D':
                if(cursor != L.end()){
                    cursor++;
                }
                break;
            case 'B':
                if(cursor != L.begin()){
                    cursor--;
                    cursor = L.erase(cursor);
                }
                break;
            case 'P':
                char cmd2;
                cin >> cmd2;
                L.insert(cursor, cmd2);
                break;
        }
    }
    
    
    for(auto c : L){
        cout << c;
    }
    cout << '\n';
    
    return 0;
}
