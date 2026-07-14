import java.util.*;

class Node{
    int val;
    int loc;
    
    public Node(int val, int loc) {
        this.val = val;
        this.loc = loc;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        // 1. Queue에 값을 집어 넣준다. (val = priorities[i], loc = i)
        // 2. while(!q.isEmpty()) -> Node cur = q.poll() 보다 더 높은 값이 있는지 for문으로 탐색한다.
        // 3. 있으면 cur를 다시 집어넣는다 or 없으면 cnt를 증가시켜 횟수를 증가시킨다. -> 여기서 loc이 location과 같다면 return cnt;
        
        Queue<Node> q = new LinkedList<>();
        int cnt = 0;
        
        
        for(int i = 0 ; i < priorities.length ; i++) {
            q.offer(new Node(priorities[i], i));
        }
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            boolean higher = false;
            
            for(Node n : q) {
                
                if(cur.val < n.val) {
                    higher = true;
                    break;
                }
            }
            
            if(higher){
                q.offer(cur);
            }
            else{
                cnt++;
                
                if(cur.loc == location) {
                    return cnt;
                }
            }
        }
        return -1;
    }
}