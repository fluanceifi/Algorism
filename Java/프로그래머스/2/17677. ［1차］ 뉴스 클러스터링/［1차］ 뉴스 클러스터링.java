import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 1. str1 과 str2를 toLowerCase로 변환한다.
        // 2. str1 과 str2를 두글자씩 쪼개어 Map으로 저장한다.
        // 3. list중 a~z범위가 아니면 제거한다.
        // 4. 교집합용 count, 합집합용 count를 0으로 초기화한다.
        // 5. Set으로 str1과 2의 키만 추출하여 초기화한다.
        // 6. for-each문으로 str1Map에서 횟수와, str2Map에서 횟수를 구한다.
        // 7. 두 숫자의 min을 구하면 교집합, max를 구하면 합집합이된다.
        
        Map<String, Integer> str1Map = makeMap(str1.toLowerCase());
        Map<String, Integer> str2Map = makeMap(str2.toLowerCase());
        
        double union = 0;
        double intersection = 0;
        
        Set<String> allKey = new HashSet<>();
        allKey.addAll(str1Map.keySet());
        allKey.addAll(str2Map.keySet());
        
        // 만약 공집합이 없으면, 0/0으로 NaN 문제가 발생
        if(allKey.isEmpty()) return 65536;
        
        
        for(String s : allKey) {
            int str1Count = str1Map.getOrDefault(s, 0);
            int str2Count = str2Map.getOrDefault(s, 0);
            
            union += Math.max(str1Count, str2Count);
            intersection += Math.min(str1Count, str2Count);
        }
        
        double answer = intersection / union;
        
        return (int) (answer * 65536);    
    }
    
    public static Map<String, Integer> makeMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() - 1 ; i++) {
            String temp = s.substring(i, i+2);
            
            if(temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z' && temp.charAt(1) >= 'a' && temp.charAt(1) <= 'z' )  map.put(temp, map.getOrDefault(temp, 0) + 1);
            
           
        }
        
        return map;
    }
}