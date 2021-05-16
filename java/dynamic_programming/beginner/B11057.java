
import java.util.Arrays;
import java.util.Scanner;

public class B11057 {

    static private int[][] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        answer = new int[size + 1][10];
        Arrays.fill(answer[1], 1);

        for (int i = 2; i <= size; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                        answer[i][j] += answer[i-1][k];
                        answer[i][j] %= 10007;

                }
            }
        }

        int sum = Arrays.stream(answer[size]).sum();
        System.out.println(sum%10007);
    }
}
