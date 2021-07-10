public class UnionFind {
 
    public static void main(String[] args) {
        int[] parent = new int[10];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        unionParent(parent, 1, 2);
        unionParent(parent, 2, 3);
        unionParent(parent, 3, 4);
        unionParent(parent, 7, 8);
        unionParent(parent, 8, 9);

        System.out.println(isConnected(parent, 1, 4));
        System.out.println(isConnected(parent, 1, 7));

        unionParent(parent, 4, 9);

        System.out.println(isConnected(parent, 1, 7));
    }

    static int getParent(int[] parent, int x) {
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    static boolean isConnected(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        return (a == b);
    }
}
