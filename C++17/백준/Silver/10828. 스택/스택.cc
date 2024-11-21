//
//  stack_10828.cpp
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

int main(int argc, const char * argv[]) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    stack<int> iStack;
    
    int n;
    cin >> n;
    while(n--){
        string cmd;
        cin >> cmd;
        
        if(cmd == "push"){  //명령이 푸쉬라면
            int cmd2; //두번째 명령어 생성
            cin >> cmd2; //입력 받기
            iStack.push(cmd2); //push 해준다.
        }
        else if (cmd == "pop"){ //명령이 팝이라면
            if(iStack.empty()) //비어있는지 확인하고 맞다면
                cout << -1 << '\n'; // -1를 출력하여 비어있다는 걸 출력
            else{ //그렇지 않으면
                cout << iStack.top() << '\n'; //맨 상단의 값을 출력해주고
                iStack.pop(); //팝 해준다.
            }
        }
        else if(cmd == "size"){ //명령이 사이즈라면
            cout << iStack.size() << '\n'; //그냥 출력하면됨
        }
        else if(cmd == "empty"){ //명령이 엠티라면
            cout << (int)iStack.empty() << '\n'; //엠티는 부울 값이라서 정수로 전환해주고 출력해주면 됨. true = 1, false = 0
        }
        else if(cmd == "top"){ //명령이 탑이라면
            if(iStack.empty()) //비어있는지 확인 후 
                cout << -1 << '\n'; //비어있다면 엠티는 불린 값이니깐 -1이라고 따로 출력한다.
            else
                cout << iStack.top() << '\n'; //아니라면 그냥 맨위에 있는 값 출력해줌
        }
    }
    return 0;
}
