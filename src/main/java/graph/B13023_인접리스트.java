package graph;

import java.util.*;

public class B13023_인접리스트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();

        List<Integer>[] 인접리스트 = new ArrayList[node];

        for (int i = 0; i < edge; i++) {
            인접리스트[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            // 각 노드를 리스트에 넣어준다
            // 양방향이므로 두방향 다 입력한다
            인접리스트[start].add(end);
            인접리스트[end].add(start);
        }

        boolean[] check = new boolean[node];

        // stack을 놓은 이유는 각 ArrayList의 값들을 넣어놓기 위한 공간
        Stack<Integer> stack = new Stack<Integer>();
        // 인접리스트의 0번 인덱스부터 탐색
        stack.push(0);
        int count = 0;

        while(!stack.isEmpty()) {
            if(count == 5) {
                System.out.println(1);
                System.exit(0);
            }
            Integer index = stack.pop();
            if(!check[index]) {
                check[index] = true;
                count++;
                for (Integer n : 인접리스트[index]) {
                    stack.push(n);
                }
            }
        }
        System.out.println(0);
    }
}
