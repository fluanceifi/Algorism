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

int main(){
  deque<int> dq;

  int n = 0;
  cin >> n;

  while (n--){
    string s;
    cin >> s;

    if(s == "push_front"){
      int x;
      cin >> x;
      dq.push_front(x);
    }
    else if(s == "push_back"){
      int x;
      cin >> x;
      dq.push_back(x);
    }
    else if(s == "pop_front"){
      if(dq.empty()) cout << -1 << "\n";
      else{
        cout << dq.front() << '\n';
        dq.pop_front();
      } 
    }
    else if(s == "pop_back"){
      if(dq.empty()) cout << -1 << "\n";
      else{
        cout << dq.back() << '\n';
        dq.pop_back();
      }
    }
    else if(s == "size"){
      cout << dq.size() << '\n';
    }
    else if(s == "empty"){
      if(dq.empty()){
        cout << 1 << '\n';
      }
      else{
        cout << 0 << '\n';
      }
    }
    else if(s == "front"){
      if(!dq.empty()){
        cout << dq.front() << '\n';
      }
      else{
        cout << -1 << "\n";
      }
    }
    else if(s == "back"){
      if(!dq.empty()){
        cout << dq.back() << '\n';
      }
      else{
        cout << -1 << "\n";
      }
    }
  }

}