import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;

    static int[][] house;
    static int[][][] dp;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        house = new int[n][n];
        
        for(int i = 0 ; i < n ; i++) { 
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n][3]; // [][][0] = 가로, [][][1] = 세로, [][][2] =대각
        dp[0][1][0] = 1; // 최초

        for(int i = 0 ; i < n ; i++){
            for(int j = 2 ; j < n ; j++){
                if(house[i][j] == 1) continue;
                
                // 가로: 이전 가로 혹은 대각
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]; 

                // 세로: 이전 세로 혹은 대각
                if(i > 0){
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                }
                
                // 대각: 이전 가로, 세로, 대각
                if(i > 0 && house[i-1][j] == 0 && house[i][j-1] == 0) {
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }

        System.out.println(dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2]);
        
    }
}