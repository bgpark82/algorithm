package dynamic_programming.beginner;

import java.util.Arrays;
import java.util.Scanner;

public class B11727_1 {

    private static int[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        list = new int[size + 1];

        Arrays.fill(list, -1);

        list[1] = 1;
        list[2] = 3;

        int result = go(size);
        System.out.println(result);
    }

    private static int go(int n) {
        if(n == 1) return list[1];
        if(n == 2) return list[2];

        if(list[n] > 0) return list[n];

        list[n] = (go(n-1) + go(n-2) * 2)%10007;

        return list[n];
    }


}
