import java.util.*;
class Solution {
    public int solution(int[] citations) {
        // n번 인용된 논문의 개수가 n개여야 됨.
        // 1000편이하? 그럼 n^2 쌉가능
        
        // [0, 1, 3, 5, 6]
        Arrays.sort(citations);
        
        for(int i = 0 ; i < citations.length ; i++) {
            int h = citations.length - i;
            
            if(citations[i] >= h) return h;
        }
        
        // 모든 논문의 인용 횟수가 0인 경우
        return 0;
        
//         int answer = 0;
        
//         int n = 1;
//         for(int i = 0 ; i < citations.length ; i++) {
//             int temp = 0;
            
//             for(int j = 0 ; j < citations.length ; j++) {
//                 if(n <= citations[j]) temp++;
//             }
            
//             if(n == temp && answer < temp){
//                 answer = temp;
//             } else {
//                 n++;
//             }
//         }
        
//         return answer;
    }
}