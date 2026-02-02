import java.util.*;
import java.io.*;

class Main {
    public static int tc;
    public static int n;

    public static StringBuilder sb;
    public static StringTokenizer st;
    public static BufferedReader br;

    public static PriorityQueue<Integer> minHeap;
    public static PriorityQueue<Integer> maxHeap;
    public static HashMap<Integer, Integer> map;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());

        for(int testCase = 0 ; testCase < tc ; testCase++){
            n = Integer.parseInt(br.readLine());

            sb = new StringBuilder();
            minHeap = new PriorityQueue<Integer>();
            maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
            map = new HashMap<>();
            

            for(int i = 0 ; i < n ; i++){

                st = new StringTokenizer(br.readLine());
                String key = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if(key.equals("D")){
                    if(val == -1){
                        delete(minHeap);
                    }
                    else{
                        delete(maxHeap);
                    }
                }
                else{
                    map.put(val, map.getOrDefault(val, 0) + 1);
                    minHeap.offer(val);
                    maxHeap.offer(val);
                }
            }
            //반복문이 종료되면, 마지막에 동기화가 안되어있으므로 한번 더 해준다.
            clean(minHeap);
            clean(maxHeap);
            
            if(minHeap.isEmpty() || maxHeap.isEmpty()){
                sb.append("EMPTY").append("\n");
            }
            else{
                sb.append(maxHeap.poll()).append(" ");
                sb.append(minHeap.poll()).append("\n");
            }        
            System.out.print(sb);
            
        }

        
    }
    
    public static void delete(PriorityQueue<Integer> q) {
        //1. 일단 맵 동기화시킴
        clean(q);
        
        if(!q.isEmpty()){
            int num = q.poll();
            int cnt = map.get(num);
            
            //하나밖에 안남았으면 삭제시킴
            if(cnt == 1) 
                map.remove(num); 
            //그게 아니라면 하나 감소시킴
            else 
                map.put(num, cnt - 1); 
        }
    }

    public static void clean(PriorityQueue<Integer> q){
        /*
        * 동기화 시키는 로직
        * 1. 큐가 비어있지 않으면서,
        * 2. 큐의 맨 앞의 값을 확인하고, 해당 값이 HashMap에 존재하지않는다면?
        * 3. 삭제한다.
        */
        while(!q.isEmpty() && !map.containsKey(q.peek())){
            q.poll();
        }
    }
}
