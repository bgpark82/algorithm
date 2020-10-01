package dynamic_programming.intermediate;

import java.util.Arrays;
import java.util.Scanner;

// 다이나믹 프로그래밍 문제라고 인식하는 것이 중요하다
// 문제가 계속 작아짐을 깨달아야 한다!
// 점화식을 작성하는 것이 중요한 듯 하다.
public class B11060 {

    // 1 2 0 1 3 2 1 5 4 2
    // 1. 점화식 세우기
    // - i번째는 j번째에서 한칸 떨어져 있다고 볼 수 있다
    // - 그럼 j번째까지 오는 최소의 경우는 d[j]
    // - 그럼 i번째까지 오는 최소의 경우는 d[i] = d[j] + 1
    // 2. 조건 찾기
    // - j는 i보다 작거다
    // - i - j는 A[j] 보다 작거나 같

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] arr = new int[size];
        int[] d = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
            d[i] = -1;
        }

        d[0] = 0;
//        for (int i = 1; i < size; i++) {
//            for (int j = 0; j < i; j++) {
//                // -1이면 아직 가지않은 부분
//                if(d[j] != -1 && i - j <= arr[j]) {
//                    if(d[i] == -1 || d[i] > d[j] + 1) {
//                        d[i] = d[j] + 1;
//                    }
//                }
//            }
//        }
        // i에서 갈 수 있는 경우들을 구하는 경우
        for (int i = 0; i < size-1; i++) {
            if (d[i] == -1) continue;
            // 1부터 arr[i]칸 까지 모두 조사한다.
            for (int step = 1; step <= arr[i]; step++) {
                if (i+step >= size) {
                    break;
                }
                // 아에 방문하지 않았거나
                if (d[i+step] == -1 || d[i+step] > d[i] + 1) {
                    d[i+step] = d[i] + 1;
                }
            }
        }
        Arrays.stream(d).forEach(System.out::println);
    }

    static void recursive(int index, int size) {
        if(index > size) {

        }
    }
}
