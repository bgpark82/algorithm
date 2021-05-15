package dynamic_programming.intermediate;

import java.util.Scanner;

public class B2156 {

    private static int[] arr;
    private static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] arr = new int[size];
        int[] d = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
            d[i] = -1;
        }

        d[0] = arr[0];
        for (int i = 2; i < size; i++) {
            // 1. 마시는 경우
            d[i] = Math.max(d[i-1],d[i-2]) + arr[i];

            // 2. 마시지 않는 경우

        }

        System.out.println(d[size-1]);
    }
}
