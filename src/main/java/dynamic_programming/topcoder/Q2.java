package dynamic_programming.topcoder;

public class Q2 {

    private static int[] weight = {3,4,1,2,3};
    private static int[] value = {2,3,2,3,6};
    private static int[][] d = new int[5][5];
    private static int max = 0;
    private static int ret = 0;


    public static void main(String[] args) {
        dfs(0,0,0);
    }

    /**
     * 본질은 '산다'와 '사지 않는다'로 나누는 것
     * @param n : 현재 보고있는 물건 번호
     * @param w : 현재 가지고 있는 무게
     * @param p : 현재 가지고 있는 물건의 가치
     * @return
     */
    private static void dfs(int n, int w, int p) {
        if(w > 10) return;
        ret = Math.max(ret, p);
        if(n >= weight.length) return;
        dfs(n+1, w, p);
        dfs(n+1, w + weight[n], p + value[n]);
    }
}
