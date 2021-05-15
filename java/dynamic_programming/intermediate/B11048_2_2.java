package dynamic_programming.intermediate;

import java.util.Scanner;

public class B11048_2_2 {

    private static int[][] arr;
    private static int[][] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();

        arr = new int[row + 1][column + 1];
        d = new int[row + 1][column + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                arr[i][j] = sc.nextInt();
                d[i][j] = -1;
            }
        }

        go(row,column);
        System.out.println(d[row][column]);
    }

    private static int go(int i, int j) {
        if(i < 1 || j < 1) return 0;
        if(d[i][j] > 0) return d[i][j];
        d[i][j] = Math.max(go(i-1, j), go(i, j-1)) + arr[i][j];
        return d[i][j];
    }


}
