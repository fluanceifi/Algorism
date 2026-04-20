import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < words.length ; i++){
            if(words[i].length() > 0) {
                sb.append(Character.toUpperCase(words[i].charAt(0)));
                sb.append(words[i].substring(1).toLowerCase());
            }
            
            if(i < words.length -1){
                sb.append(" ");
            }
            
        }
        return sb.toString();
    }
}