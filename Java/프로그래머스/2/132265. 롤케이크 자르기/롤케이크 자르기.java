import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int result = 0;
        
        // 동생 Hash, 형 Hash Set을 생성
        HashMap<Integer, Integer> brother = new HashMap<>();
        HashMap<Integer, Integer> chulSoo = new HashMap<>();
        
        // 동생 Hash를 먼저 다 담음
        for(int t : topping) {
            brother.put(t, brother.getOrDefault(t, 0) + 1);
        }
        
        // 다시 앞쪽부터 형이 하나씩 담고, 해당하는 값을 동생이 하나씩 뺌, 0이 될 경우 제거
        for(int t : topping) {
            chulSoo.put(t, chulSoo.getOrDefault(t, 0) + 1);
            
            brother.put(t, brother.get(t) - 1);
            
            if(brother.get(t) == 0) brother.remove(t);
            
            if(brother.size() == chulSoo.size()) result++;
        }
        
        // 매번 for문 마지막에 개수가 같으면 result ++; 로 값을 증가
        
        return result;
    }
}