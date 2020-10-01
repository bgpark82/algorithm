package dynamic_programming.intermediate;

import java.util.Arrays;
import java.util.Scanner;

public class B10942 {

    private static int[] arr;
    private static Question[] q;
    private static int[] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        q = new Question[m];
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            q[i] = new Question(start, end);
        }
        Arrays.stream(arr).forEach(System.out::println);
        Arrays.stream(q).forEach(System.out::println);

        // m = 1,000,000
        for (int i = 0; i < m; i++) {
            Question question = q[i];
            int start = question.start;
            int end = question.end;

            // palindrome이 참일 경우


        }
    }

    // n = 2000
    // total = 2,000,000,000
    private static boolean palindrome(int start, int end) {
        /**
         * i == 0 : arr[start + i] == arr[end - i]
         * i == 1 : ...
         *
         * 홀수 : start == end
         * 짝수 : Math.abs(start - end) == 1
         *
         */
        // 짝수
        if(arr.length % 2 == 0) {

        // 홀수
        } else {

        }

        return true;
    }

    private static class Question{
        int start;
        int end;

        public Question(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Question{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
