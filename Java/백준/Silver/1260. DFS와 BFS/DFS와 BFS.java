import java.util.*;
import java.io.*;

public class Main{

    public static int n, m, v;
    public static ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
    public static boolean[] visited;
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= n ; i++)
            arrList.add(new ArrayList<>());

        visited = new boolean[n+1];

        for(int i = 0 ; i < m ; i++){
            s = br.readLine();
            st = new StringTokenizer(s, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //양방향
            arrList.get(a).add(b);
            arrList.get(b).add(a);
        }
        for(int i = 1 ; i <= n ; i++)
            Collections.sort(arrList.get(i));

        dfs(v);
        System.out.println();
        Arrays.fill(visited, false);

        bfs(v);

    }

    public static void dfs(int v){
        if(visited[v])
            return;

        visited[v] = true;
        System.out.print(v + " ");

        for(int i = 0 ; i < arrList.get(v).size() ; i++){
            int next = arrList.get(v).get(i);
            if(!visited[next]){
                dfs(next);
            }
        }

    }

    public static void bfs(int v){
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            System.out.print(now + " ");

            for(int i = 0 ; i < arrList.get(now).size() ; i++){
                int next = arrList.get(now).get(i);
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }

        }
    }


}