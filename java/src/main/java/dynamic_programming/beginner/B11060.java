package dynamic_programming.beginner;

import java.util.Arrays;
import java.util.Scanner;

public class B11060 {

    private static int[] list;
    private static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        answer = new int[size];
        Arrays.fill(answer, -1);

        list = Arrays.stream(sc.next().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        answer[0] = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                // 이미 방문
                if(answer[j] != -1 && i - j <= list[j]) {
                    if(list[i] == -1 || answer[i] > answer[j] + 1) {
                        answer[i] = answer[j] + 1;
                    }
                }
            }
        }


        for (int i = 0; i < size; i++) {
            if(answer[i] == -1) continue;
            /**
             * 변수 j 조건
             * 1. j < i
             * 2. i - j <= list[j]
             */
            for (int j = 0; j < list[i]; j++) {
                if(i + j >= size) break;
                if(answer[i + j] == -1 || answer[i + j] > answer[i] + 1){
                    answer[i + j] = answer[i] + 1;
                }
            }
        }

    }

}
