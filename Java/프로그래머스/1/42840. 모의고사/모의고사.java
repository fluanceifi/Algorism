import java.util.*;

class Solution {
    // 1번: [1, 2, 3, 4, 5]
    // 2번: [2, 1, 2, 3, 2, 4, 2, 5]
    // 3번: [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    public static int[] num1 = {1, 2, 3, 4, 5};
    public static int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
    public static int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        Student s1 = new Student(1, 0);
        Student s2 = new Student(2, 0);
        Student s3 = new Student(3, 0);
        
        for(int i = 0 ; i < answers.length ; i++){
            if(answers[i] == num1[i % num1.length]) s1.score++;
            if(answers[i] == num2[i % num2.length]) s2.score++;
            if(answers[i] == num3[i % num3.length]) s3.score++;
        }
        
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.offer(s1); pq.offer(s2); pq.offer(s3);
        
        Student result = pq.poll();
        
        List<Integer> answer = new ArrayList<>();
        
        answer.add(result.id);
        
        for(Student s : pq) {
            if(result.score == s.score){
                answer.add(s.id);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Student implements Comparable<Student> {
    int id;
    int score;
    
    public Student(int id, int score) {
        this.id = id;
        this.score = score;
    }
    
    @Override
    public int compareTo(Student o) {
        if(o.score == this.score) return this.id - o.id;
        return o.score - this.score;
    }
}