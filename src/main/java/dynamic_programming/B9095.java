package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class B9095 {

    static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        // top-down
        // arr = Arrays.stream(arr).map(i -> i = sc.nextInt()).toArray();
        // Arrays.stream(arr).forEach(i -> cal(i));

        // bottom-top
        d = new int[11];
        d[0] = 1; d[1] = 1; d[2] = 2;
        arr = Arrays.stream(arr).map(i -> i = sc.nextInt()).toArray();
        Arrays.stream(arr).forEach(i -> {
            dp(i);
            System.out.println(d[i]);
        });

        sc.close();
    }

    // bottom-top
    public static void cal(int n) {
        int[] arr = new int[11];
        arr[0] = 1; arr[1] = 1; arr[2] = 2;
        for(int i = 3; i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        System.out.println(arr[n]);
    }

    // top-down
    public static int dp(int n){
        if(n == 1) return d[1];
        if(n == 0) return d[0];
        if(n == 2) return d[2];
        d[n] = dp(n-1) + dp(n-2) + dp(n-3);
        return d[n];
    }
};