import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int n;

    public static int[] arr;
    public static int[] LIS; // Longest Increasing Subsequence
    public static int[] LDS; // Longest Decreasing Subsequence
    public static int[] result;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        LIS = new int[n];
        LDS = new int[n];
        result = new int[n];

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            LIS[i] = 1;
            LDS[i] = 1;
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[i] > arr[j]){
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        // for(int i = 0 ; i < n ; i++){
        //     System.out.print(LIS[i] + " ");
        // }
        // System.out.println();

        for(int i = n-2 ; i >= 0 ; i--){
            for(int j = n-1 ; j > i ; j--){
                if(arr[i] > arr[j]){
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        // for(int i = 0 ; i < n ; i++){
        //     System.out.print(LDS[i] + " ");
        // }
        // System.out.println();
        
        
        for(int i = 0 ; i < n ; i++){
            result[i] = LIS[i] + LDS[i];
        }

        Arrays.sort(result);

        System.out.println(result[n-1] - 1);
        
    }
}