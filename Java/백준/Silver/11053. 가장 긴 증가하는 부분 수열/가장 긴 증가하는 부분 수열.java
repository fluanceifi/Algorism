import java.util.*;
import java.io.*;

class Main{
    public static int n;
    
    public static int[] arr;
    public static int[] dp;
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        
        int result = dp[0];
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }
        
        System.out.println(result);
    }
}