import java.util.*;

class Solution {
    public static int n;
    public static List<String> list;
    public static List<String> result;
    public static boolean[] visited;
    public static boolean done;
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        list = new ArrayList<>();
        visited = new boolean[n];
        
        //tickets의 [][1]에 해당하는 값을 사전 순으로 정렬하여 for문으로 처리할 때 복잡한 로직을 필요로하지않도록한다.
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        list.add("ICN");
        dfs("ICN", 0, tickets);
        
        
        String[] answer = new String[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static void dfs(String curr, int cnt, String[][] tickets) {
        // 1. 종료
        if(cnt == n){
            done = true;
            result = new ArrayList<>(list);
            return;
        }

        if(done) return;
        
        // 3. 로직
        for(int i = 0 ; i < n ; i++) {
            if(tickets[i][0].equals(curr) && !visited[i]) {
                visited[i] = true;
                list.add(tickets[i][1]);
                
                dfs(tickets[i][1], cnt + 1 , tickets);
                if(done) return;
                
                visited[i] = false;
                list.remove(list.size() - 1);

            }
        }
    }
}