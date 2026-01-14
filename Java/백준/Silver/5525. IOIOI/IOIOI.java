import java.util.*;
import java.io.*;


class Main{
    public static int n, m, result, pattern;
    public static String s;
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        s = br.readLine();
        for(int i = 1 ; i < m - 1 ; i++){
            if(s.charAt(i-1) == 'I' && s.charAt(i) == 'O' && s.charAt(i+1) == 'I'){
                pattern++;

                if(pattern == n){
                    result++;
                    //만약 n이 2개라면 pattern은 1이되는데, IOIOIOI 라고치면 0~4, 2~6의 범위를 검사해야되므로 하나를 남김.
                    pattern--; 
                }
                i++; //이미 파악했으니, 한칸 건너뛰기
                
            }
            else{
                pattern = 0;
            }
        }

        System.out.println(result);
    }
}