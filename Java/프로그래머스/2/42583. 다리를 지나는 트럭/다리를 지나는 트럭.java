import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아낸다.
        // 다리에는 트럭이 최대 bridge_length대 올라갈 수 있다 -> Queue에 bridge_length만큼 0을 넣어둔다.
        // 다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다. 
        // -> for-each로 Queue무게 측정, if(weight >= Queue 무게 + 다음 트럭) q.offer(다음 트럭);
        // 마지막 트럭은 계산말고 그냥 bridge_length를 더하여 결과를 도출한다.
        
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        int times = 0;
        
        for(int i = 0 ; i < bridge_length ; i++) {
            q.offer(0);
        }
        
        while(idx < truck_weights.length) {
            int current_weights = 0;
            times++;
            
            q.poll();

            for(int tw : q) current_weights += tw;
            
            
            if(current_weights + truck_weights[idx] <= weight) {
                q.offer(truck_weights[idx]);
                idx++;
            } 
            else {
                q.offer(0);
            }
        }
        
        return times + bridge_length ;
    }
}