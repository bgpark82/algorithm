package dynamic_programming.beginner;

import java.util.Scanner;

public class B1932 {

    private static int[][] arr;
    private static int[][] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        arr = new int[5][5];
        d = new int[5][5];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
                d[i][j] = -1;
            }
        }

        d[0][0] = arr[0][0];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i-1 > 0 || j-1 > 0) {
                    d[i][j] = Math.max(d[i-1][j-1],d[i-1][j]) + arr[i][j];
                }
            }
        }
//        dfs(size-1,size-1);
        System.out.println(d[size-1][size-1]);
    }

    private static int dfs(int i, int j) {
        if(i < j ) return 0;
        if(i < 0 || j < 0) return 0;
        if(i == 0 && j == 0) return arr[0][0];
        if(d[i][j] > 0) return d[i][j];
        int a = dfs(i - 1, j - 1) + arr[i][j];
        int b = dfs(i - 1, j) + arr[i][j];
        d[i][j] = Math.max(a, b);
        return d[i][j];
    }
}
