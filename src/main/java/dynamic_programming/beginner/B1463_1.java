package dynamic_programming.beginner;

import java.util.Arrays;
import java.util.Scanner;

public class B1463_1 {

    private static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        answer = new int[size + 1];
        Arrays.fill(answer, -1);

        go(size);
    }

    // 숫자 n으로 1을 만드는 최소 방법의 수
    private static int go(int n) {
        if(n == 1) return 0;

        if(answer[n] > 0) return answer[n];

        answer[n] = go(n - 1) + 1;
        if(n % 2 == 0) {
            int temp = go(n/2) + 1;
            if(answer[n] > temp) {
                answer[n] = temp;
            }
        }
        if(n % 3 == 0) {
            int temp = go(n/3) + 1;
            if(answer[n] > temp) {
                answer[n] = temp;
            }
        }
        return answer[n];
    }
}
