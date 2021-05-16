
import java.util.Scanner;

public class B11727 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] c = new int[n+1];
        c[0] = 1;
        c[1] = 1;
        for(int i = 2; i <= n; i++){
            c[i] = c[i-1] + 2*c[i-2];
            c[i] %= 10007;
        }
        System.out.println(c[n]);
        sc.close();
    }
}