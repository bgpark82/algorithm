package greedy;

import java.util.Scanner;

/*
 * 1. 증가하는 모든 수열을 만들어 본다
 * 2. 각 순간의 가장 큰 수를 바꿔주는 방법
 */
public class B12015 {

    // 배열 중에서 자기 자신이 들어가야 할 부분을 이분탐색으로 찾는다
//    static int lower_bound(int[] a, int n, int key) {
//        // 가장 왼쪽부터 값이 있는 길이까지
//        int left = 0;
//        int right = n;
//        while (left < right) {
//            int mid = (left+right)/2;
//            // 입력값이 기존의 값보다
//            if (key <= a[mid]) {
//                right = mid;
//            } else {
//                left = mid+1;
//            }
//        }
//        return left;
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        int len = 0;
//        for (int i=0; i<n; i++) {
//            int num = sc.nextInt();
//            int p = lower_bound(a, len, num);
//            a[p] = num;
//            // 해당 위치가 같으면
//            if (len == p) len += 1;
//        }
//        System.out.println(len);
//    }
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        numbers = new int[size];
        int length = 0;
        for (int i = 0; i < size; i++) {
            int target = sc.nextInt();
            int index = lower_bound(length, target);
            numbers[index] = target;
            if(length == index) length += 1;
        }
        System.out.println(length);
    }

    public static int lower_bound(int length, int target) {
        int left = 0;
        int right = length;
        while(left < right) {
            int mid = (left + right) / 2;
            if(target <= numbers[mid]) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}
