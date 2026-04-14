import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, E;
    static int v1, v2;
    static int result;
    static int INF = (int) 1e9;
    
    static List<int[]>[] graph;
    static int[] dist;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i = 0; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c}); 
            graph[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken()); v2 = Integer.parseInt(st.nextToken());
        
        int[] dn = dijkstra(1);
        int[] dv1 = dijkstra(v1);
        int[] dv2 = dijkstra(v2);
        
        long result = Math.min((long) dn[v1] + dv1[v2] + dv2[N],
                             (long) dn[v2] + dv2[v1] + dv1[N]);

        if(result >= (long) INF){
            result = -1;
        }
        System.out.println(result);
        
    }

    public static int[] dijkstra(int start) {        
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.offer(new int[]{start, 0}); //vertex, wieght

        while(!pq.isEmpty()) {
            int[] current = pq.poll();

            if(current[1] > dist[current[0]]) continue; 
            
            for(int[] next : graph[current[0]]) {
                if(dist[next[0]] > next[1] + current[1]) {
                    dist[next[0]] = next[1] + current[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        return dist;
    }
}