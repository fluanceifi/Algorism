import java.util.*;
import java.io.*;

class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    
    public static int n;
    
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {        @Override
        public int compare(Integer a, Integer b){
            if(Math.abs(a) == Math.abs(b)){
                return a - b; //원래대로
            }
            else{
                return Math.abs(a) - Math.abs(b); //반대로
            }
        }
        
    });
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < n ; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){
                if(pq.isEmpty()){
                    sb.append(0).append('\n');
                }
                else{
                    sb.append(pq.poll()).append('\n');
                }
            }
            else{
               pq.offer(val);
            }
        }
        
        System.out.print(sb);
        
    }
}