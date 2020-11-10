package dynamic_programming.intermediate;

import java.util.Scanner;

public class B11060_2 {

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
            // 왜??
            if (d[i] == -1) continue;

            for (int j = 1; j <= arr[i]; j++) {
                if(i + j < size) {
                    // 통과했을 때, 방문하지 않았거나
                    // 이전 값보다 크다면
                    if( d[i+j] == -1 || d[i+j] > d[i] + 1) {
                        d[i + j] = d[i] + 1;
                    }
                }
            }
        }
        System.out.println(d[size-1]);
    }
}
