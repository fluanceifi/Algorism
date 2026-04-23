class Solution {
    public static int cnt;
    
    public int solution(int n) {
        
        for(int i = 1 ; i <= n ; i++){
            dp(i, i, n);
        }
        
        return cnt;
    }
    
    public static void dp(int curr, int sum, int n) {
        // 종료 조건
        if(sum > n) return;
        
        // 조건
        if(sum == n) {
            cnt++;
            return;
        }
        
        dp(curr + 1, sum + curr + 1, n);
        
    }
}