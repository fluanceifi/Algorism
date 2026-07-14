import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 1. Bridge에 대한 Queue 생성
        // 2. Bridge 길이만큼 0을 채워 넣음.
        // 3. truck_weights를 순서대로 삽입함. (매순간 times++;)
        // 4. 삽입 후, 다음턴에 weight를 넘지 않는가 파악함. (truck_weight[i] + current_weight <= weight)
        // 5. 넘으면 continue; / 안넘으면 offer(truck_weight[i]) -> current_weight 갱신
        
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i = 0 ; i < bridge_length ; i++) {
            bridge.offer(0);
        }
        
        int times = 0;
        int current_weight = 0;
        int idx = 0;
        
        while(idx < truck_weights.length) {
            current_weight -= bridge.poll();
            times++;
            
            if(truck_weights[idx] + current_weight <= weight) {
                bridge.offer(truck_weights[idx]);
                current_weight += truck_weights[idx];
                idx++;
            } else{
                bridge.offer(0);
            }
            
        }
        
        return times + bridge_length;
        
    }
}