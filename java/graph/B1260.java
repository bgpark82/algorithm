package graph;

import java.util.*;

public class B1260 {

    /**
     * 정점의 개수 = 0 ~ 1000
     * 간선의 개수 = 0 ~ 10000
     */
    static boolean[] check;
    static ArrayList<Integer>[] 인접리스트;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();
        int start = sc.nextInt();

        // 인접 리스트
        인접리스트 = new ArrayList[node + 1];

        for (int i = 1; i <= node; i++) {
            인접리스트[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < edge; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            인접리스트[from].add(to);
            인접리스트[to].add(from);
        }
        for (int i = 1; i <= node; i++) {
            Collections.sort(인접리스트[i]);
        }

        check = new boolean[node + 1];
        dfs(start);
        System.out.println();
        check = new boolean[node + 1];      // 새로 만드는 것도 방법이네
        bfs(start);

    }

    // 재귀호출
    // dfs를 for문 2개로 표현가능하다
    // 굳이 stack없어도 구현가능
    // 재귀호출은 하나의 start, 하나의 list, 하나의 check로 가능
    private static void dfs(int start) {
        // 2. 모든 노드 방문
        // 방문 했으면 return
        if(check[start]) return;
        // 방문 안했으면 true
        // dfs : 리스트 꺼내기 전에 방문처리
        check[start] = true;
        System.out.print(start + " ");
        // 리스트 시작작
        for (int a : 인접리스트[start]) {
            // 방문 시
            dfs(a);
        }
    }

    // 큐를 사용한다
    // 내부에서 큐를 정의할 수 있다 (굳이 외부에서 큐를 정의할 필요는 없다)
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;
        while(!q.isEmpty()) {
            int now = q.remove();
            System.out.print(now + " ");
            for (int a :  인접리스트[now]) {
                if(!check[a]) {
                    // bfs : 리스트에서 꺼낸 후 방문처리
                    check[a] = true;
                    q.add(a);
                }
            }
        }
    }
}
