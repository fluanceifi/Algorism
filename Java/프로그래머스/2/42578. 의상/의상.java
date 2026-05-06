import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // [0]: 의상이름, [1]: 의상종류
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < clothes.length ; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        int n = 1;
        
        for(Integer m : map.values()) {
            n *= (m + 1);
        }
        return n - 1; 
        
    }
}