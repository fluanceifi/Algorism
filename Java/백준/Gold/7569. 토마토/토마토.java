import java.util.*;
import java.io.*;

class Node{
    private int z;
    private int y;
    private int x;

    public Node(int z, int y, int x){
        this.z = z;
        this.y = y;
        this.x = x;
    }

    public int getZ(){
        return z;
    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }
}

class Main {
    public static int h, n, m, result;
    public static int[][][] box;
    public static boolean[][][] visited;
    public static int[] dy = {-1, 0, 1, 0}; //북동남서
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dz = {-1, 1}; //위층, 아래층

    public static Queue<Node> q = new LinkedList<>();

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];


        for(int k = 0 ; k < h ; k++){
            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < m ; j++){
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                    if(box[k][i][j] == 1) q.offer(new Node(k, i, j));
                }
            }
        }

        bfs();

        for(int k = 0 ; k < h ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(box[k][i][j] == 0){
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, box[k][i][j]);
                }
            }
        }

        System.out.println(result-1);

        
    }

    public static void bfs(){
        
        while(!q.isEmpty()){
            Node now = q.poll();

            int cz = now.getZ();
            int cy = now.getY();
            int cx = now.getX();

            //2차원
            for(int i = 0 ; i < 4 ; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                

                //out of index
                if(ny >= n || nx >= m || ny < 0 || nx < 0) continue;

                //Requirement
                if(box[cz][ny][nx] != 0) continue; //들어있지 않거나, 이미 익은 토마토는 패스

                //추가
                q.offer(new Node(cz, ny, nx));

                //퍼지는 날짜를 적는다. (마지막에 -1만 해주면 딱 맞음.)
                box[cz][ny][nx] = box[cz][cy][cx] + 1;
                
            }
            
            //3차원
            for(int i = 0 ; i < 2 ; i++){
                int nz = cz + dz[i];

                //out of index
                if(nz >= h || nz < 0) continue;

                //Requirement
                if(box[nz][cy][cx] != 0) continue; //들어있지 않거나, 이미 익은 토마토는 패스
                
                q.offer(new Node(nz, cy, cx));

                //퍼지는 날짜를 적는다. (마지막에 -1만 해주면 딱 맞음.)
                box[nz][cy][cx] = box[cz][cy][cx] + 1;
            }            
        }

        
    }
}