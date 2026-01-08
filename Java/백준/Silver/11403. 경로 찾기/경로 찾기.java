import java.util.*;
import java.io.*;

class Main{
    public static int n;
    public static int[][] map;
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    
    
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        fload();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
    }
    
    public static void fload(){
        
        
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0; j < n ; j++){
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                    }
                }
            }
        }
        
        
    }
}