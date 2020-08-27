package brute_force.bitmask;

import java.util.Scanner;

/**
 * N개의 정수로 이루어진 수열이 있을 때,
 * 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 *
 * 정수, 양수인 부분 수열이므로 비트마스크로 충분히 해결 가능하다
 */
public class B1182 {

    //    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        int N = sc.nextInt();
//        int[] arr = new int[size];
//        // 5개의 숫자이므로 00000부터 11111까
//        for (int i = 0; i < size; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int answer = 0;
//        // 0 <= i <= 31
//        int total = (1 << size);
//        for (int i = 0; i < total; i++) {
//            /** i는 집합이 된다
//             *  1 = [0]
//             *  2 = [2]
//             *  3 = [2,1]
//             *  4 = [4]
//             *  5 = [4,1]
//             */
//            int sum = 0;
//            // 0 <= k <= 5
//            for (int k=0; k < size; k++) {
//                int temp = (i & (1 << k));
//                /** 집합에 0부터 5까지 있는지 살펴본다 */
//                if (temp != 0) {
//                    sum += arr[k];
//                }
//            }
//            if (sum == N) {
//                answer += 1;
//            }
//        }
//        System.out.println(answer);
//    }
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
