class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;

        int[][] newLock = new int[n*3][n*3];

        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < n ; j++){
                newLock[i + n][j + n] = lock[i][j]; //새 자물쇠는 크기가 3배이며 가운데에 위치한다. 나머지 빈 공간은 열쇠 삽입을 위한 공간이다.
            }
        }
        for(int rotation = 0 ; rotation < 4 ; rotation++) {
            //4번 회전 : 90 -> 180 -> 270 -> 360(원점)
            key = matrixRotation(key);

            for (int y = 1; y < n * 2; y++) { //newLock 기준 절대적 위치
                for (int x = 1; x < n * 2; x++) {

                    //키 삽입
                    for(int i = 0 ; i < m ; i++) { //key 기준 상대적 위치
                        for(int j = 0 ; j < m ; j++) {
                            newLock[y + i][x + j] += key[i][j];
                        }
                    }

                    //확인
                    if(check(newLock)) return true;

                    //키 제거
                    for(int i = 0 ; i < m ; i++) { //key 기준 상대적 위치
                        for(int j = 0 ; j < m ; j++) {
                            newLock[y + i][x + j] -= key[i][j];
                        }
                    }

                }
            }
        }

        return false;
    }

    public static int[][] matrixRotation(int[][] key) {
        int len = key.length;

        int[][] newKey = new int[len][len];

        for(int i = 0 ; i < len ; i++){
            for(int j = 0 ; j < len ; j++){
                newKey[j][len - i - 1] = key[i][j];
            }
        }
        return newKey;
    }

    public static boolean check(int[][] check){
        int len = check.length / 3;

        for(int i = 0 ; i < len ; i++){
            for(int j = 0 ; j < len ;j++){
                if(check[i + len][j + len] != 1) return false;
            }
        }
        return true;
    }
}