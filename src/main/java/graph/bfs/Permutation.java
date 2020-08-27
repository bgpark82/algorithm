package graph.bfs;

public class Permutation {

    public static void main(String[] args) {
        int n = 3;                                  // 3가지 숫자 중
        int r = 2;                                  // 2개를 뽑을 경우
        int[] input = {1,2,3};                      // 주어진 3가지 숫자
        int[] answer = new int[r];                  // 정답을 담을 배열
        boolean[] check = new boolean[n];           // 해당 숫자를 방문했는지 체크


        // 순열
        permutation(n, r, input, check, answer, 0);
        // 중복순열
        permutationDup(n, r, input, answer, 0);
        // 조합
        combination(answer, input, n, r, 0, 0);
        // 중복조합
        combinationDup(answer, input, n, r, 0, 0);

    }

    public static void permutation(int n, int r, int[] input, boolean[] check, int[] answer, int depth) {
        if(depth == r) {
            print(answer);
            return;
        }

        for (int i = 0; i < n; i++){
            if (!check[i]) {
                check[i] = true;
                answer[depth] = input[i];
                permutation(n, r, input, check, answer, depth+1);
                check[i] = false;
            }
        }
    }

    public static void permutationDup(int n, int r, int[] input, int[] answer, int depth) {
        if(depth == r) {
            print(answer);
            return;
        }

        for (int i = 0; i < n; i++){
            answer[depth] = input[i];
            permutationDup(n, r, input,  answer, depth+1);
        }
    }

    public static void combination(int[] answer, int[] input, int n, int r, int depth, int index) {

        if(depth == r) {
            print(answer);
            return;
        }
        if(index == n) return;

        answer[depth] = input[index];
        combination(answer, input, n, r, depth + 1, index + 1);
        combination(answer, input, n, r, depth, index + 1);
    }

    public static void combinationDup(int[] answer, int[] input, int n, int r, int depth, int index) {

        if(depth == r) {
            print(answer);
            return;
        }
        if(index == n) return;

        answer[depth] = input[index];
        // 차이점은 depth는 안늘어나고 index만 늘어나네
        combinationDup(answer, input, n, r,depth + 1, index);
        combinationDup(answer, input, n, r, depth, index + 1);
    }

    public static void print(int[] answer) {
        for(Integer ans : answer) {
            System.out.print(ans + " ");
        }
        System.out.println();
    }
}

