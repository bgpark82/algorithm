package binary_search;

import java.util.Scanner;

public class B2805 {

    private static int[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        list = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
            if(max < list[i]) {
                max = list[i];
            }
        }

        int answer = 0;
        int left = 1;
        int right = max;
        while(left <= right) {
            int mid = (left + right)/2;
            if(getWood(mid) >= m) {
                answer = Math.max(mid,answer);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static int getWood(int mid) {
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if(list[i] - mid > 0) {
                count += list[i] - mid;
            }
        }
        return count;
    }
}
