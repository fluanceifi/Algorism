import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 남은 일수 계산하기 -> (100 - progress[i]) / speed[i] -> if ((100 - progress[i]) % speed[i] != 0) day++;
        // 2. 남은 일수 순서대로 큐에 집어넣기
        // 3. while(true) -> now = q.poll(); -> done++;  / if(now >= q.peek()) -> q.poll(); + done++; 
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < progresses.length ; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            
            if((100 - progresses[i]) % speeds[i] != 0) {
                day++;
            }
            
            q.offer(day);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int now = q.poll();
            int done = 1;
            
            while(!q.isEmpty() && q.peek() <= now){
                done++;
                q.poll();
            }
            list.add(done);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}