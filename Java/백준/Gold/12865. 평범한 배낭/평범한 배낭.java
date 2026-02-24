import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k;

    static int[] weight;
    static int[] value;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        weight = new int[n + 1];
        value = new int[n + 1];
        dp = new int[n+1][k+1];

        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());

            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1 ; i <= n ; i++){
            for(int w = 1 ; w<= k ; w++){
                
                if(weight[i] > w){
                    dp[i][w] = dp[i-1][w];
                }
                else{
                    dp[i][w] = Math.max(dp[i-1][w], 
                                       value[i] + dp[i-1][w - weight[i]]);
                }
            }
        }

        System.out.println(dp[n][k]);

        
    }
}