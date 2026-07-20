import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
  
        Set<String> set = new HashSet<>();
        
        for(String s : phone_book) set.add(s);
        
        
        for(int i = 0 ; i < phone_book.length ; i++) {
            for(int j = 1 ; j < phone_book[i].length() ; j++) {
                if(set.contains(phone_book[i].substring(0, j))) { // 0, 5 는 실제로 0포함 5미만이다.
                    answer=false;
                    break;
                }
            }
        }
        
        
//         Arrays.sort(phone_book);
        
//         //for(String s : phone_book) System.out.print(s + " ");
        
//         for(int i = 0 ; i < phone_book.length - 1 ; i++){
//             if(phone_book[i+1].length() >= phone_book[i].length() && phone_book[i + 1].substring(0, phone_book[i].length()).equals(phone_book[i])) {
//                 answer = false;
//                 break;
//             }
//         }
        
        return answer;
    }
}