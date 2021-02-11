package dynamic_programming.topcoder;

public class Q1_dfs {

    private static int h = 4, w = 5;

    public static void main(String[] args) {

        int dfs = dfs(0, 0);
        System.out.println(dfs);
    }

    private static int dfs(int i, int j) {
        if(i > h || j > w) return 0;
        if(i == h && j == w) return 1;
        return dfs(i+1, j) + dfs(i, j+1);
    }
}
