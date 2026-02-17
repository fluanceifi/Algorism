import java.util.*;
import java.io.*;

class Node {
    private int y;
    private int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() { return y; }
    public int getX() { return x; }
}

class Main {
    public static int r, c, t;
    public static int[][] original;
    public static int[][] dust;
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static List<Node> airPurifier = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        dust = new int[r][c]; // 데이터를 dust에 바로 저장

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int val = Integer.parseInt(st.nextToken());
                dust[i][j] = val;
                if (val == -1) {
                    airPurifier.add(new Node(i, j));
                }
            }
        }

        for (int time = 0; time < t; time++) {
            diffusion();
            executeType1(airPurifier.get(0).getY(), airPurifier.get(0).getX());
            executeType2(airPurifier.get(1).getY(), airPurifier.get(1).getX());
        }

        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dust[i][j] > 0) result += dust[i][j]; // -1 제외하고 합산
            }
        }
        System.out.println(result);
    }

    public static void diffusion() {
        original = new int[r][c];
        for (int i = 0; i < r; i++) original[i] = dust[i].clone();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (original[i][j] <= 0) continue;

                int diffusionAmt = original[i][j] / 5;
                int spreadCount = 0;

                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if (ny < 0 || ny >= r || nx < 0 || nx >= c || original[ny][nx] == -1) continue;

                    dust[ny][nx] += diffusionAmt;
                    spreadCount++;
                }
                dust[i][j] -= (diffusionAmt * spreadCount);
            }
        }
    }

    public static void executeType1(int y, int x) {
        for (int i = y - 1; i > 0; i--) dust[i][0] = dust[i - 1][0];
        for (int i = 0; i < c - 1; i++) dust[0][i] = dust[0][i + 1];
        for (int i = 0; i < y; i++) dust[i][c - 1] = dust[i + 1][c - 1];
        for (int i = c - 1; i > 1; i--) dust[y][i] = dust[y][i - 1];
        dust[y][1] = 0;
    }

    public static void executeType2(int y, int x) {
        for (int i = y + 1; i < r - 1; i++) dust[i][0] = dust[i + 1][0];
        for (int i = 0; i < c - 1; i++) dust[r - 1][i] = dust[r - 1][i + 1];
        for (int i = r - 1; i > y; i--) dust[i][c - 1] = dust[i - 1][c - 1];
        for (int i = c - 1; i > 1; i--) dust[y][i] = dust[y][i - 1];
        dust[y][1] = 0;
    }
}