package brute_force.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B14501 {

    private static List<Consultant> list = new ArrayList<>();
    private static int size;
    private static int max;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            int date = scanner.nextInt();
            int price = scanner.nextInt();
            list.add(new Consultant(date, price));
        }

        go(0, 0);
        System.out.println(max);
    }

    private static void go(int index, int sum) {

        if(index == size) {
            max = Math.max(max, sum);
            return;
        }

        if(index > size) {
            return;
        }

        int date = list.get(index).date;
        int price = list.get(index).price;

        // 가지칠 조건이 매우 중요하다
        // 갔다가 다시 돌아오는 개념이 중요하구나
        go(index + date, sum + price);
        go(index + 1, sum);
    }

    static private class Consultant {
        int date;
        int price;

        public Consultant(int date, int price) {
            this.date = date;
            this.price = price;
        }
    }
}



