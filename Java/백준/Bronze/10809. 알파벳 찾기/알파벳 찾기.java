import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] digit = new int[26];
        for (int i = 0; i < digit.length ; i++) {
            digit[i] = -1;
        }

        String s = sc.nextLine();
        for (int j = 0 ; j < s.length() ; j++){
           char ch = s.charAt(j);

           if (digit[ch- 'a'] == -1) {
               digit[ch - 'a'] = j;
           }
        }
        for (int k = 0 ; k < digit.length ; k++){
            System.out.print(digit[k] + " ");
        }
    }
}

