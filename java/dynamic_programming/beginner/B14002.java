
import java.util.Scanner;

/**
 * B14002 역추적 하나의 값이 다른 하나의 값에 의해 바뀌는 것이 대부분 모든 경우의 수들을 다 기록하여 역추적
 */
public class B14002 {

    public void go(int p, int[] v){
        if(p == -1) return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        int[] v = new int[n];
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();

        for(int i = 1; i < n; i++){
            d[i] = 1;
            v[i] = -1;
            for(int j = 0; j < i; j++){
                if(a[j] < a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    v[i] = j;
                }
            }
        }
        int ans = d[0];


        System.out.println(ans);
        // go(p, v);
        System.out.println();
        sc.close();
    }

}