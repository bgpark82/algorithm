package brute_force.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B1759 {

    private static List<String> answer = new ArrayList<>();
    private static boolean[] check;
    private static String[] array;
    private static String[] list;
    private static int size;
    private static int pick;
    private static StringBuilder st = new StringBuilder();
    private static String[] clist = {"a","e","i","o","u"};

    // https://geehye.github.io/baekjoon-1759/#

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pick = sc.nextInt();
        size = sc.nextInt();
        array = new String[size];
        list = new String[pick];
        for (int i = 0; i < size; i++) {
            array[i] = sc.next();
        }
        Arrays.sort(array);
        dfs(0,0);
        print();
    }

    private static void dfs(int depth, int index) {
        // 3. 끝에 도달했을 때 정답
        if(index == pick) {
            answer.add(String.join("",list));
            return;
        }
        // 4. 조건에 맞지 않을 때 return
        if(depth == size) {
            return;
        }
        // 2. 문자를 넣어준다
        list[index] = array[depth];

        // 1. index를 늘려준다
        dfs(depth + 1,index + 1);
        dfs(depth + 1, index);
    }

    private static void print() {
        answer.forEach(item -> {
            int cons = 0;
            int vows = 0;
            for (int i = 0; i < item.length(); i++) {
                if(item.charAt(i) == 'a' || item.charAt(i) == 'e' || item.charAt(i) == 'i' || item.charAt(i) == 'o' || item.charAt(i) == 'u') vows++;
                else cons++;
            }
            if(cons >= 2 && vows >=1) {
                System.out.println(item);
            }
        });
    }
}
