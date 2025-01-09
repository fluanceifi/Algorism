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
#include <stack>
#include <list>
#include <map>
#include <set>
#include <cmath>
#include <cstring>
using namespace std;

int main(void) {
  queue<int> q;
  int n = 0;
  cin >> n;

  while(n--){
    string s;
    cin >> s;
    if(s == "push"){
      int X = 0;
      cin >> X;
      q.push(X);
    }else if( s == "pop"){
      if(q.empty()){
        cout << -1 << '\n';
      }else{
        cout << q.front() << '\n';
        q.pop();
      }
    }else if ( s == "size"){
      cout << q.size() << '\n';
    }else if ( s == "empty"){
      if(q.empty()){
        cout << 1 << '\n';
      }
      else{
        cout << 0 << '\n';
      }
    }else if ( s == "front"){
      if(q.empty()){
        cout << -1 << '\n';
      }
      else{
        cout << q.front() << '\n';
      }
    }else if ( s == "back"){
        if(q.empty()){
        cout << -1 << '\n';
      }
      else{
        cout << q.back() << '\n';
      }
    }
  
  }


}
