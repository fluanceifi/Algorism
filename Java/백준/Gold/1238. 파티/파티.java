import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M, X;

    static List<int[]>[] graph;
    static List<int[]>[] reverseGraph;
    
    static int[] xFrom;
    static int[] xTo;
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); X = Integer.parseInt(st.nextToken());

        xFrom = new int[N+1]; xTo = new int[N+1];
        
        Arrays.fill(xFrom, (int) 1e9);
        Arrays.fill(xTo, (int) 1e9);

        graph = new ArrayList[N+1]; reverseGraph = new ArrayList[N+1];

        for(int i = 0 ; i < N+1 ; i++){
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // u -> v == X to v (X에서 집으로 돌아가는 길)
            graph[u].add(new int[]{v, w});

            // v -> u == X from v (집에서 X로 가는 길)
            reverseGraph[v].add(new int[]{u, w});
        }

        // X에서 집으로 돌아가는 길
        dijkstra(graph, xTo, X);

        // 집에서 X로 가는 길
        dijkstra(reverseGraph, xFrom, X);
        
        int result = 0;

        for(int i = 1 ; i < N+1 ; i++){
            int temp = xFrom[i] + xTo[i];
            
            if(result < temp){
                result = temp;
            }
            
        }
        
        System.out.println(result);
        
    }

    public static void dijkstra(List<int[]>[] grp, int[] dist, int point) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        dist[point] = 0; 
        pq.offer(new int[]{point, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int currVertex = curr[0];
            int currWeight = curr[1];

            if(dist[currVertex] < currWeight) continue;

            for(int[] next : grp[currVertex]) {
                if(dist[next[0]] > next[1] + currWeight) {
                    dist[next[0]] = next[1] + currWeight;
                    pq.offer(new int[]{next[0], dist[next[0]]});
                } 
            }
                
                
        }
            
    }
    
}