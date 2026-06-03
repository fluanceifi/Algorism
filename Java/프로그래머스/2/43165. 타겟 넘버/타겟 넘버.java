class Solution {
    public int solution(int[] numbers, int target) {
        int result = dfs(numbers, target, 0, 0);
        
        return result;
    }
    
    public static int dfs(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        int add = dfs(numbers, target, index + 1, sum + numbers[index]);
        int abs = dfs(numbers, target, index + 1, sum - numbers[index]);
        
        return add + abs;
    }
}