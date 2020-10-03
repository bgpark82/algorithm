package greedy;

import java.util.Scanner;

public class B11047 {

    private static int[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int sum = sc.nextInt();

        list = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = sc.nextInt();
        }

        int count = 0;
        // 기준 : 가장 큰값 먼저
        for (int i = size - 1; i >= 0; i--) {
            int coin = list[i];
            count += sum / coin;
            sum %= coin;
        }
        System.out.println(count);
    }
}
