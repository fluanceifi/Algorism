import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    public static int[] arr;

    public static int n, m;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        backTracking(1, 0); //idx, depth
        System.out.println(sb);
    }

    public static void backTracking(int idx, int depth){
        if(depth == m){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx ; i <= n ; i++){
            arr[depth] = i;
            backTracking(i, depth + 1);
        }
    }
}