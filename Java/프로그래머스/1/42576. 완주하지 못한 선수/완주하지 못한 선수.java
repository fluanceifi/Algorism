import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주
    
        /*
        마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다. -> n^2불가
        completion의 길이는 participant의 길이보다 1 작습니다.
        참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
        참가자 중에는 동명이인이 있을 수 있습니다.
        */
        
        // 해시맵으로 participant를 조회하며 "이름:횟수" 를 저장한다.
        // completion을 조회하며 "이름"을 조회 후, 횟수를 차감한다.
        // 차감한 값이 0이되면 삭제한다.
        // 남은 값을 반환한다.
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < participant.length ; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        for(int i = 0 ; i < completion.length ; i++) {
            if(map.get(completion[i]) == 1) map.remove(completion[i]);
            else map.put(completion[i], map.get(completion[i]) - 1);
        }
        
        for(String s : map.keySet()){
            return s;
        }
        return "";
    
    }
}