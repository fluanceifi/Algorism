import java.util.*;
import java.io.*;

class Node {
    int y, x;
    boolean crashed;
    public Node(int y, int x, boolean crashed) {
        this.y = y;
        this.x = x;
        this.crashed = crashed;
    }
}

class Main {
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0'; // '0' 빼서 정수 변환
            }
        }

        // dist[y][x][0] = 벽 안 깼을 때 거리
        // dist[y][x][1] = 벽 깼을 때 거리
        int[][][] dist = new int[n][m][2];
        for (int[][] a : dist)
            for (int[] b : a)
                Arrays.fill(b, -1);

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, false));
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int crashedIdx = now.crashed ? 1 : 0;

            // 도착점 도달 시 즉시 출력
            if (now.y == n - 1 && now.x == m - 1) {
                System.out.println(dist[now.y][now.x][crashedIdx]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i]; // 오타 수정: = → +

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                if (graph[ny][nx] == 1) {
                    // 벽인 경우: 아직 벽을 안 깼을 때만 부수고 진입
                    if (!now.crashed && dist[ny][nx][1] == -1) {
                        dist[ny][nx][1] = dist[now.y][now.x][0] + 1;
                        q.offer(new Node(ny, nx, true));
                    }
                } else {
                    // 빈 칸인 경우
                    if (dist[ny][nx][crashedIdx] == -1) {
                        dist[ny][nx][crashedIdx] = dist[now.y][now.x][crashedIdx] + 1;
                        q.offer(new Node(ny, nx, now.crashed));
                    }
                }
            }
        }

        System.out.println(-1); // 도달 불가
    }
}