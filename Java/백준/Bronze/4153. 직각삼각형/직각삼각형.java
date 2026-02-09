import java.util.*;
import java.io.*;

class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static double a = -1, b = -1, c = -1;
    public static double[] arr = new double[3];
    public static void main(String[] args) throws IOException{
        while(true){
            st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            if(a == 0 && b == 0 && c == 0) break;
            
            arr[0] = Math.pow(a, 2);
            arr[1] = Math.pow(b, 2);
            arr[2] = Math.pow(c, 2);
            
            Arrays.sort(arr);
            
            if(arr[0] + arr[1] == arr[2]) sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }
        System.out.print(sb);
    }
}