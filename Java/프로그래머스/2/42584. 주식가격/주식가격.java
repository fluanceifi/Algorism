import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 1 2 3 2 3
        
        // 방법 1
        
        /*
        int[] answer = new int[prices.length];
        
        for(int i = 0 ; i < prices.length - 1 ; i++) {
            int val = 0;
            
            for(int j = i + 1 ; j < prices.length ; j++) {
                val++;
                
                // 가격이 떨어지면 멈춘다.
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            
            answer[i] = val;
        }
        
        return answer;
        */
        
        // 방법 2
        // Stack에 인덱스 값을 넣거나, 이미 Stack에 인덱스 값이 존재한다면 현재 값보다 큰지 작은지 비교해본다.
        // 만약 현재 값이 더 작은 경우 스택의 값을 pop 해준다.
        // > idx = s.pop()  -> answer[idx] = i - idx; == 버틴 시간
        
        Stack<Integer> s = new Stack<>();
        int[] answer = new int[prices.length];
        
        //중간에 값이 떨어져서 결정나는 애들 
        for(int i = 0 ; i < prices.length ; i++) {
            while(!s.isEmpty() && prices[s.peek()] > prices[i]) {
                int idx = s.pop();
                answer[idx] = i - idx; 
            } 
            s.push(i);
        }
        
        // 마지막까지 남은 애들
        while(!s.isEmpty()){
            int idx = s.pop();
            answer[idx] = (prices.length - 1) - idx;
        }
        
        
        return answer;
    }
}