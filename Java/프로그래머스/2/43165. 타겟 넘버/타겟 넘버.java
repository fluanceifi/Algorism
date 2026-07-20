class Solution {
    public static int[] numbers;
    public static int target;
    public static int answer;
    public static boolean[] visited;
    public int solution(int[] numbers, int target) {
        // 더하거나, 빼거나 -> DFS로 가능!
        this.numbers = numbers;
        this.target = target;
        answer = 0;
        visited = new boolean[numbers.length];
        
        dfs(0, 0, 0);
        
        return answer;
    }
    
    public static void dfs(int current, int depth, int idx) {
        if(current == target && depth == numbers.length ) {
            answer++;
            return;
        }
        
        if(idx >= numbers.length) return;
        
        dfs(current + numbers[idx], depth + 1 , idx + 1);
        dfs(current - numbers[idx], depth + 1 , idx + 1);
        
    } 
}