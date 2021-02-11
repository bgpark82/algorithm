package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B11724 {

    private static List<Integer>[] 연결리스트;
    private static boolean[] check;
    /**
     * 1. 방향없음
     * 2. 같은 간선은 한번만
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int node = scanner.nextInt();
        int edge = scanner.nextInt();

        연결리스트 = new ArrayList[node + 1];
        check = new boolean[node + 1];

        for (int i = 1; i <= node; i++) {
            연결리스트[i] = new ArrayList<>();
        }

        for (int i = 1; i <= edge; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            연결리스트[from].add(to);
            연결리스트[to].add(from);
        }

        int count = 0;
        // 처음에는 그냥 1로 시작 (주어진 시작점이 없으므로)
        for (int i = 1; i <= node; i++) {
            // 다음 인덱스 (2,3,...)이 왔을 때 이미 방문했으면 걸러내기 위해
            if(!check[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 1. 시작점
     * 2. 연결리스트
     * 3. 체크
     */
    private static void dfs(int start) {
        // 방문한 적이 없으면 방문체크
        check[start] = true;
        List<Integer> nodes = 연결리스트[start];
        for (Integer node : nodes) {
            // 자식 노드한번씩 도는데 자식 노드들을 처음 꺼내 보는 것이므로 검증 필요하지
            if(!check[node]) {
                dfs(node);
            }
        }
    }
}
