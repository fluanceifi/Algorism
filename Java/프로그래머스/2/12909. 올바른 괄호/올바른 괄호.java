import java.util.*;

class Solution {
    boolean solution(String s) {
        // 1. Stack 초기화
        // 2. ( 면 삽입,  ) 면 조회 후 , pop
        
        boolean check = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            
            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty()) {
                    check = false;
                    break;
                } else {
                    if(stack.peek() == '('){
                        stack.pop();
                    }
                }
            }
        }
        
        if(stack.isEmpty()){
            return check;
        } else{
            return false;
        }
        
    }
}