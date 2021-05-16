
import java.util.Scanner;

public class B2193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n+1][2];
        dp[1][1] =1;
        for(int i = 2; i <= n; i++){
            dp[i][1] = dp[i-1][0];
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
        }
        System.out.println(dp[n][1] + dp[n][0]);
        sc.close();
    }
}