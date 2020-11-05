package dynamic_programming.intermediate;

import java.util.Arrays;
import java.util.Scanner;

public class B15486 {

    private static Schedule[] schedules;
    private static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        sc.nextLine();

        schedules = new Schedule[size];
        answer = new int[size];

        for (int i = 0; i < size; i++) {
            String[] s = sc.nextLine().split(" ");
            schedules[i] = new Schedule(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        for (int i = 0; i < size; i++) {
            int day = schedules[i].day;
            int pay = schedules[i].pay;

            answer[i + day] = Math.max(answer[i] + pay, answer[i + day]);
            answer[i + 1] = Math.max(answer[i], answer[i+1]);
        }

        System.out.println(answer[size-1]);
    }


    static class Schedule {
        int day;
        int pay;

        public Schedule(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }

        @Override
        public String toString() {
            return "Schedule{" +
                    "day=" + day +
                    ", pay=" + pay +
                    '}';
        }
    }
}
