import java.util.*;
import java.io.*;

class Main{
    public static int n, m, result;
    
    public static int[] dy = {-1, 0, 1, 0}; //북 동 남 서
    public static int[] dx = {0, 1, 0, -1};
    public static int[][] paper;
    public static boolean[][] visited;
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        paper = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]); //y, x, depth, val(더해지는 값)
                visited[i][j] = false;
                
            }
        }
        
        System.out.println(result);
    }
    
    public static void dfs(int y, int x, int depth, int val){
        // 종료 조건
        if(depth == 4){
            result = Math.max(result, val);
            return;
        }
        
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny >= n || nx >= m || ny < 0 || nx < 0) continue;
            
            if(!visited[ny][nx]){
                
                //5번째 모형(보라색)은 한번 멈추고 나아갈 방향을 막아줘야 모양이 완성된다.
                if(depth == 2){
                    visited[ny][nx] = true;//직선 금지
                    dfs(y, x, depth + 1, val + paper[ny][nx]); //하지만 값은 포함하여 ㅗ,ㅏ,ㅜ,ㅓ 값이 가능하도록 함
                }
                
                visited[ny][nx] = true;
                dfs(ny, nx, depth + 1, val + paper[ny][nx]);
                visited[ny][nx] = false;
            }
                
        }
    }
}