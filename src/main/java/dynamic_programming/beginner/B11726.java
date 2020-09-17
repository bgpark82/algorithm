package dynamic_programming.beginner;

import java.util.Scanner;

public class B11726 {

    static int[] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 2];
        d[1] = 1;
        d[2] = 2;

        // 1. TopDown
        // int result = dp2(n);
        // System.out.println(result%10007);

        // 2. BottomUp
        for(int i = 3; i <= n; i++){
            d[i] = d[i-1] + d[i-2];
            d[i] %= 10007;
        }
        System.out.println(d[n]);
        sc.close();
    }

    // public static int dp(int n){
    //     if(n == 1) return 1;
    //     if(n == 2) return 2;
    //     return dp(n-1) + dp(n-2);
    // }

    public static int dp2(int n){
        if(n == 1) return d[1];
        if(n == 2) return d[2];
        d[n] = dp2(n-1) + dp2(n-2);
        return d[n];
    }
}