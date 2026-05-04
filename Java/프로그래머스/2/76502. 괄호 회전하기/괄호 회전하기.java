import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Deque<Character> d = new LinkedList<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            d.offer(s.charAt(i));
        }
        
        for(int i = 0 ; i < s.length() ; i++) {
            if(check(d)) answer++;
            
            d.offer(d.poll());
        }
        
        return answer;
    }
    
    
    public static boolean check(Deque<Character> d) {
        Stack<Character> s = new Stack<>();
        
        for(Character c : d) {
            if(c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else {
                if(s.isEmpty()) return false;
                
                char top = s.peek();
        
                if(c == ')' && top == '(') s.pop();
                if(c == '}' && top == '{') s.pop();
                if(c == ']' && top == '[') s.pop();
            }
        }
        
        if(!s.isEmpty()) return false;
        return true;
    }
    
}