import java.util.*;
import java.io.*;

class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static int left, right;
    public static int n, result;
    public static int[] arr;
    public static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for( ; right < n ; right++){
            hm.put(arr[right], hm.getOrDefault(arr[right], 0) + 1);
        
            while(hm.size() > 2){
                hm.put(arr[left], hm.get(arr[left]) - 1);
                if(hm.get(arr[left]) == 0) hm.remove(arr[left]);
                left++;
            }
            
            result = Math.max(result, right - left + 1);
        }
        
        System.out.println(result);
    }
}