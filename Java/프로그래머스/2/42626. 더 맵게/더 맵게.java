import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 0. check ( if [0] >=  K, then return answer; )
        // 1. pop, pop ([0], [1])
        // 2. insert ([0] + ([1] * 2))
        // 3. answer++;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int answer = 0;
        
        for(int i : scoville) {
            minHeap.offer(i);
        }
        
        while(true) {
            if(minHeap.peek() >= K) {
                break;
            } else if (minHeap.size() == 1 && minHeap.peek() <= K){
                answer = -1;
                break;
            }
            
            int a = minHeap.poll();
            int b = minHeap.poll();
            
            minHeap.offer(a + (b * 2));
            answer++;
        }
        
        return answer;
    }
}