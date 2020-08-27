package graph.bfs;



import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1261 {

    static class Pair {

        public int x;
        public int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int column = sc.nextInt();
        int row = sc.nextInt();
        sc.nextLine();

        int[][] array = new int[row][column];
        int[][] answer = new int[row][column];
        for (int i = 0; i < row; i++) {
            array[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                answer[i][j] = -1;
            }
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<Pair> q = new LinkedList<>();
        Queue<Pair> next_q = new LinkedList<>();
        q.add(new Pair(0,0));
        answer[0][0] = 0;

        while(!q.isEmpty()) {
            Pair now = q.remove();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + now.x;
                int y = dy[i] + now.y;
                if(x >= 0 && x < column && y >= 0 && y < row) {
                    if(answer[y][x] == -1) {
                        if(array[y][x] == 0) {
                            q.add(new Pair(x, y));
                            answer[y][x] = answer[now.y][now.x];
                        }
                        if(array[y][x] == 1) {
                            next_q.add(new Pair(x, y));
                            answer[y][x] = answer[now.y][now.x] + 1;
                        }
                    }

                }
            }
            // 부술 벽이 0인 부분을 다 돌았으면 벽이 1인 부분을 돌면서 탐색
            if(q.isEmpty()) {
                q = next_q;
                next_q = new LinkedList<>();
            }
        }
        System.out.println(answer[row-1][column-1]);
    }
}


