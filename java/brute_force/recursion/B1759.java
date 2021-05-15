package brute_force.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class B1759 {

    private static String[] list;
    private static String[] answer;
    private static int count;
    private static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        size = sc.nextInt();

        list = new String[size];
        answer = new String[count];

        for (int i = 0; i < size; i++) {
            list[i] = sc.next();
        }

        Arrays.sort(list);

        go(0, 0);
    }

    private static void go(int index, int depth) {

        if(depth == count) {
            if(check(answer)) {
                print(answer);
            }
            return;
        }

        if(index == size) {
            return;
        }

        answer[depth] = list[index];
        go(index + 1, depth + 1);
        go(index + 1, depth);
    }

    private static boolean check(String[] answer) {
        int vowel = 0;
        int consonant = 0;

        for (String node : answer) {
            if(node.equals("a") || node.equals("e") || node.equals("i") || node.equals("o") || node.equals("u")) {
                vowel += 1;
            } else {
                consonant += 1;
            }
        }
        return vowel >= 1 && consonant >= 2;
    }

    private static void print(String[] answer) {

        for (String node : answer) {
            System.out.print(node);
        }
        System.out.println();
    }
}
