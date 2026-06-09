import java.util.*;

class Solution {
    
    static List<String> list = new ArrayList<>();    
    static String[] vowels = {"A", "E", "I", "O", "U"};
        
    public int solution(String word) {
        
        dfs("");
        
        return list.indexOf(word) + 1; // 인덱스는 0부터 시작이니깐
    }
    
    
    public static void dfs(String current) {
        if(current.length() > 5) {
            return;
        }
        
        if(!current.equals("")) list.add(current);
        
        for(int i = 0 ; i < 5 ; i++){
            dfs(current + vowels[i]);
        }
    }
}