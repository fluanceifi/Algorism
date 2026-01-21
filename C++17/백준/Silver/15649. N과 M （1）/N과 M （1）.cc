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

int n,m; //n까지의 m개를 고른 수열
int arr[10]; //수열을 담을 배열
bool isused[10]; //특정 수 사용 여부 확인용 [1] = 1 [9] = 9

void func(int k){
    if(k == m){ // 4. 재귀로 k+1씩 늘어나다보면 m과 같아질 때
        for(int i = 0 ; i < m ; i++) cout << arr[i] << ' '; // 5. 수열을 출력하고 return;
        cout << '\n';
        return;
    }

    for(int i = 1 ; i <= n ; i++){
        if(!isused[i]){
            arr[k] = i; // 1. 최초에 k는 0으로 시작, i = 1이니깐 arr[0] = 1;
            isused[i] = 1; // 2. isused[1] = 1이 되면서 '1'을 사용했다는 걸 확인.
            func(k + 1); // 3. k값이 계속 증가하면서 재귀가 될 시 (!isused[i])에 맞춰 arr[1], [2], [3], ... 에 index와 동일한 값이 들어간다. 
            isused[i] = 0; // 6. 4 3을 입력했을 때 4까지의 3개를 고르는 것이므로, 123출력 -> isused[3] = 0, 124출력 -> isused[4] = 0 이 된다. 즉 모든 과정을 끝낸 경우 0으로 설정하게 됨.
            //백트랙킹으로 k가 0일때 첫번째 열이 1, 2, 3, 4  k가 1일때 두번째 열이 1, 2, 3, 4 ... k가 k+1일 때 k+1번째 열이 1, 2, 3, 4 ... 이런식으로 각 열에 대해 백트랙킹으로 모두 방문한다.
            //여기서 isused가 중복되는 수를 제거해줌으로써 수열이 완성되는 것이다. 
        }
    }
}


int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m ;
    func(0); // 0으로 시작
}