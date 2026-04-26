import java.util.*;

// 숫자 N: 1 이상 10억 이하의 자연수 -> 배열 사용 시, 메모리 초과

public class Solution {
    public int solution(int n) {
        int cnt = 0;
        
        while(n > 0) {
            if(n % 2 == 1) cnt++;
            n /= 2;
        }
        return cnt;
    }
}