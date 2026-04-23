class Solution {
    public static int answer;
    
    public int solution(int n) {
        
        String binary = Integer.toBinaryString(n);
        binary = binary.replace("0", "");
        
        int len = binary.length();
        
        
        for(int i = n + 1 ; ; i++){
            String temp = Integer.toBinaryString(i);
            temp = temp.replace("0", "");
            
            int tempLen = temp.length();
            
            if(len == tempLen) {
                answer = i;
                break;
            }
        }
        return answer;
        
    }
}