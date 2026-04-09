import java.util.*;
import java.io.*;
class Edge{
    int from;
    int to;
    int weight;
    public Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int tc;
    static int n, m, w;
    static int[] dist;
    static List<Edge> edges;
    static int INF = (int) 1e9;
    
    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        
        for(int testcase = 0 ; testcase < tc ; testcase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            
            dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[1] = 0;
            edges = new ArrayList<>();
            
            // 간선 초기화
            for(int j = 0 ; j < m ; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }
            for(int k = 0 ; k < w ; k++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, -t));
            }
            // 최적 경로의 간선 개수는 최대 v-1개이다, 따라서 v-1번을 반복 후,
            for(int i = 1 ; i < n ; i++) {
                for(Edge e : edges) {
                    if(dist[e.to] > dist[e.from] + e.weight){
                        dist[e.to] = dist[e.from] + e.weight;
                    }
                }
            }
            
            // 마지막에 한번 더 순회하며 검증한다.
            boolean check = false;
            for(Edge e : edges) {
                if(dist[e.from] != INF && dist[e.to] > dist[e.from] + e.weight){
                    check = true;
                }
            }
            sb.append(check ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
        
    }
}