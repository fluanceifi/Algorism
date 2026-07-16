import java.util.*;
class Solution {
    public int solution(int[] nums) {
        // 1. N개 중 N/2를 가져가도 된다. -> 종류가 같으면 안된다.
        // 2. 폰켓못은 종류에 따라 번호가 붙는다. <Integer, Integer>
        // 3. 똑같은 폰켓몬은 구분을 해야된다. -> 고르는 방법이 여러가지라서
        // 4. nums의 개수 / 2 => 최대 가져갈 수 있는 양
        // 5. 최대한 최대 가져갈 수 있는 양에 도달해야된다.
        // 6. 
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i <  nums.length ; i++) {
            set.add(nums[i]);
        }
        
        return set.size() >  nums.length / 2 ?  nums.length / 2 : set.size();
        
    }
}