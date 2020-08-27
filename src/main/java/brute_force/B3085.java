package brute_force;

import java.util.Scanner;

public class B3085 {

    static int check(char[][] a) {
        int n = a.length;
        int ans = 1;
        for (int i=0; i<n; i++) {
            int cnt = 1;
            for (int j=1; j<n; j++) {
                // 행 비교
                if (a[i][j] == a[i][j-1]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
            cnt = 1;
            for (int j=1; j<n; j++) {
                // 열 비교
                if (a[j][i] == a[j-1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        char[][] a = new char[size][size];
        for (int i = 0; i < size; i++) {
            a[i] = scanner.next().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // 해당 열의 마지막 칸을 제외한 이전 열을 대상으로
                if (j + 1 < size) {
                    // 임시 값 복사     대상 칸 = 오른쪽 칸     복사한 오른쪽 값을 대상 칸 값의 복사값 할당
                    char t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t;
                    // 바꾼 상태에서 행 열 중 가장 긴 값
                    int temp = check(a);
                    if (ans < temp) ans = temp;
                    t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t;
                }
                // 해당 행의 마지막 칸을 제외한 이전 행을 대상으로
                if (i + 1 < size) {
                    char t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
                    // 바꾼 상태에서 행 열 중 가장 긴 값
                    int temp = check(a);
                    if (ans < temp) ans = temp;
                    t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
                }
            }
        }
        System.out.println(ans);
    }
}
