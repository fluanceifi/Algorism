import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static PriorityQueue minHeap;
    public static PriorityQueue maxHeap;
    public static HashMap<Integer, Integer> map;
    
    public static int tc;
    public static int n;

    public static StringTokenizer st;
    public static StringBuilder sb;
    public static BufferedReader br;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

       
        for(int testCase = 0 ; testCase < tc ; testCase++){
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();

            int n = Integer.parseInt(br.readLine());

            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine());

                String key = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if(key.equals("D")){
                    if(map.isEmpty()) continue;

                    if(value == -1){
                        delete(minHeap);
                    }
                    else{
                        delete(maxHeap);
                
                    }
                }
                else{ //key == "I"
                    map.put(value, map.getOrDefault(value, 0) + 1);
                    minHeap.offer(value);
                    maxHeap.offer(value);
                }
            }
            
            clean(minHeap);
            clean(maxHeap);
            
            if(minHeap.isEmpty() || maxHeap.isEmpty()){
                sb.append("EMPTY").append("\n");
            }
            else{
                sb.append(maxHeap.poll()).append(" ");
                sb.append(minHeap.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void delete(PriorityQueue<Integer> q){
        clean(q);

        if(!q.isEmpty()){
            int num = q.poll();

            int cnt = map.get(num);

            if(cnt == 1) map.remove(num);
            else map.put(num, cnt - 1);
        }
        
    }

    public static void clean(PriorityQueue<Integer> q){
        while(!q.isEmpty() && !map.containsKey(q.peek())){
            q.poll(); //비어있지않으면서, 맵에 해당 큐의 키가 없다면?
        }
    }
    
}