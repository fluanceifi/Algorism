import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    private int target;
    private int cost;

    public Node(int target, int cost){
        this.target = target;
        this.cost = cost;
    }

    public int getTarget(){
        return target;
    }
    public int getCost(){
        return cost;
    }

    @Override
    public int compareTo(Node others){
        return this.cost - others.cost;
    }
}


class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m;
    static int start, end;

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); // 1차원
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] dist;
    
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        
        // 1. init vertex 
        for(int i = 0 ; i < n + 1 ; i++){
            graph.add(new ArrayList<Node>()); // 2차원
        }

        dist = new int[n+1];
        for(int i = 0 ; i < n + 1 ; i++){
            dist[i] = (int) 1e9;
        }

        //2. init edge
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(A).add(new Node(B, cost));
        }
        
        st = new StringTokenizer(br.readLine());

        
        //3. init start / end
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        //4. dijkstra

        // insert start point 
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        // 최적화(가지치기) 방법
        // 1. 목적지 도착 시 dist[end] 반환
        // 2. 큐에서 꺼낸 노드의 거리 vs dist[currentVertex]의 비교 
        //    -> 처음 큐에 넣고나서 나중에 최적화되고, 나중에 꺼냈을 때를 위한 최적화
        // 3. 1, 2를 모두 거쳤다면 거리 최적화조건에 맞췄으니 이웃노드 비용 계산 + 필요 시 갱신
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            int currVertex = now.getTarget();
            int currCost = now.getCost();

            if(currVertex == end){
                break;
            }

            if(currCost > dist[currVertex]){
                continue;
            }

            for(Node neighbor : graph.get(currVertex)){
                int neighborCost = dist[currVertex] + neighbor.getCost();

                if(dist[neighbor.getTarget()] > neighborCost){
                    dist[neighbor.getTarget()] = neighborCost;
                    pq.offer(new Node(neighbor.getTarget(), neighborCost));
                    
                }
            }
            
        }

        System.out.println(dist[end]);

        
    }
}