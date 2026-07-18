import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        // 모든 값을 하나로 만들고 내림차순으로 정렬시킨다.
        // 배열의 절반 중, 가장 높은 0과 nameCard.length / 2 를 곱한다.
        List<Integer> width = new ArrayList<>();
        List<Integer> high = new ArrayList<>();
        
        for(int i = 0 ; i < sizes.length ; i++){
            int max = 0;
            int min = 0;
            if(sizes[i][0] >= sizes[i][1]) {
                max = sizes[i][0];
                min = sizes[i][1];
            } else{
                max = sizes[i][1];
                min = sizes[i][0];
            }
            width.add(max);
            high.add(min);
        }
        
        Collections.sort(width, Collections.reverseOrder());
        Collections.sort(high, Collections.reverseOrder());
        
        return width.get(0) * high.get(0);
        
    }
}