import java.util.*;
import java.io.*;

class Main {
    public static int INF = (int)1e9;
    public static int V, E, K;
    static List<int[]>[] graph;
    static int[] result;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        result = new int[V+1];
        Arrays.fill(result, INF);
        result[K] = 0;
        
        graph = new ArrayList[V+1];
        for(int i = 0 ; i < V+1 ; i++) graph[i] = new ArrayList<>();


        for(int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[]{v, w});
        }

        dejikstra();
        
        for(int i = 1 ; i <= V ; i++){
            sb.append(result[i] == INF ? "INF" : result[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dejikstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{K, 0}); // v, w
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int node = now[0];
            int dist = now[1];

            if(dist > result[node]) continue; // 이미 더 짧은 경로로 갱신된 노드

            for(int next[] : graph[node]){
                int nextNode = next[0];
                int nextDist = next[1] + dist;

                if(result[nextNode] > nextDist){
                    pq.offer(new int[]{nextNode, nextDist});
                    result[nextNode] = nextDist;
                }
            }
        }
    }
}