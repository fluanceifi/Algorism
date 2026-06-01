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
        Queue<Node> q = new LinkedList<>();
        
        /** 세팅 */
        for(int i = 0 ; i < priorities.length ; i++) {
            q.add(new Node(priorities[i], i));
        }
        
        
        /** 로직 */
        int cnt = 0;
        while(!q.isEmpty()) {
            // 1. 하나 꺼내기
            Node cur = q.poll();
            
            // 2. 값 비교하기
            boolean hasHigher = false;
            for(Node next : q) {
                if(cur.val < next.val) {
                    hasHigher = true;
                    break;
                }
            }
            
            // 3. 더 높은게 있다면 다시 넣고, 아니라면 실행횟수 추가하기
            if(hasHigher){
                q.add(cur);
            } else {
                cnt++;
                
                // 4. 만약, location과 일치하는 Node라면 return
                if(location == cur.loc) return cnt;
            }
        }
        
        /** 예외처리*/
        return -1;
    }
}