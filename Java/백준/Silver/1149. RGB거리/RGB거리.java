import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int n;
    
    public static int[][] dp;
    public static int[][] rgb;

    public static boolean[] isValid = new boolean[3];
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        rgb = new int[n][3];
        dp = new int[n][3];
        
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++){
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i < 3 ; i++){
            dp[0][i] = rgb[0][i];
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < 3 ; j++){
                
                if(j == 0){ // R
                    dp[i][j] = 
                        rgb[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
                    
                } else if(j == 1){ // G
                    dp[i][j] = 
                        rgb[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
                } else{ // B
                    dp[i][j] =
                        rgb[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
                }
            }
        }

    
        Arrays.sort(dp[n-1]);

        System.out.println(dp[n-1][0]);

        
        
    }
}