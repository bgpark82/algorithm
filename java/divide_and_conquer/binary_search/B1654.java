package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B1654 {

    private static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int k = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        list = new int[k];

        int max = 0;
        for (int i = 0; i < k; i++) {
            list[i] = Integer.parseInt(br.readLine());
            if(max < list[i]) {
                max = list[i];
            }
        }

        int answer = 0;

        int left = 1;
        int right = max;
        while(left <= right) {
            int mid = (left + right)/2;
            if(getTotal(mid) < n) {
                right = mid - 1;
            }  else {
                if(answer < mid){
                    answer = mid;
                };
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static int getTotal(int length) {
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            count += list[i]/length;
        }
        return count;
    }
}
