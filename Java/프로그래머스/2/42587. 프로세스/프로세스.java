import java.util.*;

class Node {
    int val;
    int loc;
    
    public Node (int val, int loc) {
        this.val = val;
        this.loc = loc;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {     
        int len = priorities.length;
        
        Queue<Node> q = new LinkedList<>();
        
        for(int i = 0 ; i < len ; i++) {
            q.add(new Node(priorities[i], i));
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            
            Node cur = q.poll();
            boolean hasHigh = false;
            
            for(Node n : q) {
                if(n.val > cur.val) {
                    hasHigh = true;
                    break;
                }
            }
            
            if(hasHigh) {
                q.add(cur);
            } else{
                cnt++;
                
                if(cur.loc == location) {
                    return cnt;
                }
            }
            
        }
        return -1;
    }
}