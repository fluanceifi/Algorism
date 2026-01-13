import java.util.*;
import java.io.*;

public class Main{
    public static int n;
    public static int normal, colorBlind;
    
    public static char[][] picture;
    public static boolean[][] normalVisited;
    public static boolean[][] colorBlindVisited;
    public static int[] dy = {-1, 0, 1, 0}; //북 동 남 서
    public static int[] dx = {0, 1, 0, -1};
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    
    
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        
        picture = new char[n][n];
        normalVisited = new boolean[n][n];
        colorBlindVisited = new boolean[n][n];
        
        
        for(int i = 0 ; i < n ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < n ; j++){
                picture[i][j] = s.charAt(j);
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!normalVisited[i][j]){
                    dfs(i, j, 1);
                    normal++;
                }
                if(!colorBlindVisited[i][j]){
                    dfs(i, j, 2);
                    colorBlind++;
                }
            }
        }
        
        System.out.println(normal + " " + colorBlind);
    }
    
    public static void dfs(int y, int x, int cls){
        
        if(cls == 1){
            if(!normalVisited[y][x])
                normalVisited[y][x] = true;
            else
                return;
        }
        else{
            if(!colorBlindVisited[y][x])
                colorBlindVisited[y][x] = true;
            else
                return;
        }
        
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
            
            if(cls == 1){
                if(!normalVisited[ny][nx] && picture[ny][nx] == picture[y][x])
                    dfs(ny, nx, cls);
            }
            else{
                char curr = picture[y][x];
                char next = picture[ny][nx];
                
                if(!colorBlindVisited[ny][nx]){
                    if(curr == 'B'){
                        if(next == 'B') dfs(ny, nx, cls);
                    }
                    else{
                        if(next == 'G' || next == 'R') dfs(ny, nx, cls);
                    }
                }
            
            }
        }
    }
}
