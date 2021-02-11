package coding_test.nhn;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {

    private static void solution(int day, int width, int[][] blocks) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        for (int i = 0; i < day; i++) {
            int[] block = blocks[i];
            // 1. left 정의
            int left = 0;
            // 2. right 정의
            int right = width - 1;
            // 3. min 값 계산
            int min = Math.min(left, right);

            while(left > right) {
                go(left-1, right, block, min);
                go(left, right+1, block, min);
            }

            for (int b : block) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

    }

    private static void go( int left, int right, int[] block, int min) {
        for (int j = left; j <= right; j++) {
            if(block[j] < min) {
                block[j] = min;
            }
        }
    }


    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }
}
