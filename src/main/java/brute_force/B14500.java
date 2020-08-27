package brute_force;

import java.util.Scanner;

public class B14500 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt() ;
        int m = scanner.nextInt();

        int[][] metrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                metrix[i][j] = scanner.nextInt();
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                /**
                 *   0 0 0 0
                 */
                if(j + 3 < m) {
                    int sum = metrix[i][j] + metrix[i][j+1] + metrix[i][j+2] + metrix[i][j+3];
                    if(max < sum) max = sum;
                }
                if(i + 3 < n) {
                    int sum = metrix[i][j] + metrix[i+1][j] + metrix[i+2][j] + metrix[i+3][j];
                    if(max < sum) max = sum;
                }
                /**
                 *   0 0 0
                 *       0
                 */
                if(j + 2 < m && i + 1 < n) {
                    int sum = metrix[i][j] + metrix[i][j+1] + metrix[i][j+2] + metrix[i+1][j+2];
                    if(max < sum) max = sum;
                }
                if(j + 2 < m && i - 1 >= 0) {
                    int sum = metrix[i][j] + metrix[i][j+1] + metrix[i][j+2] + metrix[i-1][j+2];
                    if(max < sum) max = sum;
                }
                /**
                 *   0 0
                 *     0 0
                 */
                if(j + 2 < m && i + 1 < n) {
                    int sum = metrix[i][j] + metrix[i][j+1] + metrix[i+1][j+1] + metrix[i+1][j+2];
                    if(max < sum) max = sum;
                }
                if(j + 2 < m && i - 1 >= 0) {
                    int sum = metrix[i][j] + metrix[i][j+1] + metrix[i-1][j+1] + metrix[i-1][j+2];
                    if(max < sum) max = sum;
                }
                /**
                 *      0
                 *    0 0
                 *    0
                 */
                if(j - 1 >= 0 && i + 2 < n) {
                    int sum = metrix[i][j] + metrix[i+1][j] + metrix[i+1][j-1] + metrix[i+2][j-1];
                    if(max < sum) max = sum;
                }
                if(j + 1 < m && i + 2 < n) {
                    int sum = metrix[i][j] + metrix[i+1][j] + metrix[i+1][j+1] + metrix[i+2][j+1];
                    if(max < sum) max = sum;
                }
                /**
                 *    0
                 *  0 0 0
                 */
                if (i+2 < n) {
                    int temp = metrix[i][j] + metrix[i+1][j] + metrix[i+2][j];
                    if (j+1 < m) {
                        int temp2 = temp + metrix[i+1][j+1];
                        if (max < temp2) max = temp2;
                    }
                    if (j-1 >= 0) {
                        int temp2 = temp + metrix[i+1][j-1];
                        if (max < temp2) max = temp2;
                    }
                }
                /**
                 *    0
                 *    0 0
                 *    0
                 */
                if (i+2 < n) {
                    int temp = metrix[i][j] + metrix[i+1][j] + metrix[i+2][j];
                    if (j+1 < m) {
                        int temp2 = temp + metrix[i+1][j+1];
                        if (max < temp2) max = temp2;
                    }
                    if (j-1 >= 0) {
                        int temp2 = temp + metrix[i+1][j-1];
                        if (max < temp2) max = temp2;
                    }
                }
                /**
                 *    0 0
                 *    0 0
                 */
                if(j + 1 < m  && i + 1 < n) {
                    int sum = metrix[i][j] + metrix[i+1][j] + metrix[i+1][j+1] + metrix[i][j+1];
                    if(max < sum) max = sum;
                }
            }
        }
        System.out.println(max);
    }

}
