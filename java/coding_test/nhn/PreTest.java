package coding_test.nhn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PreTest {

    private static boolean[][] check;
    private static List<Integer> list = new ArrayList<>();
    private static int index = 0;

    private static void solution(int sizeOfMatrix, int[][] matrix) {

        check = new boolean[sizeOfMatrix][sizeOfMatrix];

        // TODO: 이곳에 코드를 작성하세요.
        for (int i = 0; i < sizeOfMatrix; i++) {                // 행
            for (int j = 0; j < sizeOfMatrix; j++) {            // 열
                int count = 0;
                if(matrix[i][j] == 1 && !check[i][j]) {
                    check[i][j] = true;
                    // 아래로 한칸
                    count += go(i, j+1, matrix);
                    // 오른쪽으로 한칸
                    count += go(i+1, j, matrix);
                }
                list.add(count);
            }
        }
        list.stream().forEach(System.out::println);
    }

    private static int go(int i, int j, int[][] matrix) {
        // 계속 들어갈 수 있도록
        // 0 만났을 때 return 하도록
        if(matrix[i][j] == 1 && !check[i][j]) {
            check[i][j] = true;
            return 1;
        }
        return 0;
    }

    private static class InputData {
        int sizeOfMatrix;
        int[][] matrix;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
            for (int i = 0; i < inputData.sizeOfMatrix; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.sizeOfMatrix; j++) {
                    inputData.matrix[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.sizeOfMatrix, inputData.matrix);
    }
}
