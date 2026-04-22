import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        int loop = 0;
        int cnt = 0;
        
        if(s.equals("1")){
            answer = new int[]{loop, cnt};
            return answer;
        }
        
        while(!s.equals("1")){
            
            String removed = s.replace("0", "");
            
            cnt += s.length() - removed.length();
            
            s = Integer.toBinaryString(removed.length());
            
            loop++;
        }
        
        answer = new int[]{loop, cnt};
        
        return answer;
    }
}

// 110010101001 -> 111111 -> 6 = 0110 