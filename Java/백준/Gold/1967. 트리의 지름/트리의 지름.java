import java.util.*;
import java.io.*;

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
}

class Main {
    public static int n;
    public static int farNode = 1;
    public static int max;
    
    public static List<Edge>[] graph;
    
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        
        graph = new List[n + 1];
        for(int i = 0 ; i < n + 1 ; i++) graph[i] = new ArrayList<>();

        for(int i = 0 ; i < n - 1 ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        visited = new boolean[n + 1];
        dfs(1, 0); //vertex, value
        
        int start = farNode;
        max = 0;
        
        visited = new boolean[n + 1];
        dfs(start, 0); // 실제 거리측정은 여기서

        System.out.println(max);
        
    }

    public static void dfs(int vertex, int cumulativeWeight) {
        
        // 1. 방문 처리
        visited[vertex] = true;

        // 2. 최대 값 & 가장 먼 노드 갱신
        if(cumulativeWeight > max){
            max = cumulativeWeight;
            farNode = vertex;
        }

        // 3. 재귀
        for(Edge next : graph[vertex]){
            if(visited[next.to]) continue;

            dfs(next.to, cumulativeWeight + next.weight);
            
        }
    }
}