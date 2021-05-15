import java.util.Scanner;

public class B2606 {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        int[] parent = new int[c+1];

        for(int i = 0; i <= c; i++) {
            parent[i] = i;
        }
        
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
            union(parent, a, b);
        }
        System.out.println(solution(parent,1));
    }

    static void union(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    static int findParent(int[] parent, int x) {
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent, parent[x]);
    }

    static int solution(int[] parent, int x) {
        int count = 0;
        for(int i = 2; i < parent.length; i++) {
            if(findParent(parent, i) == findParent(parent, x)) {
                count++;
            }
        }
        return count;
    }
}
