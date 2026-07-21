import java.util.*;

class Solution {
    public static int[][] dungeons;
    public static int n;
    public static boolean[] visited;
    public static int answer;
    
    public int solution(int k, int[][] dungeons) {
        //["최소 필요 피로도", "소모 피로도"] -> "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
        // 던전들을 최대한 많이 탐험하려 합니다. -> 모든 경우의 수 == 백트래킹
        // 즉 "최소 필요 피로도" <= k 일 때마다 방문한다.
        this.dungeons = dungeons;
        n = dungeons.length;
        visited = new boolean[n];
        answer = 0;
        
        dfs(k, 0);
        
        return answer;
    }
    
    public static void dfs(int k, int depth) {
        // 종료 조건
        if(depth > answer) {
            answer = depth;
        }
        // 가지 치기
        
        // 로직
        for(int i = 0 ; i < n ; i++) {
            if(visited[i] || k < dungeons[i][0]) continue;
        
            visited[i] = true;
            dfs(k - dungeons[i][1], depth + 1);
            visited[i] = false;
        }
    }
}