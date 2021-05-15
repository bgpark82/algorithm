package greedy;

import java.util.Scanner;

public class B1285 {

    static char flip(char x) {
        if (x == 'H') {
            return 'T';
        } else {
            return 'H';
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
        }
        int ans = n*n;
        // 한 행당 바뀐다 안바뀐다 두가지 경우가 존재
        // 그래서 총 경우는 2*2*2*... = 2^n
        // 0번 부터 2^n까지의 방법을 모두 다해본다
        // 행을 모두 바꾸면 열은 한가지 경우만 남는다
        // H의 개수가 T보다 많으면 뒤집고 아니면 말지 결정만 해주면 된다
        for (int state=0; state<(1<<n); state++) {
            // state 행을 바꿀지 말지만 결정
            int sum = 0;
            // j열
            for (int j=0; j<n; j++) {
                int cnt = 0;
                for (int i=0; i<n; i++) {
                    // 한 열씩 검색
                    char cur = a[i].charAt(j);
                    // i행을 모두 뒤집는 경우, i가 있는지 없는지 검사
                    int i1 = 1 << i;
                    // state = 0 : 000      i = 0행 : 000
                    // state = 1 : 001      i = 1행 : 010
                    // state = 2 : 010      i = 2행 : 100
                    // state = 3 : 011
                    // state = 4 : 100
                    // state = 5 : 101
                    // state = 6 : 110
                    // state = 7 : 111
                    if ((state & i1) != 0) {
                        cur = flip(cur);
                    }
                    if (cur == 'T') {
                        cnt += 1;
                    }
                }
                // cnt : T의 개수
                // n - cnt : H의 개수
                // 행의 H개수와 T의 개수
                sum += Math.min(cnt, n-cnt);
            }
            if (ans > sum) ans = sum;
        }
        System.out.println(ans);
    }
}
