//stack과 deque의 차이는 synchronized 지원/미지원 차이
import java.util.*;

class Solution
{
    public static Deque<Character> d = new ArrayDeque<>();
    public static char[] arr;
    public int solution(String s)
    {
        arr = s.toCharArray();
        
        for(char c : arr){
            if(!d.isEmpty() && d.peek() == c){
                d.pop();
            }
            else{
                d.push(c);
            }
        }
        
        if(d.isEmpty()) return 1;
        else return 0;
    }
}