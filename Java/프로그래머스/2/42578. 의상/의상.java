import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        /* 
            1. 각 종류별로 최대 1가지 의상만 착용 가능하다.
            2. 의상이 겹쳐도 조합만 다르면 됨.
            3. 의상을 안입어도되는데 일단, 적어도 종류별로 하나는 입어야됨.
            -> 안입어도되는 경우의 수를 추가로 더한다.
        */
        Map<String, Integer> map = new HashMap<>();
        
        // [][0]: 이름 , [][1]: 종류
        // 중복된 옷이 없다. -> 있다면 별도로 셋 객체 초기화 한 다음 if(contains())로 검증 후 이름을 추가했을 듯
        for(int i = 0 ; i < clothes.length ; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int result = 1;
        
        // get은 특정 Key를 지정해야 되기 때문에 values()를 사용한다.
        for(int n : map.values()){
            result *= (n + 1);
        }
        
        return result - 1;
    }
}