import java.util.*;
import java.io.*;

class Main {
    public static int n, m;
    
    public static int[] arr;
    public static int[] result;
    public static int[] visited;
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        result = new int[m];
        visited = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        dfs(0);
        
        System.out.print(sb);
    }
    
    public static void dfs(int depth){
        if(depth == m){
            for(int i = 0 ; i < m ; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        int lastUsed = -1;
        for(int i = 0 ; i < n ; i++){
            if(visited[i] > m) continue;
            
            if(arr[i] == lastUsed) continue;

            if(depth > 0 && result[depth -1] > arr[i]) continue;

            lastUsed = arr[i];
            result[depth] = arr[i];
            
            visited[i]++;
            dfs(depth + 1);
            visited[i]--;
        }
    }
}