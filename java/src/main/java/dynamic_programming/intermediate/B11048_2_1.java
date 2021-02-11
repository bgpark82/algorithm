package dynamic_programming.intermediate;

import java.util.Scanner;

/**
 * i, j'로' 이동하는 방법
 * 1,1에서 마지막 까지 증가하면서 이동하는 방법
 */
public class B11048_2_1 {

    private static int[][] arr;
    private static int[][] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();

        int[][] arr = new int[row + 1][column + 1];
        int[][] d = new int[row + 1][column + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                d[i][j] = Math.max(d[i-1][j], d[i][j-1]) + arr[i][j];
            }
        }

        System.out.println(d[row][column]);
    }



}
