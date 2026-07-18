import java.util.*;

class Solution {
    public static int answer;
    public static Set<Integer> num;
    public static int n;
    public static boolean[] visited;
    public static String numbers;
    
    public int solution(String numbers) {
        // 백트래킹으로 모든 수를 만들 수 있다.
        // 해당 수는 Set에 집어넣는다.
        // Set을 조회하며 소수인지 판단한다.
        // 소수일 경우, answer++ 
        // return answer;
        
        this.numbers = numbers;
        answer = 0;
        num = new HashSet<>();
        visited = new boolean[numbers.length()];

        
        backTracking("");
        
        for(int i : num) {
            if(isPrime(i)) answer++;
        }
        
        
        return answer;
    }
    
    public static void backTracking(String current) {
        if(!current.isEmpty()) {
            num.add(Integer.parseInt(current));
        }
        
        for(int i = 0 ; i < numbers.length() ; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            backTracking(current + numbers.charAt(i));
            visited[i] = false;
        }
    }
    
    public static boolean isPrime(int n) {
        if(n < 2) return false;
        
        for(int i = 2 ; i * i <= n ; i++){
            if(n % i == 0) return false;
        }
        
        return true;
    }
}