package greedy;

import java.util.Scanner;

public class B12904 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();
        dfs(first,second);
        System.out.println(0);
    }
    private static void dfs(String first, String second) {

        if(first.equals(second)) {
            System.out.println(1);
            System.exit(0);
        }
        if(first.length() == second.length()) {
            return;
        }
        dfs(first + "A", second);
        dfs(new StringBuilder(first).reverse().toString() + "B", second);

    }
}
