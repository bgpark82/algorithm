import java.util.*;

public class Q6 {

    int[][] boards;

    static class Point {
        int row;
        int col;
        int count;

        Point(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }

    }

    int bfs(Point src, Point target) {
        Queue<Point> q = new LinkedList();
        boolean[][] visited = new boolean[4][4];
        int[][] offset = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        q.add(src);

        while (!q.isEmpty()) {
            Point curr = q.element();
            q.remove();
            for (int i = 0; i < offset.length; i++) {
                int nRow = curr.row + offset[i][0];
                int nCol = curr.col + offset[i][1];

                if (curr.row == target.row && curr.col == target.col) {
                    return curr.count;
                }

                if (nRow < 0 || nCol < 0 || nRow > 3 || nCol > 3) {
                    continue;
                }

                if (!visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    q.add(new Point(nRow, nCol, curr.count + 1));
                }

                for (int l = 0; l < 2; l++) {

                    if (nRow + offset[i][0] < 0 || nRow + offset[i][0] > 3 || nCol + offset[i][1] < 0
                            || nCol + offset[i][1] > 3) {
                        break;
                    }

                    if (boards[nRow][nCol] != 0) {
                        break;
                    }

                    nRow += offset[i][0];
                    nCol += offset[i][1];
                }

                if (!visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    q.add(new Point(nRow, nCol, curr.count + 1));
                }
            }
        }
        return 1;
    }

    int permutation(Point src) {

        int min = 987654321;
        List<Point> points = new ArrayList<>();

        for (int num = 1; num <= 6; num++) {
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    if (boards[x][y] == num) {
                        points.add(new Point(x, y, 0));
                    }
                }
            }

            if (points.size() == 0)
                continue;

            Point a = points.get(0);
            Point b = points.get(1);

            int minA = bfs(src, a) + bfs(a, b) + 2;
            int minB = bfs(src, b) + bfs(b, a) + 2;

            boards[a.row][a.col] = 0;
            boards[b.row][b.col] = 0;

            min = Math.min(min, minA + permutation(b));
            min = Math.min(min, minB + permutation(a));

            boards[a.row][a.col] = num;
            boards[b.row][b.col] = num;
        }

        if (min == 987654321) {
            return 0;
        }

        return min;
    }

    public int solution(int[][] board, int r, int c) {
        boards = board;
        int answer = 0;

        // 1. 한점에서 유효한 카드까지 이동하는 방법
        answer = permutation(new Point(r, c, 0));

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = { { 1, 0, 0, 3 }, { 2, 0, 0, 0 }, { 0, 0, 0, 2 }, { 3, 0, 1, 0 } };
        Q6 solution = new Q6();
        int ans = solution.solution(board, 1, 0);
        System.out.println(ans);
    }
}
