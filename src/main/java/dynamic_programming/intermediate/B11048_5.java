package dynamic_programming.intermediate;

import java.util.Scanner;

public class B11048_5 {

    private static int[][] arr;
    private static int[][] d;
    private static int row;
    private static int column;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        column = sc.nextInt();

        arr = new int[row + 1][column + 1];
        d = new int[row + 1][column + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                arr[i][j] = sc.nextInt();
                // 최대값이 0이 될 수도 있는데 이 경우
                d[i][j] = -1;
            }
        }
        // 뒤에서 부터 검색해서 1,1에서 답을 구하는 방법
        System.out.println(go(1,1));
    }

    private static int go(int i, int j) {
        if(i > row || j > column) return 0;
        if(d[i][j] >= 0) return d[i][j];
        // i+1, j = 아래 열로 쭉 이동,
        // i, j+1 = 열의 가장 끝으로 도달한 후, 행의 가장 끝으로 이동
        // i, j   = 모든 열, 행의 탐색이 끝나면 한칸위로 올라간다. 위의 방법을 반복
        d[i][j] = Math.max(go(i+1, j), go(i, j+1)) + arr[i][j];
        return d[i][j];
    }

    /**
     *                      i,j
     *                      1,1
     *                    /   \
     *                  2,1    1,2
     *                /   \     \
     *              3,1    2,2   1,3
     *                 \    \     \
     *                  3,2  2,3   1,4
     *                   \    \
     *                    3,3  2,3
     *                     \    \
     *                      3,4  2,4
     *
     *              하나의 열의 끝까지 갔다가 행의 끝으로 이동
     *              처음 행으로 돌아가 한칸 위로 이동
     *              오른쪽 행의 끝으로 이동
     *              처음 행으로 돌아가 한칸 위로 이
     */
}
