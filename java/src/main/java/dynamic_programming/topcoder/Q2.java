package dynamic_programming.topcoder;

import java.util.Arrays;

public class Q2 {

    private static int[] weight = {3,4,1,2,3};
    private static int[] value = {2,3,2,3,6};
    private static int[][] d = new int[5][5];
    private static int max = 0;
    private static int ret = 0;


    public static void main(String[] args) {
//        dfs(0,0,0);
//        for (int i = 0; i < d.length; i++) {
//            Arrays.fill(d[i],-1);
//        }
//        dfs1(0,0);

        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < 11; j++) {
                d[i+1][j+weight[i]] = Math.max(d[i+1][j+weight[i]], d[i][j] + value[i]);
                        ret = Math.max(d[i+1][j+weight[i]],ret);
            }
        }
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

    /**
     * @param n : 몇 번째 물건까지 고려했는가?
     * @param w : 총 무게
     * @return 가치 합계의 최대값
     */
    private static int dfs1(int n, int w) {
        if(w > 10) return -1;
        if(n >= weight.length) return 0;
        if(d[n][w] >= 0) return d[n][w];
       d[n][w] = Math.max(dfs1(n+1, w), dfs1(n+1, w+weight[n]) + value[n]);
        return d[n][w];
    }
}
