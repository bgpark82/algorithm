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

    // dfs : 리스트 꺼내기 전에 방문처리, Stack을 사용하지 않아도 상관없다
    private static void dfs(int start) {
        // 방문 했으면 return
        if(check[start]) return;
        // 방문 안했으면 true
        check[start] = true;
        System.out.print(start + " ");
        // 리스트 시작작
        for (int a : 인접리스트[start]) {
            // 방문 시
            dfs(a);
        }
    }
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;
        while(!q.isEmpty()) {
            int now = q.remove();
            System.out.print(now + " ");
            for (int a :  인접리스트[now]) {
                if(!check[a]) {
                    check[a] = true;
                    q.add(a);
                }
            }
        }
    }
}
