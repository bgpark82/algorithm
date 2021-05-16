
import java.util.Arrays;
import java.util.Scanner;

public class B11726_1 {

    private static int[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        list = new int[size + 1];
        Arrays.fill(list, -1);

        list[1] = 1;
        list[2] = 2;
        System.out.println(go(size));
    }

    // 2xn 사각형을 채우는 방법의 수
    private static int go(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(list[n] > 0) return list[n];

        int first = go(n-1);
        int second = go(n-2);

        list[n] = first + second;

        return list[n];
    }
}
