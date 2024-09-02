import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // num = row  
        for(int i = 0 ; i < num ; i++){ // 0 ~ (num-1) 반복 (0 , 1, 2, 3, 4)
            for(int j = i ; j < num-1 ; j++){ // num-1번 공백 
                System.out.print(" "); // 한 row당 4, 3, ... , 1회 반복
            }
            for(int k = 0 ; k < (i * 2) + 1 ; k++){ // (i * 2) + 1 --> (0 * 2) + 1 = 1
                System.out.print("*"); // 1, 3, 5, ... n , n = odd
            }
            System.out.println(); //한 줄 끝 
        }
        //여기까지가 피라미드
        
        //여기부턴 역피라미드
        for(int i = 2 ; i <= num ; i++){ //2 ~ 5 반복 (2, 3, 4, 5)  
            for(int j = 1 ; j < i ; j++){ // (j, i)일 때 (1, 2), (1, 3), ... (1,num)  
                System.out.print(" "); // 한 row당 1, 2, ... , 4회 반복
            }
            for(int k = 0 ; k < (num - i) * 2 + 1 ; k++){ // (num - i) * 2 + 1 --> (5 - 2) * 2 + 1 = 7 , num은 고정 + i는 계속 증가로 7, 5, 3, 1  홀수로 줄어듬
                System.out.print("*"); 
            }
            System.out.println();
        }
        sc.close();
    }
}