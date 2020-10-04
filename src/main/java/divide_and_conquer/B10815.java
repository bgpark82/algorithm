package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10815 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 500,000번 정도면 BufferReader 써야되나?
        int[] list = Arrays.stream(br.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int r = Integer.parseInt(br.readLine());

        int[] answer = Arrays.stream(br.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        go(list, answer);
    }

    private static void go(int[] list, int[] answer) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            int number = answer[i];
            if(search(number, list)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean search(int number, int[] list) {

        // 리스트의 값이 아니라 인덱스
        int left = 0;
        int right = list.length - 1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(list[mid] == number) return true;
            if(number < list[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
