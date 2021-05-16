public class Permutation {

    private static int n = 5;
    private static int r = 3;
    private static int[] input = {1,2,3,4,5};
    private static boolean[] check = new boolean[n];
    private static int[] ans = new int[r];

    public static void main(String[] args) {

        // permRep(0);
        perm(0);
    }

    private static void perm(int depth) {
        if(depth == r) {
            print();
            return;
        }

        for(int index = 0; index < n; index++) {
            if(!check[index]) {
                check[index] = true;
                ans[depth] = input[index];
                perm(depth+1);
                check[index] = false;
            } 
        }
    }

    private static void permRep(int depth) {
        if(depth == r) {
            print();
            return;
        }
        
        for(int index = 0; index < n; index++) {
            ans[depth] = input[index];
            permRep(depth+1);
        }
    }

    public static void print() {
        for(Integer a : ans) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}

