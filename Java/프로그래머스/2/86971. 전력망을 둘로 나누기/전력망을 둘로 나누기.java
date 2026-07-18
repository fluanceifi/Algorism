import java.util.*;

class Solution {
    public static int count;
    public static int answer;
    public static int N;
    public int[][] wire;
    public static boolean[] visited;
    public static int[][] arr;
    
    public int solution(int n, int[][] wires) {
        // 트리를 끊는다. -> 2개로 분할된다.
        // 분할된 트리는 개수가 비슷해야된다.
        // 송전탑 개수 n, 전성 정보 wires
        // 두 전력망이 가지고 있는 송전탑 개수의 차이는 절대값으로 반환한다.
        
        // 1. n * n 2차원 배열 생성
        // 2. wires를 [i][j]라 할때, [i][j] = 1, [j][i] = 1로 양방향 연결함.
        // 3. 어떻게하면 노드를 하나씩 제거했다고 가정하고 방문 할 수 있을까?
        // 4. Queue가 Empty되면 전체 노드 개수(n) - 현재까지 방문수 누적 값(cnt)를 Math.abs로 계산하기
        // 5. 계산한 값이 최대값이면 갱신
        // 6. 정답 반환
        
        answer = (int) 1e9;
        N = n;
        wire = wires;
        arr = new int[N + 1][N + 1];
        
        for(int i = 1 ; i <= N ; i++) {
            arr[i][i] = 1;
        }
        
        for(int i = 0 ; i < N - 1 ; i++) {
            arr[wire[i][0]][wire[i][1]] = 1;
            arr[wire[i][1]][wire[i][0]] = 1;
        }
        
        for(int i = 0 ; i < N - 1 ; i++) {

            // 제거
            arr[wire[i][0]][wire[i][1]] = 0;
            arr[wire[i][1]][wire[i][0]] = 0;
            
            // 실행
            visited = new boolean[N + 1];
            count = 0;
            dfs(1);
            
            // Math.abs(한쪽 - 다른쪽)
            answer = Math.min(Math.abs((N - count) - count), answer);
            

            // 복구
            arr[wire[i][0]][wire[i][1]] = 1;
            arr[wire[i][1]][wire[i][0]] = 1;
        }
        
        return answer;
    }
    
    public static void dfs(int node) {
        // 종료
        visited[node] = true;
        count++;
        
        // 로직
        for(int i = 1 ; i<= N ; i++) {
            if(node == i || visited[i] || arr[node][i] == 0) continue;
            
            dfs(i);
        } 
        
    }
}