package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13913 {

    // 조건에서 0 <= MAX <= 1000000이므로 총 100001개가 되어야 한다
    public static final int MAX = 100001;

    static void print(int[] answer, int dest, int start) {
        // return하거나 loop가 끝나면 마지막으로 실행된 자리로 되돌아간다
        if(dest != start) {
            print(answer, answer[dest], start);
        }
        System.out.print(dest + " ");
    }

    public static void main(String[] args) {
        // 100,000 * 1byte = 100,000byte / 1024 = 97kb;
        // String으로 계속 + 연산으로 잇는다면 새로운 String을 만들어 내는 것이므로 메모리 손실이 발생한다

        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int dest = sc.nextInt();
        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        int[] answer = new int[MAX];
        Queue<Integer> queue = new LinkedList<>();

        check[start] = true;
        dist[start] = 0;
        queue.add(start);

        while(!queue.isEmpty()) {
            int now = queue.remove();
            if(now - 1 >= 0) {
                if(!check[now - 1]) {
                    check[now - 1] = true;
                    queue.add(now - 1);
                    dist[now - 1] = dist[now] + 1;
                    answer[now - 1] = now;
                }
            }
            if(now + 1 < MAX) {
                if(!check[now + 1]) {
                    check[now + 1] = true;
                    queue.add(now + 1);
                    dist[now + 1] = dist[now] + 1;
                    answer[now + 1] = now;
                }
            }
            if(now * 2 < MAX) {
                if(!check[now * 2]) {
                    check[now * 2] = true;
                    queue.add(now * 2);
                    dist[now * 2] = dist[now] + 1;
                    answer[now * 2] = now;
                }
            }
        }
        System.out.println(dist[dest]);
        print(answer, dest, start);
    }
}
