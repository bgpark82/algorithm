package greedy;



import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B2109 {

    /*
     * 해당 날짜에서 가장 큰 값을 선택하도록 하는 것이 우선
     * 나머지 날짜 중에서 가장 금액이 높은 값을 선택한다
     * 주의
     * 다른 날짜 중에 해당 날짜보다 큰 페이가 있다면 그것을 선택하도록 한다
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Lecture[] a = new Lecture[n];
        for (int i=0; i<n; i++) {
            a[i] = new Lecture(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(a);
        int k = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int ans = 0;
        for (int i=10000; i>=1; i--) {
            while (k < n && a[k].d == i) {
                // 마이너스를 한 이유는 PriorityQueue는 가장 작은 값 먼저 나오기 때문이다.
                q.offer(-a[k].p);
                k += 1;
            }
            if (!q.isEmpty()) {
                ans += -q.poll();
            }
        }
        System.out.println(ans);
    }

    static class Lecture implements Comparable<Lecture> {
        int p, d;
        Lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }
        public int compareTo(Lecture that) {
            // 날짜를 기준으로 내림차순
            // 큰 날짜가 먼저와요 하위 날짜까지 커버 가능하기 때문이다
            // 예> 20일이 계속 큐에 남았을 때 1일까지가도 이 범위는 유효하기 떄문이다
            if (this.d < that.d) {
                return 1;
            } else if (this.d == that.d) {
                // 페이는 오름차순
                // 마지막에 들어갈 큐가 가장 높은 값이 되어야 하기 때문
                if (this.p < that.p) {
                    return -1;
                } else if (this.p == that.p) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        }
    }
}
