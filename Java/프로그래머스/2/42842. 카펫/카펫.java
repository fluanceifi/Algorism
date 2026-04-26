// yellow = (c - 2) * (r - 2)

class Solution {
    public static int[] answer;
    
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for(int c = 3 ; c <= total ; c++){
            if(total % c != 0) continue;
            int r = total / c;
            if(r < c) break;
            if((r-2)*(c-2) == yellow) return new int[]{r, c};
        }
        
        return new int[]{};
    }
}