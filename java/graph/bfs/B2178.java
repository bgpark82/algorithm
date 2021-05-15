import java.util.LinkedList;
import java.util.Queue;

public class B2178 {

    public static void main(String[] args) {
        int row = 4;
        int col = 6;
        int[][] map = {
            {1,0,1,1,1,1},
            {1,0,1,0,1,0},
            {1,0,1,0,1,1},
            {1,1,1,0,1,1}
        };

        // 방문 여부 확인
        boolean[][] check = new boolean[100][100];
        // 방문 시, 횟수 저장
        int[][] visit = new int[100][100];
        // 4방향을 방문
        int[][] offset = {{-1, 0},{1, 0}, {0, -1}, {0, 1}};

        Queue<Node> q = new LinkedList<>();
        check[0][0] = true; // 시작점 방문 확인
        visit[0][0] = 1; // 시작점 방문 횟수
        q.add(new Node(0, 0)); 

        while(!q.isEmpty()) {
            Node n = q.remove();
            
            for(int i = 0; i < 4; i++) {
                int x = offset[i][0] + n.x;
                int y = offset[i][1] + n.y;

                if(x >= 0 && x < row && y >= 0 && y < col) {
                    // 방문지가 1이고 방문 안한 경우
                    if(map[x][y] == 1 && !check[x][y]) { 
                            check[x][y] = true;
                            // 현재까지 방문한 횟수에서 1 증가
                            visit[x][y] = visit[n.x][n.y] + 1;
                            q.add(new Node(x,y));
                    }
                }
            }
        }

        System.out.println(visit[row-1][col-1]);
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
