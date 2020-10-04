package brute_force.recursion;

import java.util.Scanner;

public class B9095 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            int number = scanner.nextInt();
            System.out.println(go(0, number));
        }
    }

    // 백트래킹은 일단 자신있게 핵심로직 먼저 구하고 거를부분만 조건문에 맞게 써주면 된다
    // total count를 리턴
    private static int go(int sum, int number) {
        if(sum == number) {
            return 1;
        }

        if(sum > number) {
            return 0;
        }

        int total = 0;
        for (int i = 1; i <= 3; i++) {
            total += go( sum + i, number);
        }
        return total;
    }
}
