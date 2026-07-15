class Solution {
    public static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = (int) 1e9;
        boolean[] visited = new boolean[words.length];
        
        // 1. 변환할 수 없는 경우
        boolean check = false;
        for(int i = 0 ; i < words.length ; i++) {
            if (words[i].equals(target)) check = true;  
        }
        
        if (!check) return 0;
        
        // 2. 알파벳 하나만으로 똑같이 만들 수 있을까?
        // + 방문 순서는 상관이 없네?
        dfs(begin, target, words, 0, visited);
        
        
        
        return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, int cnt, boolean[] visited) {
        // 1. 종료조건
        if(begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i = 0 ; i < words.length ; i++) {
            // 불가능한 조건이거나, 이미 방문한 경우 스킵
            if(!isPossible(begin, words[i]) || visited[i]) continue;
            
            // 1. 방문 표시
            visited[i] = true;
            // 2. 방문
            dfs(words[i], target, words, cnt + 1, visited);
            // 3. 재귀가 끝나면 방문 취소 후, 반복문을 통해 다른 방식으로 방문
            visited[i] = false;
        }
    }
    
    public static boolean isPossible(String begin, String word) {
        int cnt = 0;
        
        for(int i = 0 ; i < begin.length() ; i++) {
            if(begin.charAt(i) != word.charAt(i)) cnt++;
        }
        
        return cnt == 1;
    }
}