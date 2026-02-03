import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int n, m, cnt;
    public static int[] arr;
    public static boolean[] visited;
    public static int[] result;
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        result = new int[n];
        
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        System.out.print(sb);
    }

    public static void dfs(int depth){
        if(depth >= m){
            for(int i = 0 ; i < m ; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false; //재귀로 방문이 다되었으면, 풀어줘야 이전 depth에서 사용할 수 있다..
                //쉽게 생각하면 트리를 그려보면 좋다
            }
        }


        
    }
}