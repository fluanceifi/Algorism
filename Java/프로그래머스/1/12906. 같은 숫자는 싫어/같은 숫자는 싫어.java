import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
    // 1. Stack -> peek() == arr[i] -> continue;
        
        Stack<Integer> s = new Stack<>();
        
        s.add(arr[0]);
        
        for(int i = 1 ; i < arr.length ; i++){
            if(s.peek() == arr[i]) continue;
            
            s.add(arr[i]);
        }
        
        int[] answer = new int[s.size()];
        
        for(int i = s.size() - 1 ; i >= 0 ; i--) {
            answer[i] = s.pop();
        }
        
        return answer;
    } 
}