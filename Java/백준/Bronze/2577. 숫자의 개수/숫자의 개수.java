import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int[] input = new int[3];
        int calc_num = 1;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            input[i] = sc.nextInt();
            calc_num *= input[i];
        }
        int[] digitCount = new int[10];

        String result = Integer.toString(calc_num);
        for(char digit : result.toCharArray()) {
            digitCount[digit - '0']++;
        }
        for (int j : digitCount) {
            System.out.println(j);
        }
    }
}
