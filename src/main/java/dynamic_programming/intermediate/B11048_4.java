package dynamic_programming.intermediate;

import java.util.Scanner;

public class B11048_4 {

    // top bottom 방식일 경우 배열을 static으로 만드는 것이 recursive 함수를 만드는데 편하다.
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
                // 최대값이 0이 될 수도 있는데 이 경우
                d[i][j] = -1;
            }
        }
        System.out.println(go(row,column));
    }

//    Step 1. loop을 도는 i, j를 파라미터로 넣어 늘려준다. 반환값을 최대 사탕의 개수가 될 것이다.
//    private static int go(int i, int j) {
//
//    }

    // Step 2. 이전 단계에서의 최대 사탕 개수를 리턴한다.
//    private static int go(int i, int j) {
//        if(i == 0 || j == 0) return 0;
//        d[i][j] = Math.max(go(i-1,j), go(i, j-1)) + arr[i][j];
//        return d[i][j];
//    }

    // Step 3. 최저 조건에서 반환한다.
//    private static int go(int i, int j) {
//        if(i == 0 || j == 0) return 0;
//        d[i][j] = Math.max(go(i-1,j), go(i, j-1)) + arr[i][j];
//        return d[i][j];
//    }

    // Step 4. 최대 조건에서 반환한다.
    private static int go(int i, int j) {
        if(i == 0 || j == 0) return 0;
        // 이미 방문했다면 그것은 최대값이므로 변할일이 없다. 그래서 그냥 출력한다.
        if(d[i][j] >= 0) return d[i][j];
        // d[i][j]가 -1일 떄만 방문한다. 왜냐면 여기서 이미 최대값이 정해지기 때문이다.
        d[i][j] = Math.max(go(i-1,j), go(i, j-1)) + arr[i][j];
        return d[i][j];
    }


}
