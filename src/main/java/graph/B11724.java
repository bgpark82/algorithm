package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B11724 {

    static ArrayList<Integer>[] 인접리스트;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();

        인접리스트 = new ArrayList[node + 1];

        for (int i = 1; i <= node; i++) {
            인접리스트[i] = new ArrayList<>();
        }
        // 인접리스트에는 간선 개수만큼의 from,to와 to,from이 들어가게 된다
        for (int i = 1; i <= edge; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            인접리스트[from].add(to);
            인접리스트[to].add(from);
        }
        check = new boolean[node + 1];
        int answer = 0;

        for (int i = 1; i <= node; i++) {
            // 이미 방문한 노드는 하위 노드가 없는 것이 판별되었음으로 더 들어갈 필요가 없다
            if(!check[i]) {
                dfs(i);
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int start) {
        if(check[start]) return;
        check[start] = true;
        for (int a : 인접리스트[start]) {
            if(!check[a]) {
                dfs(a);
            }
        }
    }
}
