package dynamic_programming;

import java.util.Scanner;

public class B15990 {

    static final long MOD = 1000000009;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] p = new long[100000+1][3];

        p[1][0] = 1;
        p[2][1] = 1;
        p[3][0] = 1;
        p[3][1] = 1;
        p[3][2] = 1;
        for(int i = 4; i <= 100000; i++){
            p[i][0] = p[i-1][1] + p[i-1][2];
            p[i][1] = p[i-2][0] + p[i-2][2];
            p[i][2] = p[i-3][0] + p[i-3][1];
            p[i][0] %= MOD;
            p[i][1] %= MOD;
            p[i][2] %= MOD;
        }

        int[] dp = new int[n];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = sc.nextInt();
        }
        for(int i = 0; i < dp.length; i++) {
            int j = dp[i];
            System.out.println((p[j][0] + p[j][1] + p[j][2])%MOD);
        }
        sc.close();
    }


}