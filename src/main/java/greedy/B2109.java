package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B2109 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Lecture[] lectures = new Lecture[size];
        for (int i = 0; i < size; i++) {
            lectures[i] = new Lecture(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(lectures);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int answer = 0;
        int count = 0;
        for (int i = 100000; i >= 1; i--) {
            while(count < size && lectures[count].day == i) {
                q.offer(-lectures[count].pay);
                count += 1;
            }
            if(!q.isEmpty()) {
                answer += -q.poll();
            }
        }
        System.out.println(answer);
    }

    static class Lecture implements Comparable<Lecture>{
        int pay;
        int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture that) {
            if(this.day < that.day) {
                // 내림차순
                return 1;
            } else if(this.day == that.day) {
                // 오름차순
                if(this.pay < that.pay) return -1;
                else if(this.pay == that.pay) return 0;
                else return 1;
            } else {
                return -1;
            }
        }
    }

}
