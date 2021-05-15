package dynamic_programming.intermediate;

import java.util.Scanner;

public class B11048_3 {

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
                // d[i][j] : i,j에서 가지는 최대 사탕의 개수
                // d[i-1][j], d[i-1][j-1], d[i][j-1] 는 i, j의 한칸전 최대 사탕의 개수이다.
                // 여기에 arr[i][j] 더해지면 최대 사탕 개수가 된다.
                // 보통 대상의 값이 최대가 될 때, 그 과정을 알 수 없을 때 다이나믹 프로그래밍을 사용한다.
                // 사실 대각선은 의미없다.
                d[i][j] = Math.max(d[i-1][j], d[i][j-1]) + arr[i][j];
            }
        }
        System.out.println(d[row][column]);
    }


}
