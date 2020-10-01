package dynamic_programming.intermediate;

import java.util.Arrays;
import java.util.Scanner;

public class B15486 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        Schedule[] schedules = new Schedule[size];
        sc.nextLine();

        for (int i = 0; i < size; i++) {
            String[] s = sc.nextLine().split(" ");
            schedules[i] = new Schedule(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }


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
