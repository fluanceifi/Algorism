import java.util.*;
import java.io.*;

class Main{
    public static int n, m;
    public static int[] arr;
    public static int[] result;
    public static boolean[] visited;
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        result = new int[m];
        visited = new boolean[n];
        
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
        
        for(int j = 0 ; j < n ; j++){
            //중복 방문 금지
            if(visited[j]) continue;

            //중복 값 선택 금지
            if(lastUsed == arr[j]) continue;
            
            //방문처리
            visited[j] = true;

            //depth가 index가 되어, 저장시킨다.
            result[depth] = arr[j];
            
            //1. 같은 depth에서는 lastUsed가 중복값을 제외시켜주는 역할.
            //2. 재귀 시, 이전 depth의 lastUsed와 별개인 지역변수 이기 때문에 "9 9"와 같은 값의 쌍이 출력 될 수 있다.
            lastUsed = arr[j]; 
            
            //재귀
            dfs(depth + 1);
            
            //방문해제
            visited[j] = false;
            
        }
    }
}