import java.util.*;
import java.io.*;

class Main{
    public static int n;
    public static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    public static int[] parent;
    public static boolean[] visited;
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        visited = new boolean[n+1];
        
        for(int i = 0 ; i <= n ; i++){
            tree.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < n - 1 ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(1);

        for(int i = 2 ; i <= n ; i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int current){
        visited[current] = true;

        for(int next : tree.get(current)){
            if(!visited[next]){
                parent[next] = current;
                dfs(next);
            }
        }
    }
}