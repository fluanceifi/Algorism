import java.util.*;

class Solution {
    //호출할 메소드를 재귀호출할거기 때문에 로컬변수를 만든다.
    int INF;
    int N, MinCnt; 
    int[] Weak;
    int[] Dist;
        
    void solve(int cnt, int pos, int visited){ //사용할 친구 수, 현재 위치, 방문확인
        if(cnt > Dist.length) return; //모든 친구를 사용해도 해결 못하면 빠꾸 -> solution 함수에서 MinCnt가 그대로라면 -1반환하도록 설정 
        if(cnt >= MinCnt) return; //가지치기 (최소값을 넘어버리면 굳이 할 필요 없으니깐)
            
        for(int i = 0 ; i < Weak.length; i++ ){ //시작 위치부터 나머지 모든 취약점에 이동가능한지 확인
            int nextPos = (pos + i) % Weak.length; //다음 위치의 방문 위치 (인덱스용) , 원형이기 때문에 모듈러 연산자 사용.
            int diff = Weak[nextPos] - Weak[pos]; //이동할 거리
          
            if(nextPos < pos){ //nextPos가 한바퀴 돌아서 값이 더 작아졌다면
                diff += N; //전체크기 N을 더해주면됨
            }
            
            if(diff > Dist[Dist.length - cnt]){ //오름차순으로 정렬한 Dist를 가장 긴 것부터 방문하여 사용한다. (cnt는 처음엔 1 이후엔 친구를 쓸 때마다 하나씩 증가)
                break; //그 거리가 이동할 수 있는 거리보다 크면 더이상 불가능하므로 멈춘다.
            }
            visited |= 1 << nextPos;
        }
        
        //반복문이 끝나면 모든 취약점이 방문되었는지 확인해봐야 함
        //시작 위치를 제외하면 모든게 다 방문되어있어야하니 -1를 해준다.
        if(visited == (1 << Weak.length) - 1){ 
            MinCnt = cnt;
            return;
        }
        
        for(int i = 0 ; i < Weak.length ; i++){
            if((visited & (1 << i)) != 0){
                continue; //이미 방문한 곳이면 넘긴다.
            }
            solve(cnt + 1, i, visited); //친구 한명 더 증가 후 과정 반복
        }
    }
        
    public int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist); //입력값에 상관없이 오름차순 정렬
        N = n;
        Weak = weak;
        Dist = dist;
        INF = dist.length + 1;
        MinCnt = INF;
        
        
        //모든 시작점에서 확인해봐야된다.
        for(int i = 0 ; i < Weak.length; i++){
            solve(1, i, 0); //0 ~ Weak.length - 1 까지 반복해서 방문해본다. 
        }
        
        if(MinCnt == INF){
            return -1; //친구 다 써도 전부 방문하지 못할 경우
        }
        
        //방문한 결과를 반환한다.
        return MinCnt;
        
    }
}