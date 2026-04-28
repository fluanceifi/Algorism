import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length;
        HashMap map = new HashMap<>();
        
        for(int i = 0 ; i < len ; i++) {
            int temp = elements[i];
            
            if(!map.containsKey(temp)) map.put(temp, 1);
            
            for(int j = 1 ; j < len ; j++) {
                temp += elements[(i+j) % len];
                
                if(!map.containsKey(temp)) map.put(temp, 1);
            }
        }
        return map.size();
    }
}