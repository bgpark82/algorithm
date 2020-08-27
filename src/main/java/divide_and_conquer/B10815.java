package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10815 {

    public static void main(String[] args) throws IOException {
        // 버퍼 사용하는게 두배정도 빠르다
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(bf.readLine());
        int[] array1 = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int second = Integer.parseInt(bf.readLine());
        String[] array2 = bf.readLine().split(" ");
        for (int i = 0; i < second; i++) {
            int number = Integer.parseInt(array2[i]);
            boolean check = binary_search(number, array1);
            if(check) sb.append("1 ");
            else sb.append("0 ");
        }
        System.out.println(sb.toString());
    }

    static boolean binary_search(int number, int[] array) {
        int left = 0;
        int right = array.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(array[mid] == number) return true;
            else if(number < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
