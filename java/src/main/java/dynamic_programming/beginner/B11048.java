package dynamic_programming.beginner;

import java.util.Scanner;

public class B11048 {

    private static int[][] maze;
    private static boolean[][] check;
    private static int answer = 0;
    private static int[] dx = {0, 1, 1};
    private static int[] dy = {1, 0, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();

        maze = new int[row][column];
        check = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                maze[i][j] = sc.nextInt();
            }
        }



        dfs(0, 0, row, column, 0);
    }

    static private void dfs(int x, int y, int row, int column, int max) {
        if(y == row-1 && x == column-1) {
            if(answer < max) {
                answer = max;
                return;
            }
        }

        if(!check[y][x]) return;

        for (int i = 0; i < 3; i++) {
            int tx = dx[i];
            int ty = dy[i];

            if(x + tx < column && y + ty < row) {

            }
        }

        dfs(x + 1, y, row, column, max + maze[x][y]);
        dfs(x , y + 1, row, column, max + maze[x][y]);
        dfs(x + 1, y + 1, row, column, max + maze[x][y]);
    }

}
