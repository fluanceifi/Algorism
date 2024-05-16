import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
        String getStr = sc.nextLine();
        getStr = getStr.strip();
        for (int i = 0; i < getStr.length(); i++) {
            if (getStr.charAt(i) == ' ') {
                cnt++;
            }
        }
        if(getStr.isEmpty()){
          System.out.println(cnt);
        }else {
            System.out.println(cnt + 1);
        }
    }
}


