class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int step = 1 ; step <= s.length()/2 ; step++){
            int pos = 0;
            int len = s.length();
            
            for( ; pos + step <= s.length() ; ){
                String unit = s.substring(pos, pos+step);
                pos += step;
                
                int cnt = 0;
                for( ; pos + step <= s.length() ; ){
                    if(unit.equals(s.substring(pos, pos + step))){
                        cnt++;
                        pos += step;
                    }
                    else{
                        break;
                    }
                }
            
                if(cnt > 0){
                    len -= step * cnt;


                    if(cnt < 9)
                        len += 1;
                    else if(cnt < 99)
                        len += 2;
                    else if(cnt < 999)
                        len += 3;
                    else
                        len += 4;
                }   
            }
            answer = Math.min(answer, len);
        }

        return answer;
    }
}