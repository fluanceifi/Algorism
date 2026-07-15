class Solution {
    public static int answer;
    
    public int solution(int n, int[][] computers) {
        // 1. 모든 방문은 한번이면 족한다. (visited 사용)
        // 2. 모든 노드가 연결된게 아니기 때문에, (0, 1)부터 (n-1, n-2)까진 돌아봐야된다.
        // 3. 한 네트워크의 최대 노드 수가 아닌 네트워크의 개수를 구하는 문제다.
        
        boolean[] visited = new boolean[n];
        answer = 0;
        
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]){
                answer++;
                dfs(i, n, computers, visited);
                System.out.println(answer);
            }
        }
        
        return answer;
        
    }
    
    public static void dfs(int i, int n, int[][] computers, boolean[] visited){
        // 1. 방문처리
        visited[i] = true;
        
        // 2. 다른 곳에 연결된 네트워크가 존재한다면, 
        for(int j = 0 ; j < n ; j++){
            if(i != j && computers[i][j] == 1 && !visited[j]) {
                dfs(j, n, computers, visited);
            }
        }
    }
}