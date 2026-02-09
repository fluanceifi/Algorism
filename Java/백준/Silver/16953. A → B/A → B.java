import java.util.*;
import java.io.*;

class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static int A, B;
    public static int cnt = 1;
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        while(B > A){
            if(B % 2 == 0){
                cnt++;
                B /= 2;
            } else if(B % 10 == 1){
                cnt++;
                B /= 10;
            } else{
                break;
            }
        }
        
        if(A == B){
            System.out.println(cnt);
        } else{
            System.out.println(-1);
        }
    }
}