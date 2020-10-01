package greedy;

import java.util.Scanner;

/**
 * 첫번쨰 칸의 스위치를 누른 경우와 누르지 않은 경우를 결정
 */
public class B2138 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        int[] result = new int[size];

        String next = sc.next();
        for (int j = 0; j < next.length(); j++) {
            array[j] = next.charAt(j) - '0';
        }
        String next1 = sc.next();
        for (int j = 0; j < next1.length(); j++) {
            result[j] = next1.charAt(j) - '0';
        }
        
    }
}
