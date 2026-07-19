import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // i 번째에서 i + 1, i+ 2, ... prices.length() - 1 까지 i보다 안떨어 졌다면 매순간 answer[i]에 ++ 해준다. (100,000^2 == 10,000,000,000)
        int[] answer = new int[prices.length];
        
//         for(int i = 0 ; i < prices.length - 1 ; i++) {
//             for(int j = i + 1 ; j < prices.length ; j++) {
//                 if(prices[i] <= prices[j]) answer[i]++;
//             }
//         }
        
        
        /* Stack으로 O(n) 접근법 */
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0 ; i < prices.length ; i++){ 
            while(!s.isEmpty() && prices[s.peek()] > prices[i]) {
                int idx = s.pop();
                answer[idx] = i - idx;
            }
            s.push(i);
        }
        
        /*
        2 <--- 3(i) - 2 = 1 // 가격이 내려갔을때, 현재 3(i)과 직전 인덱스(2)를 빼면 직전 인덱스가 유지 한 개수가 된다. 
        1
        0
        */
        
        while(!s.isEmpty()) {
            int idx = s.pop();
            answer[idx] = prices.length - 1 - idx; // 전체 운영 기간 - 내 위치
        }
        
        return answer;
        
    }
}