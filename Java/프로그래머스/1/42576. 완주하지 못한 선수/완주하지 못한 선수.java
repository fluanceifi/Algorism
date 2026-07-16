import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // HashMap = Map이란 말과 일치하게  Key와 Value를 Mapping하여 저장한다.
        // HashSet = 객체 그 자체를 저장한다. 
        
        // 1. 참여자를 모두 해쉬셋에 넣는다.
        // 2. completion을 탐색하여 해시셋에 존재하면 삭제한다.
        // 3. 나머지는 String으로 반환한다.
        // 문제는 동명이인을 어떻게 처리하냐인데? 
        // 배열을 정렬시켜서 !equals로 판단하기 vs HashMap으로 Value값을 저장하기 
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        int n = participant.length;
        
        for(int i = 0 ; i < n ; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        for(String s : completion){
            if(map.containsKey(s))
                map.put(s, map.get(s) - 1);
        }
        
        for(String key : map.keySet()){
            if(map.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
        
    }
}