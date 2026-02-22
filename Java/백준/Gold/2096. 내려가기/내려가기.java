import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int n;
    public static int[][] board;
    public static int[][] min;
    public static int[][] max;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        board = new int[n][3];
        min = new int[n][3];
        max = new int[n][3];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min[0][0] = board[0][0];
        min[0][1] = board[0][1];
        min[0][2] = board[0][2];
        max[0][0] = board[0][0];
        max[0][1] = board[0][1];
        max[0][2] = board[0][2];

        for(int i = 1 ; i < n; i++){
            for(int j = 0 ; j < 3 ; j++){

                if(j == 0){
                    max[i][j] = board[i][j] + Math.max(max[i-1][j], max[i-1][j+1]);
                    min[i][j] = board[i][j] + Math.min(min[i-1][j], min[i-1][j+1]);
                }

                if(j == 1){
                    max[i][j] = board[i][j] + Math.max(max[i-1][j-1], Math.max(max[i-1][j], max[i-1][j+1]));
                    min[i][j] = board[i][j] + Math.min(min[i-1][j-1], Math.min(min[i-1][j], min[i-1][j+1]));
                }

                if(j == 2){
                    max[i][j] = board[i][j] + Math.max(max[i-1][j], max[i-1][j-1]);
                    min[i][j] = board[i][j] + Math.min(min[i-1][j], min[i-1][j-1]);
                }
            }
        }

        Arrays.sort(max[n-1]);
        Arrays.sort(min[n-1]);

        System.out.println(max[n-1][2]+" "+min[n-1][0]);
        
    }
}