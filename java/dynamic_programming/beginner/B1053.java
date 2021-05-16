
import java.util.Arrays;
import java.util.Scanner;

public class B1053 {

    private static int[] list;
    private static int[] d;
    private static int count = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        list = new int[size];
        d = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = sc.nextInt();
        }

        go(list);
        System.out.println(Arrays.stream(d).max().getAsInt());
    }

    private static void go(int[] list) {
        for (int i = 0; i < list.length; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if(list[j] < list[i] && d[i] < d[j] + 1) {
                     d[i] = d[j] + 1;
                }
            }
        }
    }
}
