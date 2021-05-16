
import java.util.Scanner;

public class B1309 {

    private static int[][] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        answer = new int[size][3];

        answer[0][0] = 1;
        answer[0][1] = 1;
        answer[0][2] = 1;

        // N을 기준으로 문제를 나눈다
        // answer[i][0] = 2*N 배열 중 사자를 배치하지 않는 경우의 수
        // answer[i][1] = 2*N 배열 중 사자를 왼쪽에 배치하는 경우의 수
        // answer[i][2] = 2*N 배열 중 사자를 오쪽에 배치하는 경우의 수
        for (int i = 1; i < size; i++) {
            answer[i][0] = (answer[i-1][0] + answer[i-1][1] + answer[i-1][2]) % 9901;
            answer[i][1] = (answer[i-1][0] + answer[i-1][2]) % 9901;
            answer[i][2] = (answer[i-1][0] + answer[i-1][1]) % 9901;
        }

        System.out.println((answer[size-1][0] + answer[size-1][1] + answer[size-1][2]) % 9901);
    }
}
