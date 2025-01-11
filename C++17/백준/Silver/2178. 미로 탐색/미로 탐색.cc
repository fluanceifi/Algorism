#include <iostream>
#include <vector>
#include <queue>
using namespace std;

// 상, 우, 하, 좌
int dx[4] = {-1, 0, 1, 0}; 
int dy[4] = {0, 1, 0, -1};  

#define X first
#define Y second

string board[101];
int dist[101][101];

int i, j, n, m;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for(i = 0 ; i < n ; i++){
        cin >> board[i];
        for(j = 0 ; j < m ; j++)
            dist[i][j] = -1;
    }
    queue<pair<int, int> > Q;
    Q.push(make_pair(0,0));
    dist[0][0] = 0;

    while(!Q.empty()){
        pair<int, int> cur = Q.front();
        Q.pop();
        for(i = 0 ; i < 4 ; i++){
            int x = cur.X + dx[i];
            int y = cur.Y + dy[i];
            if(x < 0 || y < 0 || x >= n || y >= m) continue;
            if(dist[x][y] >= 0 || board[x][y] != '1') continue;
            Q.push(make_pair(x,y));
            dist[x][y] = dist[cur.X][cur.Y] + 1;
        }
    }
    cout << dist[n-1][m-1] + 1; //시작점의 거리를 초기화 할 때 0으로 초기화 하기 때문에
                                // 거리와 방문횟수는 1의 차이가 나게된다.
}
