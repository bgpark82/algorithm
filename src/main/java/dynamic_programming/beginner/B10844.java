package dynamic_programming.beginner;

import java.util.Scanner;

public class B10844 {

    static long MOD = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][10];
        for(int i = 1; i <= 9; i++) dp[1][i] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 9; j++){
                if(j-1 >= 0) dp[i][j] += dp[i-1][j-1];
                if(j+1 <= 9) dp[i][j] += dp[i-1][j+1];
                dp[i][j] %= MOD;
            }
        }
        long result = 0;
        for(int i = 1; i <= 9; i++)  result += dp[n][i];
        System.out.println(result%MOD);
        sc.close();
    }
}