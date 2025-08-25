class Solution {
    // "균현잡힌 괄호 문자열"의 인덱스 반환
    public int balancedIndex(String p){
        int cnt = 0; //왼쪽 괄호 개수
        for(int i = 0 ; i < p.length() ; i++){
            if((p.charAt(i) == '(')){
                cnt++;
            }
            else{
                cnt--;
            }
            if(cnt == 0) return i;
        }
        return -1;
    }

    // "올바른 괄호 문자열" 인지 판단
    public boolean checkProper(String p){
        int cnt = 0; //왼쪽 괄호 개수

        //만약 '(' -> ')' 순서라면 반복문이 끝까지 작동한다.
        //하지만 ')' -> '(' 순서라면 "cnt==0"을 먼저 만나게 될 것이다.
        for(int i = 0 ; i < p.length() ; i++){
            if(p.charAt(i) == '('){
                cnt++;
            }
            else{
                if(cnt == 0){
                    return false;
                }
                cnt--;
            }
        }
        return true;
    }

    //          () / ))(( / () -> ()(()) + () = ()(())()

    public String solution(String p) {
        String answer = "";

        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환한다.
        if (p.equals("")) return answer;

        int idx = balancedIndex(p); //처음부터 시작해, 균형잡힌 인덱스를 반환
        String u = p.substring(0, idx+1); //u는 균형잡힌 놈
        String v = p.substring(idx+1); //v는 u 이후 나머지

        // "올바른 괄호 문자열"이면, v에 대해 함수를 수행한 결과를 붙여 반환
        if(checkProper(u)){
            answer = u + solution(v); //u 이후 나머지는 재귀를 통해 반복된다.
        }
        // "올바른 괄호 문자열"이 아니라면 아래의 과정을 수행한다.
        else{
            answer = "(";
            answer += solution(v);
            answer += ")";
            u = u.substring(1, u.length() - 1); //처음 끝 제거
            String temp  = "";
            for(int i = 0 ; i < u.length() ; i++){
                if(u.charAt(i) == '(') temp += ")";
                else temp += "(";
            }
            answer += temp;
        }
        return answer;
    }
}