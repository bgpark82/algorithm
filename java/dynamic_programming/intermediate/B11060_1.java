package dynamic_programming.intermediate;

import java.util.Scanner;

public class B11060_1 {

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

        d[0] = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                // 1. j의 위치에서 arr[j]를 더했을 때, i까지 갈 수 있을 경우
                // 2. d[j]를 이미 방문했을 경우 -> i가 미리 방문했기 때문에 가능하다
                if(d[j] != -1 && j + arr[j] >= i) {

                    // i번째 수를 방문하지 않은 경우
                    if(d[i] == -1 || d[i] > d[j] + 1) {
                        d[i] =  d[j] + 1;
                    }
                }
            }
        }

        System.out.println(d[size-1]);
    }
}
