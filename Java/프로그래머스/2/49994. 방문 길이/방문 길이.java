import java.util.*;
import java.io.*;

// 11 x 11 배열에서 (5, 5)로 시작한다.

class Node {
    int y;
    int x;
    
    public Node(int y , int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    public static int[] U = {-1, 0};
    public static int[] D = {1, 0};
    public static int[] R = {0, 1};
    public static int[] L = {0, -1};
    
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        HashMap<Character, int[]> map = new HashMap<>();
        
        // {y, x, direction, opposite} 
        map.put('U', new int[]{-1, 0, 0, 1});
        map.put('D', new int[]{1, 0, 1, 0});
        map.put('R', new int[]{0, 1, 2, 3});
        map.put('L', new int[]{0, -1, 3, 2});
        
        Node node = new Node(5, 5);
        
        
        for(int i = 0 ; i < dirs.length() ; i++) {
            int[] position = map.get(dirs.charAt(i));
            
            int beforeY = node.y;
            int beforeX = node.x;
            
            node.y += position[0];
            node.x += position[1];
            
            if(node.y >= 11 || node.y < 0 || node.x >= 11 || node.x < 0) {
                node.y -= position[0];
                node.x -= position[1];
                continue;
            }
            
            if(visited[node.y][node.x][position[2]] == true || 
              visited[beforeY][beforeX][position[3]] == true ) {
                continue;
            }
            
            visited[node.y][node.x][position[2]] = true;
            visited[beforeY][beforeX][position[3]] = true;
            answer++;
        }
        
        return answer;
        
    }
}