package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MAX = 1000000;
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue = new LinkedList();
        boolean[] check = new boolean[MAX];           // 방문 여부 체크
        int[] dist = new int[MAX];                     // 거리 i를 몇번만에 방문했는지
        check[n] = true;
        dist[n] = 0;
        queue.add(n);
        while(!queue.isEmpty()) {
            int start = queue.remove();
            if(start-1 >= 0) {
                if(!check[start-1]){
                    queue.add(start-1);
                    check[start-1] = true;
                    dist[start-1] = dist[start] + 1;
                }
            }
            if(start+1 < MAX) {
                if(!check[start+1]){
                    queue.add(start+1);
                    check[start+1] = true;
                    dist[start+1] = dist[start] + 1;
                }
            }
            if(start*2 < MAX) {
                if(!check[start*2]){
                    queue.add(start*2);
                    check[start*2] = true;
                    dist[start*2] = dist[start] + 1;
                }
            }
        }
        System.out.println(dist[k]);
    }
}
