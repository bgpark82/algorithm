package brute_force.back_tracking;

import java.util.Scanner;

public class B9663 {

    private static int[] answer = new int[15];
    private static int count = 0;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int row) {
        if(row == n) {
            count++;
            return;
        }
        for (int c = 0; c < n; c++) {
            answer[row] = c;
            // 유망하지 않으면 걸러져야 하므로 다음 column으로 넘어간다
            if(promising(row)) {
                // 유망하면 다음 row로 가서 퀸을 놓아야 한다
                dfs(row + 1);
            }
        }
    }

    private static boolean promising(int row) {
        for (int r = 0; r < row; r++) {
            if (answer[r] == answer[row] || row - r == Math.abs(answer[row] - answer[r])) {
                return false;
            }
        }
        return true;
    }
}


