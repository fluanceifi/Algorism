import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toLowerCase().strip(); //입력 받은 input에 공백 제거 후 소문자로 변경
        if (input.length() > 1000000){
            System.out.println(input.length());
            return;
        }
        int[] cnt = new int[26]; //알파벳의 개수가 26개이므로
        for (int i = 0; i < input.length(); i++) {
            cnt[input.charAt(i) - 'a']++; //입력 받은 문자열 input의 첫번째 인덱스의 문자형 - 'a'를 하게 되면 해당 알파벳 위치에 맞는 cnt 인덱스에 값이 증가된다.
        }
        int maxCount = 0; //최대 빈도를 가진을 값을 세기 위한 변수
        char maxChar = ' '; //최대 빈도를 가진 값의 문자를 저장하기 위한 변수

        for(char ch = 'a'; ch <= 'z' ; ch++){ //알바펫 a to z까지 확인하기 위함
            int index = ch - 'a'; //int형으로 받았으니 ch - 'a'는 해당 알파벳에 맞는 cnt 인덱스와 같아진다. 이런경우 그냥 index = 0 으로 받고 ++로 해도 되지만 maxChar를 갱신하기 위해서 이렇게 한다.
            if(cnt[index] > maxCount){ //cnt[0]부터 cnt[25]까지 maxCount값과 비교해서 cnt가 더 크다면 max값 변경
                maxCount = cnt[index];
                maxChar = ch;
            }else if(cnt[index] == maxCount){// 만약 count값이 중복되면 ?출력
                maxCount = cnt[index];
                maxChar = '?';
            }
        }
        maxChar = Character.toUpperCase(maxChar);
        if (maxCount == 0){ //만약 input에 아무것도 입력안하게 되면 maxCount도 0이 되기 때문에 이런식으로 예외처리를 한다.
            System.out.println("Error");
        }else{
            System.out.println(maxChar);
        }
        return;
    }
}