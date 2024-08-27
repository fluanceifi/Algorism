import java.util.Scanner;

public class Main {
    public static int reverse(int x){
        int rev = 0;
        while(x != 0){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        if ( 0 >= num1 || num1 >= 1000 || 0 >= num2 || num2 >= 1000){
            System.out.println("Invalid number");
            return;
        }

        num1 = reverse(num1);
        num2 = reverse(num2);

        if (num1 == num2){
            System.out.println("Equal Value");
        }
        else if(num1 > num2){
            System.out.println(num1);
        }
        else{
            System.out.println(num2);
        }
    }
}
