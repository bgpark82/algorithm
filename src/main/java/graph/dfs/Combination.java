package graph.dfs;

public class Combination {

    private static int n = 5;                                        // 5가지 숫자 중
    private static int r = 3;                                        // 3개를 뽑을 경우
    private static int[] input = new int[]{1, 2, 3, 4, 5};           // 주어진 5가지 숫자
    private static int[] answer = new int[r];                        // 정답을 담을 배열

    public static void main(String[] args) {
        combination(0,0);
    }

    private static void combination(int index, int depth) {
        // 3. 마지막 노드까지 갔을 때 출력
        if(depth == r) {
            print();
            return;
        }
        if(index == n) {
            return;
        }
        // 1. 정답 입력
        answer[depth] = input[index];
        // 2. 다음 단계로 이동
        combination(index + 1,depth + 1);
        combination(index + 1, depth);
    }
    private static void print() {
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }
}
