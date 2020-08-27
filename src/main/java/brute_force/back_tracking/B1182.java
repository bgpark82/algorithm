package brute_force.back_tracking;

import java.util.Scanner;

public class B1182 {

    private static int[] array;
    private static int size;
    private static int S;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        S = sc.nextInt();
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        dfs(0,0);
        if(S == 0) System.out.println(count-1);
        else System.out.println(count);
    }

    private static void dfs(int sum, int index) {
        // 유망하지 않으므로 원래 부모로 되돌린다
        if(index == size) {
            if (sum == S) {
                count++;
            }
            return;
        }

        dfs(sum + array[index], index+1);
        // 합은 그대로인 상태로 인덱스만 늘어나니까 맨 끝 노드로 갔을 때 정답이 될 수 있지
        dfs(sum, index + 1);

    }

}
