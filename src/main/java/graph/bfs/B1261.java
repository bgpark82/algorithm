package graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1261 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        int[][] maze = new int[x][y];
        for (int i = 0; i < y; i++) {
            String s = sc.nextLine();
            String[] split = s.split("");
            for (int j = 0; j < x; j++) {
                maze[j][i] = Integer.parseInt(split[j]);
            }
        }
//        for (int i=0; i<y; i++) {
//            String s = sc.nextLine();
//            for (int j=0; j<x; j++) {
//                maze[j][i] = s.charAt(j) - '0';     // ASCII 문자를 위한 shift
//            }
//        }
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        int[][] answer = new int[x][y];
        for (int i = 0; i < x; i++) {
            Arrays.fill(answer[i], -1);               // int[행][열] : int[2][4] : int[y][x]
        }
//        for (int i=0; i<x; i++) {
//            for (int j=0; j<y; j++) {
//                answer[i][j] = -1;
//            }
//        }

        Queue<Pair> q = new LinkedList<>();
        Queue<Pair> next_q = new LinkedList<>();

        answer[0][0] = 0;
        q.offer(new Pair(0,0));

        while(!q.isEmpty()) {
            Pair now = q.remove();
            int nx = now.x;
            int ny = now.y;

            /**
             * 1. 벽이 1인 경우
             * 2. 미로 밖을 나가지 않을 경우
             * 3. 방문하지 않은 경우
             */
            for (int i = 0; i < 4; i++) {
                int tx = nx + dx[i];
                int ty = ny + dy[i];
                if(tx >= 0 && tx < x && ty >= 0 && ty < y) {
                    if(answer[tx][ty] == -1) {
                        if(maze[tx][ty] == 0) {
                            q.offer(new Pair(tx, ty));
                            answer[tx][ty] = answer[nx][ny];
                        }
                        if(maze[tx][ty] == 1) {
                            next_q.offer(new Pair(tx, ty));
                            answer[tx][ty] = answer[nx][ny] + 1;
                        }
                    }
                }
            }
            if(q.isEmpty()) {
                q = next_q;
                next_q = new LinkedList<Pair>();

            }
        }
        System.out.println(answer[x - 1][y - 1]);
    }

    static class Pair {

        public int x;
        public int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}


