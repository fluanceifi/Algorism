import java.util.*;
import java.io.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        
        int num = 0;
        int count = 0;
        
        while(count < n){
            num++;
            
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
        
        System.out.println(num);
    }
}