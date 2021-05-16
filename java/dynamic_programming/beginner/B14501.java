import java.util.Scanner;

public class B14501 {
    
    private static int[] t;
    private static int[] p;
    private static int[] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        t = new int[size+2];
        p = new int[size+2];
        d = new int[size+2];

        for(int i = 0; i < size; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int result = 0;
        for(int i = 0; i <= size; i++) {

            if(i + t[i] < size) {
                d[i + t[i]] = Math.max(d[i+t[i]], d[i] + p[i]);
                result = Math.max(result, d[i + t[i]]);
            }
            d[i+1] = Math.max(d[i+1],d[i]);
            result = Math.max(result, d[i + 1]);
        } 

        System.out.println(result);
    }
}
