package dynamic_programming.beginner;

import java.util.Arrays;
import java.util.Scanner;

public class B1463 {

    private static int count = 0;
    private static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        answer = new int[number + 1];

        Arrays.fill(answer,-1);

        int answer = topDown(number);
        System.out.println(answer);
    }

    // topDown은 정답을 return한다
    private static int topDown(int number) {
        if(number == 1) return 0;

        // answer가 0보다 크면 이미 그 안에 값이 있는 것이므로
        if(answer[number] > 0) return answer[number];

        // 공통적으로 구한다
        // 해당 조건이 맞으면 계속 타고 내려간다
        // 이것이 하나의 정답
        answer[number] = topDown(number - 1) + 1;

        if(number % 2 == 0) {
            // 이것이 하나의 정답
            int tempAnswer = topDown(number / 2) + 1;
            if(answer[number] > tempAnswer) {
                answer[number] = tempAnswer;
            }
        } if(number % 3 == 0) {
            // 이것이 하나의 정답
            int tempAnswer = topDown(number / 3) + 1;
            if(answer[number] > tempAnswer) {
                answer[number] = tempAnswer;
            }
        }
        return answer[number];
    }
}
