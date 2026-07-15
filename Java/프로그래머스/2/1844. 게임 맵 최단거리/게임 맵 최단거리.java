// import java.util.*;

// class Solution {
//     public static int[] dy = {-1, 0 , 1, 0}; //북 동 남 서 
//     public static int[] dx = {0, 1, 0 , -1};
//     public static int minDist;
    
//     public int solution(int[][] maps) {
//         int n = maps.length;
//         int m = maps[0].length;
        
//         minDist = (int) 1e9;

        
//         boolean[][] visited = new boolean[n][m];
//         visited[0][0] = true;
        
//         dfs(0, 0, 1, maps, visited);
        
//         return minDist == (int) 1e9 ? -1 : minDist;
//     }
    
//     public static void dfs(int cy, int cx, int cnt, int[][] maps, boolean[][] visited) {
//         int n = maps.length;
//         int m = maps[0].length;
        
//         // 종료 조건 확인
//         if(cy == n-1 && cx == m-1){
//             minDist = Math.min(minDist, cnt);
//             return;
//         }
        
//         // 가지치기
//         if(cnt >= minDist) return;
        
        
//         // 다음 위치 방문
//         for(int i = 0 ; i < 4 ; i++){
//             int ny = cy + dy[i];
//             int nx = cx + dx[i];
            
//             if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
//             // 방문안했으면 dfs
//             if(maps[ny][nx] == 1 && !visited[ny][nx]) {
//                 visited[ny][nx] = true;
//                 dfs(ny, nx, cnt + 1, maps, visited);
//                 visited[ny][nx] = false;
//             }
//         }
        
//     }
// }
import java.util.*;

class Node {
    int y;
    int x;
    
    public Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}

class Solution {
    public static int[] dy = {-1, 0 , 1, 0}; //북 동 남 서 
    public static int[] dx = {0, 1, 0 , -1};
    public static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[n][m];
        
        queue.offer(new Node(0, 0));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            for(int i = 0 ; i < 4 ; i++){
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                
                // 1. 배열 이탈
                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                // 2. 예외조건: 벽
                if(maps[ny][nx] != 1) continue;
                
                maps[ny][nx] = maps[cur.y][cur.x] + 1;
                queue.offer(new Node(ny, nx));
            }
        }
        
        return maps[n-1][m-1] == 1 ? -1 : maps[n-1][m-1];
    }
}