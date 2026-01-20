import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    public static int T;
    public static Deque<String> dq;
    public static String[] arr;
    
    public static void makeString(Deque<String> dq, boolean isReverse){
        int size = dq.size();
    
        sb.append("[");
        if(!isReverse){
            for(int i = 0 ; i < size ; i++){
                if(i == size - 1){
                    sb.append(dq.pollFirst());
                }
                else{
                    sb.append(dq.pollFirst()).append(",");
                }
            }
        }   
        else{
            for(int i = 0 ; i < size ; i++){
                if(i == size - 1){
                    sb.append(dq.pollLast());
                }
                else{
                    sb.append(dq.pollLast()).append(",");
                }               
            }
        }
        
        sb.append("]\n");
    }

    
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            dq = new LinkedList<>();

            if(n > 0){
                arr = s.substring(1, s.length() - 1).split(","); // [ ... ] 제거, "," 제거 
                for(String val : arr) dq.add(val);
            }
            

            boolean isReverse = false;
            boolean isError = false;

            for(char c : cmd.toCharArray()){
                if(c == 'R'){
                    isReverse = !isReverse;
                }
                //c == 'D'
                else{
                    //예외처리
                    if(dq.isEmpty()){
                        isError = true;
                        break;
                    }

                    if(isReverse){
                        dq.removeLast();
                    }
                    else{
                        dq.removeFirst();
                    }
                }
            }

            if(isError){
                sb.append("error\n");
            }
            else{
                makeString(dq, isReverse);
            }
            
        }
        System.out.println(sb);
    }
}