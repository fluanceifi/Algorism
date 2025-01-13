#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <queue>
#include <list>
#include <map>
#include <set>
#include <cmath>
#include <algorithm>
#include <stack>
#include <cstring>
using namespace std;

// 상, 우, 하, 좌
int dx[4] = {-1, 0, 1, 0}; 
int dy[4] = {0, 1, 0, -1};  

#define X first
#define Y second

string miro[1001]; //미로에 대한 1차원 배열
int dist_F[1001][1001]; // 불에 대한 2차원 배열
int dist_J[1001][1001]; // 지훈에 대한 2차원 배열

int i, j, r, c, dir, nx, ny; 

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> r >> c;

    for(i = 0 ; i < r ; i++) cin >> miro[i];
    
        
    
    for(i = 0 ; i < r ; i++){
        fill(dist_F[i], dist_F[i]+c, -1);
        fill(dist_J[i], dist_J[i]+c, -1);
    }

    queue<pair<int,int> > Q_F;
    queue<pair<int,int> > Q_J;

    for(i = 0 ; i < r ; i++){
        for(j = 0 ; j < c ; j++){
            if(miro[i][j] == 'F'){
                Q_F.push(make_pair(i,j));
                dist_F[i][j] = 0;
            }
            if(miro[i][j] == 'J'){
                Q_J.push(make_pair(i,j));
                dist_J[i][j] = 0;
            }
        }
    }

    // 불 길에 대한 배열 요소들의 값
    while(!Q_F.empty()){
        pair<int, int> cur = Q_F.front();
        Q_F.pop();

        for(dir = 0 ; dir < 4 ; dir++){
            nx = cur.X + dx[dir];
            ny = cur.Y + dy[dir];
             //불이 미로의 범위를 넘어서면 패스
            if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            //벽이거나 이미 불이 붙은 곳이라면 패스
            if(miro[nx][ny] == '#' || dist_F[nx][ny] >= 0 ) continue; 
            Q_F.push(make_pair(nx,ny));
            dist_F[nx][ny] = dist_F[cur.X][cur.Y] + 1;
        }
       
    }

    // 지훈이에 대한 배열 요소의 값
    while(!Q_J.empty()){
        pair<int, int> cur = Q_J.front();
        Q_J.pop();

        for(dir = 0 ; dir < 4 ; dir++){
            nx = cur.X + dx[dir];
            ny = cur.Y + dy[dir];
            //만약 2차원 배열의 범위를 넘어가게되면 탈출 성공이므로 종료.
            if(nx < 0 || ny < 0 || nx >= r || ny >= c){
                cout << dist_J[cur.X][cur.Y] + 1; 
                return 0;
            } 
            //이미 방문한 곳이거나 벽이라면 패스
            if(miro[nx][ny] == '#' || dist_J[nx][ny] >= 0) continue;
            //현재 위치에서 다음 위치로 갈 때 불이 번지는 속도가 더 빠르다면 의미없으니 패스
            if(dist_F[nx][ny] != -1 && dist_J[cur.X][cur.Y] + 1 >= dist_F[nx][ny]) continue;
            Q_J.push(make_pair(nx,ny));
            dist_J[nx][ny] = dist_J[cur.X][cur.Y] + 1;    
        }
        
    }

    cout<< "IMPOSSIBLE";
    return 0;
}