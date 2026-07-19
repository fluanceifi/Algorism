class Solution {
    public long solution(int n, int[] times) {
        // 28 / 7 = 4
        // 28 / 10 = 2
        // 즉, 7분과 10분 걸리는 심사대를 28분에 6명 처리 할 수 있다는 이야기이다.
        // 10억명이 10억분 걸리는 하나의 심사대에 있는게 최악의 경우의 수 이다.
        // 최적의 값을 구하는 방법은 0분부터 10억*10억분을 이분탐색하여 좁혀나가는 것이다.
        
        long answer = 0;
        long start = 0;
        long end = 1_000_000_000 * 1_000_000_000L;
        
        while(start < end) {
            long minutes = (start + end) / 2;
            
            if(isValid(minutes, times, n)) {
                end = minutes;
                answer = end;
            } else {
                start = minutes + 1;
            }
        }
        
        return answer;
    }
    
    public static boolean isValid(long minutes, int[] times, int n) {
        long count = 0;
        
        for(int time : times) {
            count += minutes / time;
        }
        
        return count >= n;
    }
}