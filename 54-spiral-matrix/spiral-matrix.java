class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        
        int m = matrix.length; //행
        int n = matrix[0].length; // 열
        boolean[][] visited = new boolean[m][n];

        int[] dy = {0,1,0,-1}; // 우, 하, 좌, 상
        int[] dx = {1,0,-1,0};
        
        int idx = 0;
                
        result.add(matrix[0][0]);
        visited[0][0] = true;
        
        int ny = 0;
        int nx = 0;

        while(true){
            if(result.size() == m * n)
                break;

            ny += dy[idx];
            nx += dx[idx];

            if(idx % 2 == 0){
                while(nx >= 0 && nx < n && !visited[ny][nx]){
                    result.add(matrix[ny][nx]);
                    visited[ny][nx] = true;
                    ny += dy[idx];
                    nx += dx[idx];
                }
                ny -= dy[idx];
                nx -= dx[idx];
            }
            else{
                while(ny >= 0 && ny < m && !visited[ny][nx]){
                    result.add(matrix[ny][nx]);
                    visited[ny][nx] = true;
                    ny += dy[idx];
                    nx += dx[idx];
                }
                ny -= dy[idx];
                nx -= dx[idx];
            }

            idx = (idx + 1) % 4;
        }
        
        return result;
    }
}