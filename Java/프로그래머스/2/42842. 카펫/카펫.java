// yellow = (c - 2) * (r - 2)

class Solution {
    public static int[] answer;
    
    public int[] solution(int brown, int yellow) { 
        
        for(int i = 1 ; i <= brown + yellow ; i++) {
            if((brown + yellow) % i == 0) {
                int r = (brown + yellow) / i;
                int c = i;
                
                if((r - 2) * (c - 2) == yellow) {
                    answer = new int[]{c, r};
                }
            }
        }
        
        return answer;
    }
}