import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int n;
    
    public static char[][] tree = new char[26][2];
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            tree[root-'A'][0] = leftChild;
            tree[root-'A'][1] = rightChild;
        }

        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');
        sb.append("\n");

        System.out.print(sb);
}

    public static void preorder(char current){
        if(current == '.') return;

        sb.append(current);
        preorder(tree[current - 'A'][0]);
        preorder(tree[current - 'A'][1]);
        
    }
    
    public static void inorder(char current){
        if(current == '.') return;

        inorder(tree[current - 'A'][0]);
        sb.append(current);
        inorder(tree[current - 'A'][1]);
        
    }
    
    public static void postorder(char current){
        if(current == '.') return;

        postorder(tree[current - 'A'][0]);
        postorder(tree[current - 'A'][1]);
        sb.append(current);

        
    }
    
    
}