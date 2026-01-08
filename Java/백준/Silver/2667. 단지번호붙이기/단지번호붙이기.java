import java.util.*;
import java.io.*;

class Node{
    private int y;
    private int x;

    public Node(int y, int x){
        this.y = y;
        this.x = x;
    }

    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    
}


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int n;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] result;

    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];
        result = new int[10000];
        
        for(int i = 0 ; i < n ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = s.charAt(j) - '0'; // Integer.parseInt 는 String을 Int로 ... 이건 char라 안됨
            }
        }

        int group = 1;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visited[i][j]){
                    if(arr[i][j] == 0)
                        visited[i][j] = true;
                    else{
                        bfs(i, j, group);
                        group++;
                    }
                }
            }
        }

        sb.append(group - 1).append('\n');

        Arrays.sort(result);

        for(int i = 0 ; i < 10000 ; i++){
            if(result[i] != 0)
                sb.append(result[i]).append('\n');
        }

        System.out.print(sb);
    }

    public static void bfs(int y, int x, int group){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x));
        visited[y][x] = true;
        result[group]++;
        
        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int ny = now.getY() + dy[i];
                int nx = now.getX() + dx[i];
                
                if(ny >=  n || nx >= n || ny < 0 || nx < 0 || visited[ny][nx]) continue;

                if(arr[ny][nx] == 1 && !visited[ny][nx]){
                    result[group]++;
                    visited[ny][nx] = true;
                    q.offer(new Node(ny, nx));
                }
                
            }
        }
        
    }
}