import java.util.*;

// A -> AA -> AAA -> AAAA -> AAAAA -> AAAAE -> AAAAI -> 

class Solution {
    public static String result;
    public static int count;
    public static int answer;
    public static boolean isFound;
    public static String[] alphabet = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        count = 0;
        answer = 0;
        isFound = false;
        result = word;
        
        dfs("");
        
        return answer;
    }
    
    public static void dfs(String s) {
        if(s.length() > 5 || isFound) return;
        
        if(!s.equals("")) count++;

        
        if(result.equals(s)) {
            isFound = true;
            answer = count;
            return;
        }
        
        for(int i = 0 ; i < alphabet.length ; i++) {
            if(isFound) return;

            dfs(s+alphabet[i]);
            
        }
    }
}