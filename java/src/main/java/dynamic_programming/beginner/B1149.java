package dynamic_programming.beginner;

import java.util.Scanner;

public class B1149 {

    private static int[][] list;
    private static int[][] answer;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        list = new int[size][3];
        answer = new int[size][3];

        for (int i = 0; i < size; i++) {
            list[i][0] = sc.nextInt();
            list[i][1] = sc.nextInt();
            list[i][2] = sc.nextInt();
        }

        answer[0][0] = list[0][0];
        answer[0][1] = list[0][1];
        answer[0][2] = list[0][2];

        /**
         * answer : 1부터 i까지 번째 집에서 J까지 칠했을 때의 최소값의 합
         */
        for (int i = 1; i < size; i++) {
            // 정답을 구하면 제발 배열에 저장한게 정답이다...
            answer[i][0] = Math.min(answer[i-1][1], answer[i-1][2]) + list[i][0];
            answer[i][1] = Math.min(answer[i-1][0], answer[i-1][2]) + list[i][1];
            answer[i][2] = Math.min(answer[i-1][1], answer[i-1][0]) + list[i][2];
        }

        int min = Math.min(Math.min(answer[size - 1][0], answer[size - 1][1]), answer[size - 1][2]);

        System.out.println(min);
    }
}
