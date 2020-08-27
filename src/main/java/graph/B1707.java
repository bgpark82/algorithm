package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class B1707 {

    static ArrayList<Integer>[] al;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            int node = sc.nextInt();
            int edge = sc.nextInt();
            al = new ArrayList[node + 1];
            for (int j = 1; j <= node; j++) {
                al[j] = new ArrayList<>();
            }
            for (int j = 1; j <= edge; j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
            }
        }
    }
}
