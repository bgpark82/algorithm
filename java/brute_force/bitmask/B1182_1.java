package brute_force.bitmask;

import java.util.Scanner;

public class B1182_1 {

    private static int[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int target = sc.nextInt();

        list = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = sc.nextInt();
        }

        int ans = 0;
        // 전체 집합 개수 = 전체 경우의 수 = (1 << size) - 1
        // 아래는 1부터 시작하니까 (1 << size)까지 만큼 증가
        for (int i = 1; i < (1 << size); i++) {

            int sum = 0;
            // 배열의 자리를 돌면서 조합에서 배열의 자리가 있으면 합한다
            for (int j = 0; j < size; j++) {
                // 0 : 존재하지 않는 경우
                // 그외는 자리수 마다 어떤 값이 나올지 모르므로 존재한다는 의미이다
                if((i & (1 << j)) != 0) {
                    sum += list[j];
                }
            }
            if(sum == target) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}
