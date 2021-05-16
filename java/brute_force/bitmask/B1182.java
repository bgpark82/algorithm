import java.util.Scanner;

/**
 * N개의 정수로 이루어진 수열이 있을 때,
 * 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 *
 * 정수, 양수인 부분 수열이므로 비트마스크로 충분히 해결 가능하다
 */
public class B1182 {

    static int ans = 0;

    public static void backtrack(int[]a, int sum, int index, int s) {
        if(index >= a.length) {
            if(sum == s) {
                ans ++;
            }
            return;
        }

        backtrack(a, sum+a[index], index+1, s);
        backtrack(a, sum, index+1, s);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = scan.nextInt();
        int [] a = new int[n];

        for(int i=0; i<n; i++)
            a[i] = scan.nextInt();
        backtrack(a, 0, 0, s);
        if(s == 0) ans--;
        System.out.println(ans);
    }


}
