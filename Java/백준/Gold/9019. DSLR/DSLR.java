import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb;

    public static Queue<Integer> q;
    public static int[] parent;
    public static char[] command;
    public static boolean[] visited;

    public static char[] dir = {'D', 'S', 'L', 'R'};

    public static int t, a, b, next;
    
    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            sb  = new StringBuilder();

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            if(a == b) continue;
            
            q = new LinkedList<>();
            q.offer(a);
            
            parent = new int[10001];
            command = new char[10001];
            visited = new boolean[10001];

            while(!q.isEmpty()){
                int num = q.poll();

                if(num == b){
                    sb.append(getResult(a, num, parent, command));
                    break;
                }

                for(int i = 0 ; i < 4 ; i++){
                    char cmd = dir[i];

                    if(cmd == 'D'){
                        next = (num * 2) % 10000;
                    }
                    if(cmd == 'S'){
                        next = (num == 0) ? 9999 : num - 1;
                    }
                    if(cmd == 'L'){
                        next = (num % 1000) * 10 + (num / 1000);
                    }
                    if(cmd == 'R'){
                        next = (num % 10) * 1000 + (num / 10);
                    }

                    if(next > 10000 || visited[next]) continue;

                    parent[next] = num;
                    visited[next] = true;
                    command[next] = cmd;
                    q.offer(next);
                    
                }
            }
            System.out.println(sb);
        }
    
    }
    
    public static String getResult(int start, int target, int[] parent, char[] command){
        int current = target;
        StringBuilder sb2 = new StringBuilder();
        
        while(current != start){
            sb2.append(command[current]);
            current = parent[current];
        }

        return sb2.reverse().toString();
    }
}