package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13549 {

    /**
     * 덱 - 앞 뒤로 데이터를 넣을 수 있는 자료구조
     *
     * Queue : 이동 방법에 따른 경로 탐색
     * check : 방문 여부 확인, 방문했으면 방문하지 않는다
     * answer : 최소 방문 횟수 기록, 이전 최소 방문 횟수에 방법만큼 더해준다
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        int MAX = 100001;

        int[] answer = new int[MAX];
        /** 방문을 하지 않았다면 Max 값이므로 항상 입력된 값보다 크다 */
        boolean[] check = new boolean[MAX];
        Queue<Integer> q = new LinkedList();

        check[start] = true;
        q.add(start);
        answer[start] = 0;

        while(!q.isEmpty()) {
            int now = q.remove();

            if(now == end) {
                System.out.println(answer[now]);
                break;
            }
            if(now * 2 < MAX  && !check[now * 2]) {
                q.add(now * 2);
                answer[now * 2] = answer[now];
                check[now * 2] = true;
            }
            if(now - 1 >= 0  && !check[now - 1]) {
                q.add(now - 1);
                answer[now - 1] = answer[now] + 1;
                check[now - 1] = true;
            }
            if(now + 1 < MAX && !check[now + 1]) {
                q.add(now + 1);
                answer[now + 1] = answer[now] + 1;
                check[now + 1] = true;
            }
        }
    }
}
