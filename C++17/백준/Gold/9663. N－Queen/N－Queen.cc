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

int cnt = 0, n;
vector<int> col;


bool promising(int cur){
    int idx = 0;
    while(idx < cur){
        if(col[cur] == col[idx] || abs(col[cur] - col[idx]) == cur - idx){
            return false;
        }
        idx++;
    }
    return true;
}


void queens(int cur){
    int j; //index

    if(cur == n){
        cnt++;
        return;
    }

    for(j = 1; j <= n ; j++){
        col[cur] = j; //col번째 행, j번째 열
        if(promising(cur)){
            queens(cur+1);
        }
    }
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    col.resize(n);

    queens(0);
    
    cout << cnt << '\n';
}