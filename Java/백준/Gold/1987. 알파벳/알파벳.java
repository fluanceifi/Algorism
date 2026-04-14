import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static int r, c, result;
    public static boolean[] visited = new boolean[98];
    public static char[][] board;

    public static int[] dy = {-1, 0, 1, 0}; //북동남서
    public static int[] dx = {0, 1, 0, -1};
    
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());

        board = new char[r][c];

        for(int i = 0 ; i < r ; i++) {
                String s = br.readLine();
            for(int j = 0 ; j < c ; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        visited[board[0][0]] = true;
        dfs(1, 0, 0);

        System.out.println(result);
    }
    
    public static void dfs(int depth, int y, int x) {
        if(depth > result) {
            result = depth;
        }
        for(int i = 0 ; i < 4 ; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;

            if(visited[board[ny][nx]]) continue;
            
            visited[board[ny][nx]] = true;

            dfs(depth + 1, ny, nx);

            visited[board[ny][nx]] = false;
            
        }
        
    }
}