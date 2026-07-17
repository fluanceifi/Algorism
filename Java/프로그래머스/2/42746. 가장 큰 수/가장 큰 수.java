import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        /*        
        [3, 30, 34, 5, 9] -> "9534330"
        
        3 vs 30 = 330 이니깐 3, 30 순서 고정.
        3 vs 34 = 343 이니깐 34, 3, 30 순서 고정.
        34 vs 5 = 534 이니깐, 5, 34, 3, 30 순서 고정.
        9 vs 5 = 95 이니깐, 9, 5, 34, 3 ,30 순서 고정.
        */
        // for(int i = 0 ; ~) String.valueOf(numbers[i])
        String[] nums = Arrays.stream(numbers)
                              .mapToObj(String::valueOf)
                              .toArray(String[]::new);
        
        
        StringBuilder sb = new StringBuilder();
        
        // a.compareTo(b) == return a - b;
        // 만약, 음수면 더 작은 값인 a가 앞으로 / 양수면 더 작은 값인 b가 앞으로 온다.
        // "303".compareTo("330") = -1 = (b + a)에 해당하는 a가 앞에 온다.
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));
        
        // 예외처리: numbers의 원소는 "0 이상" -> 모든 값이 0일 경우
        if(nums[0].equals("0")) return "0";
        
        for(int i = 0 ; i < nums.length ; i++) {
            sb.append(nums[i]);
        }
        
        return sb.toString();
        
    }
}