import java.util.Scanner;

public class B14426 {

    private static Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        root = new Node();  

        for(int i = 0; i < n; i++) {
            String txt = sc.next();
            insert(txt);
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            String ptn = sc.next();
            if(search(ptn)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean search(String ptn) {
        Node parent = root;
        boolean check = true;

        for(int j = 0; j < ptn.length(); j++) {

            int ascii = ptn.charAt(j) - (int)'a';
            
            if(parent.child[ascii] != null) {
                parent = parent.child[ascii];
            } else {
                check = false;
                break;
            }         
        }
        return check;        
    }

    static void insert(String txt) {
        
        Node parent = root;

        for(int i = 0; i < txt.length(); i++) {
            int ascii = txt.charAt(i) - (int)'a';
            if(parent.child[ascii] == null) {
                parent.child[ascii] = new Node();
            }
            parent = parent.child[ascii]; 
        }
        parent.isEnd = true;
    }

    static class Node {
        boolean isEnd;
        Node[] child = new Node[26];

        public Node() {
            this.isEnd = false;
            for(int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }
}
