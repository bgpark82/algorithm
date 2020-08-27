package brute_force.recursion;

import java.util.List;
import java.util.Scanner;

public class B14501 {

    private static int[] time;
    private static int[] money;
    private static int answer = 0;
    private static int size;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        time = new int[size]; money = new int[size];
        for (int i = 0; i < size; i++) {
            time[i] = sc.nextInt();
            money[i] = sc.nextInt();
        }
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int sum) {

        if(depth == size) {
            if(answer < sum) {
                answer = sum;
            }
            return;
        }
        if(depth > size) {
            return;
        }
        int t = time[depth];
        dfs(depth + t, sum + money[depth]);
        dfs(depth + 1, sum);
    }
}
