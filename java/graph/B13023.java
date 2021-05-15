package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B13023 {

    /**
     * 1. 인접 행렬     B -> C              간선 유무 O(1)
     * 2. 인접 리스트    D -> E              간선 찾기 O(V)
     * 3. 간선 리스트    A -> B  C -> D      간선 찾기 O(V)
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();

        boolean[][] 인접행렬 = new boolean[node][node];
        ArrayList<Integer>[] 인접리스트 = new ArrayList[node];
        List<Edge> 간선리스트 = new ArrayList<>();

        // 1. 인접 리스트의 경우 미리 빈 ArrayList 를 넣어준다
        for (int i = 0; i < node; i++) {
            인접리스트[i] = new ArrayList<>();
        }

        // 2. 값 입력
        for (int i = 0; i < edge; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            간선리스트.add(new Edge(from, to));
            간선리스트.add(new Edge(to, from));
            인접리스트[from].add(to);
            인접리스트[to].add(from);
            인접행렬[from][to] = 인접행렬[to][from] = true;
        }

        // 양방향이므로 한번 쌓을 때 from, to와 to, from인 두배의 간선을 쌓게된다.
        int length = edge * 2;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Edge e = 간선리스트.get(i);
                int A = e.from;
                int B = e.to;
                Edge e1 = 간선리스트.get(j);
                int C = e1.from;
                int D = e1.to;

                // 서로 같은 점이 되어버리면 순환하게 된다
                if(A == B || A == C || A == D || B == C || B == D || C == D) continue;

                // 1. 인접 행렬 : B,C가 연결되어 있는지 확인한다
                if(!인접행렬[B][C]) continue;

                // 2. 인접 리스트 : D에 연결된 E가 있는지 확인한다
                for (Integer E : 인접리스트[D]) {
                    // E가 D와 연결되어 있으면서도 A, B, C, D와 같은 숫자가 아니면 순환하지 않으므로 ABCED는 모두 연결되었다
                    if(E == A || E == B || E == C || E == D) continue;
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }


    // 클래스는 모두 내부 클래스로 생성, 폴더 구조를 위해
    static class Edge {
        int from, to;
        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
