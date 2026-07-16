import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {        
        Set<String> set = new HashSet<>();
        
        // 전화번호부를 다 넣어둔다.
        for(String s : phone_book) {
            set.add(s);
        }
        
        // phone_book[i].substring(0, j)로 나의 일부분이 전화번호부에 존재하는지 확인한다.
        // 그게 곧 접두어가 되니깐.
        for(int i = 0 ; i < phone_book.length ; i++) {
            for(int j = 1 ; j < phone_book[i].length() ; j++) {
                if(set.contains(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
}