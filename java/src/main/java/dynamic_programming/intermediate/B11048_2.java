package dynamic_programming.intermediate;

import java.util.Scanner;

public class B11048_2 {

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
        // 이번에는 기준이 d[i][j]에서 한칸씩 옮겨졌을 때다.
        d[1][1] = arr[1][1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                // 오른쪽으로 한칸
                if(i + 1 <= row) {
                    // 출발 지점에서 한칸씩 옮기는 것은 다른 조건에서 해당 d[i][j]를 방문 했었을 수 있으므로 그 값과 더 큰값을 선택해줘야 한다
                    d[i + 1][j] = Math.max(d[i][j] + arr[i + 1][j], d[i + 1][j]);
                }
                // 아래로 한칸
                if(j + 1 <= column) {
                    d[i][j + 1] = Math.max(d[i][j] + arr[i][j + 1], d[i][j + 1]);
                }
                // 대각선으로 한칸
                // 대각선으로 가는 방법은 오른쪽->아래, 아래->오른쪽 가는방법보다 항상작다
//                if(i + 1 <= row && j + 1 <= column) {
//                    d[i + 1][j + 1] = Math.max(d[i][j] + arr[i][j + 1], d[i + 1][j + 1]);
//                }
            }
        }
        System.out.println(d[row][column]);
    }
}
