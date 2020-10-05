package binary_search;

import java.util.Scanner;

public class B1790 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // k가 1부터 n까지 범위 밖이라면 -1 출력
        if(calc(n) < k) {
            System.out.println(-1);
            System.exit(0);
        }

        // 인덱스랑 실제 인덱스로 가져온 값이랑 구분해야겠구나
        int answer = go(n,k);

        int length = calc(answer);
        String ans = answer + "";
        System.out.println(ans.charAt(ans.length() - length + k - 1) + "");
    }

    // 1번부터 n번 숫자까지의 길이 반환
    private static int calc(int n) {
        int count = 0;
        for (int start = 1, digit = 1; start <= n; start *= 10, digit++) {
            int end = start * 10 - 1;
            if(n < end) {
                end = n;
            }
            count += (end - start + 1) * digit;
        }
        return count;
    }

    // 1부터 n까지 숫자의 합에서 원하는 길이 k값을 만족하는 숫자 반환
    private static int go(int n, int k) {
        int left = 1;
        int right = n;
        int answer = 0;
        while(left <= right) {
            int mid = (left + right)/2;
            int len = calc(mid);
            if(len < k) {
                left = mid + 1;
            } else {
                // len == k 인 경우가 있으므로 계속 정답을 저장한다?
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
}
