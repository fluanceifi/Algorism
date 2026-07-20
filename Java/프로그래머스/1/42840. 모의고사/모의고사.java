import java.util.*;

class Solution {
//     public static int[] student1 = {1, 2, 3, 4, 5};
//     public static int[] studnet2 = {2, 1, 2, 3, 2, 4, 2, 5};
//     public static int[] studnet3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        /*
            10,000 * 10,000 = 100,000,000 -> n^2 가능
            if (answers[i] == studnets[0][i % students[0].length]) cnt[0]++;
            if (answers[i] == studnets[1][i % students[1].length]) cnt[1]++;
            if (answers[i] == studnets[2][i % students[2].length]) cnt[2]++;
            
            int[] temp = Arrays.copyOfRange(cnt, 0, 3);
            Arrays.sort(temp);
            
            for(int i = 0 ; i < 3 ; i++) { if(temp[2] == cnt[i]) answer.add(i)}
            
            Collections.sort(answer);
            
            return answer.stream().mapToInt(Integer::intValue).toArray();
        */
        int[][] students = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] cnt = new int[3];
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0 ; i < answers.length ; i++) {
            if (answers[i] == students[0][i % students[0].length]) cnt[0]++;
            if (answers[i] == students[1][i % students[1].length]) cnt[1]++;
            if (answers[i] == students[2][i % students[2].length]) cnt[2]++;
            
        }
        
        int[] temp = Arrays.copyOfRange(cnt, 0, 3);
        Arrays.sort(temp);
            
        for(int i = 0 ; i < 3 ; i++) { 
            if(temp[2] == cnt[i]) 
                answer.add(i+ 1); 
        }
            
        Collections.sort(answer);
            
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
    }
}