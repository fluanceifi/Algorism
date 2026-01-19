import java.util.*;
import java.io.*;

class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static int n, m, cnt;
    
    public static int[] visited = new int[101];
    public static ArrayList<ArrayList<Integer>> ladder = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> snake = new ArrayList<>();
    public static Queue<Integer> q = new LinkedList<>();
   
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        //0 ~ 100 초기화
        for(int i = 0 ; i < 101 ; i++){
            ladder.add(new ArrayList<Integer>());
            snake.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());        
            //u -> v로 가는 사다리 길 추가
            ladder
                .get(Integer.parseInt(st.nextToken()))
                .add(Integer.parseInt(st.nextToken()));
        }
        
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            //u -> v로 가는 뱀 길 추가
            snake
                .get(Integer.parseInt(st.nextToken()))
                .add(Integer.parseInt(st.nextToken()));
        }
        
        Arrays.fill(visited, -1);
        
        //로직
        q.add(1);
        visited[1] = 0;
        
        bfs();
        
        
        System.out.println(visited[100]);
        
    }
    
    public static void bfs(){
        while(!q.isEmpty()){
            int u = q.poll();
            
            for(int i = 1 ; i <= 6 ; i++){
                int v = u + i;
                
                if(v >= 100){
                    visited[100] = visited[u] + 1;
                    return;
                }
                    
                //사다리 경로가 있을 때
                if(!ladder.get(v).isEmpty()){
                    v = ladder.get(v).get(0);
                    if(visited[v] == -1){
                        q.add(v);
                        visited[v] = visited[u] + 1;
                    }
                }
                
                //뱀 경로가 있을 때
                if(!snake.get(v).isEmpty()){
                    v = snake.get(v).get(0);
                    if(visited[v] == -1){
                        q.add(v);
                        visited[v] = visited[u] + 1;
                    }
                }
                
                //아무 것도 없을 때,
                if(visited[v] == -1){
                    q.add(v);
                    visited[v] = visited[u] + 1;
                }
            }
        }
        
    }
}