import javax.swing.*;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        int n = sc.nextInt();
        int[] score = new int[n];
        for(int i = 0 ; i < n ; i++){
            String ox = sc.next();
            for(int j = 0 ; j < ox.length() ; j++){
                if(ox.charAt(j) == 'X'){
                    cnt = 0;
                }
                else if(ox.charAt(j) == 'O'){
                    cnt += 1;
                    score[i] += cnt;
                }
            }
            cnt = 0;
        }
        for(int i = 0 ; i < n ; i++){
            System.out.println(score[i]);
        }
    }
}
