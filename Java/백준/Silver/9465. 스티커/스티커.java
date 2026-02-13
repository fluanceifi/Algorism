import java.util.*;
import java.io.*;

class Main{
    public static BufferedReader br;
    public static StringTokenizer st;
    public static StringBuilder sb;
    
    public static int[][] sticker;
    public static int[][] dp;
    
    public static int t, n;
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        
        t = Integer.parseInt(br.readLine());
        
        for(int test = 0 ; test < t ; test++) {
            
            
            n = Integer.parseInt(br.readLine());
            
            sticker = new int[2][n];
            dp = new int[2][n];
             
            // 배열 초기화
            for(int i = 0 ; i < 2 ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < n ; j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];

            if (n > 1) {
                dp[0][1] = sticker[0][1] + dp[1][0];
                dp[1][1] = sticker[1][1] + dp[0][0];
            }

            
            for(int j = 2 ; j < n ; j++) {
                for(int i = 0 ; i < 2 ; i++) {
                    //대각선만 취할 수 있다.
                    
                    if(i == 0){
                        dp[i][j] =
                            sticker[i][j] + Math.max(dp[i+1][j-1], dp[i+1][j-2]);
                    }
                    
                    if(i == 1){
                        dp[i][j] =
                            sticker[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j-2]);
                    }
                }
            }
            sb.append(Math.max(dp[0][n-1], dp[1][n-1])).append("\n");
            
        }
        System.out.print(sb);
    }
}