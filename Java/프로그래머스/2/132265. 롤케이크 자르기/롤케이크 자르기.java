import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int result = 0;
        
        int[] brother = new int[10001];
        int cnt = 0;
        
        HashSet<Integer> chulSoo = new HashSet<>();
        
        for(int t : topping) {
            if(brother[t] == 0) {
                cnt++;
            }
            
            brother[t]++;
        }
        
        for(int t : topping) {
            chulSoo.add(t); // Set은 중복 제거
        
            brother[t]--;
            
            if(brother[t] == 0) {
                cnt--;
            }
            
            if(chulSoo.size() == cnt){
                result++;
            }
        }
        
        return result;
        
    }
}