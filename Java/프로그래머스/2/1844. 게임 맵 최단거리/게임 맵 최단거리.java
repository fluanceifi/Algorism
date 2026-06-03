import java.util.*;
class Node {
    int y;
    int x;
    
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    public static int[] dy = {-1, 0 , 1, 0}; //북 동 남 서 
    public static int[] dx = {0, 1, 0 , -1};
    
    public int solution(int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        
        int n = maps.length;
        int m = maps[0].length;
        
        
        q.add(new Node(0, 0));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if(cur.y == n-1 && cur.x == m-1) break;
            
            for(int i = 0 ; i < 4 ; i++) {  
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                
                if(ny >= n || ny < 0 || nx >= m || nx < 0 ) continue;
                
                if(maps[ny][nx] != 1) continue;
                
                q.add(new Node(ny, nx));
                maps[ny][nx] = maps[cur.y][cur.x] + 1;
            }
        }
        
        return maps[n-1][m-1] == 1 ? -1 : maps[n-1][m-1];
    }
}