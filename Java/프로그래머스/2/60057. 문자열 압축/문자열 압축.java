class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int step = 1; step <= s.length() / 2; step++) {
            int pos = 0; //연산 수행 위치
            int len = s.length();

            for (; pos + step <= s.length(); ) {
                String unit = s.substring(pos, pos + step);
                pos += step;

                int cnt = 0;
                for (; pos + step <= s.length(); ) {
                    if (unit.equals(s.substring(pos, pos + step))) {
                        cnt++;
                        pos += step;
                    } else {
                        break;
                    }
                }

                if (cnt > 0) {
                    len -= step * cnt;

                    /*
                     * 입력은 최대 1000이다.
                     */

                    if (cnt < 9)
                        len += 1; //숫자가 1자리 수 이라면 1개만늘리고
                    else if (cnt < 99)
                        len += 2; //숫자가 2자리 수 이라면 2개를 늘린다.
                    else if (cnt < 999)
                        len += 3; //숫자가 3자리 수 이라면 3개를 늘린다.
                    else
                        len += 4;

                }
            }
            answer = Math.min(answer, len);
        }
        return answer;
    }
}
//aaa
