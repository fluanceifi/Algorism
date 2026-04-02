import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    private int pos;
    private int time;

    public Node(int pos, int time){
        this.pos = pos;
        this.time = time;
    }

    public int getPos(){
        return pos;
    }
    public int getTime(){
        return time;
    }

    @Override
    public int compareTo(Node others){
        return this.time - others.time;
    }
}


class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int n, k;

    public static PriorityQueue<Node> q = new PriorityQueue<>();
    
    public static boolean[] visited = new boolean[100001];
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k){
            System.out.println(0);
            return;
        }
        
        q.add(new Node(n, 0));
        
        
        
        while(!q.isEmpty()){
            Node now = q.poll();
            int pos = now.getPos();
            int time = now.getTime();
                        
            if(visited[pos]) continue;            
            visited[pos] = true;
            
            if(pos == k){
                sb.append(time);
                break;
            }
            
            if(pos - 1 >= 0 && !visited[pos-1]){
                q.add(new Node(pos - 1, now.getTime() + 1));
            }
            if(pos * 2 <= 100000 && !visited[pos*2]){
                q.add(new Node(pos * 2, now.getTime()));
            }
            if(pos + 1 <= 100000 && !visited[pos+1]){
                q.add(new Node(pos + 1, now.getTime() + 1));
            }
            
        }

        System.out.println(sb);
    }
}