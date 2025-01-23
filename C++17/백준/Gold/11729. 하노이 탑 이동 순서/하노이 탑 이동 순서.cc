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
int a = 1, b =3, k; // a = 시작, b = 도착 , n AND k = 원판

/*
기둥은 총 3개로 1, 2, 3으로 나눈다. 이 모든 기둥을 더한 값은 6.
즉 a에서 b로 갈 때 남는 기둥을 6 - a - b로 계산이 가능한 것.

하노이탑 문제 풀이 방법 : 
    1. n-1개의 원판을 기둥 a에서 기둥 6-a-b로 옮긴다.
    2. n번 원판을 기둥 a에서 기둥 b로 옮긴다.
    3. n-1개의 원판을 기둥 6-a-b에서 기둥 b로 옮긴다.

해당 식을 코드로 나열해보면 
    1. hanoi(a, 6-a-b, n-1);
    2. if(n == 1) cout << a << ' ' << b << '\n';
    3. hanoi(6-a-b, b, n-1);
*/

void hanoi(int a, int b , int n){
    if(n == 1) { // 맨 바닥에 있는 원판까지 오면 a, b로 옮겨줌.
        cout << a << ' ' << b << '\n';
        return;
    }
    hanoi(a, 6 - a - b, n - 1); //남는 기둥에 나머지를 다 옮겨두고,
    cout << a << ' ' << b << '\n'; //옮길 때 마다 상태를 출력해줌.
    hanoi(6-a-b, b, n-1); //이제 남은 기둥을 도착 기둥까지 다시 옮김.
}


int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> k;    
    // 비트연산자라서 1 == 0001를 왼쪽으로 k번 옮김 즉 k= 3일 때 1000이 되고 이건 2^3으로 8, 8-1= 7이 최소횟수
    cout << (1 << k) - 1 << '\n'; 
    hanoi(a, b, k);
}