class Solution {
    public int solution(int[] numbers, int target) {
        int result = dfs(0, target, 0, numbers);
        
        return result;
    }
    
    public static int dfs(int idx, int target, int sum, int[] numbers) {
        if(idx == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        int add = dfs(idx + 1, target, sum + numbers[idx], numbers);
        int abs = dfs(idx + 1, target, sum - numbers[idx], numbers);
        
        return add + abs;
    }
}