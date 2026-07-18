import java.util.*;

class Solution {
    public static int answer;
    public static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
//         dungeons의 가로(열) 길이는 2 입니다.
//         dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
//         "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
//         "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
//         서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.
        
        // 1. 방문할 수 있는 모든 경우의 수를 다 확인한다.
        // 2. 매번 방문 할 때마다, 방문횟수를 증가시킨다.
        // 3. 끝에 달했을 때, 갱신가능하면 답을 갱신한다. 
        // 4. 반환한다.
        
        answer = 0;
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        
        return answer;
    }
    
    public static void dfs(int hp, int depth, int[][] dungeons) {
        // 종료 조건: 모든 던전의 방문을 다했거나, 최대로 했을때? 어떻게 이걸 파악하지? 이게 최대란걸? 결국에 체력이 10남고, 0 ~ 던전 개수 사이일 때 어떻게알아내지?
        if(answer < depth) answer = depth;
        
        // 로직
        for(int i = 0 ; i < dungeons.length ; i++) {
            if(visited[i]) continue;
            
            if(hp >= dungeons[i][0]){
                visited[i] = true;
                dfs(hp - dungeons[i][1], depth + 1, dungeons);
                visited[i] = false;
            }

        }
        
    }
}