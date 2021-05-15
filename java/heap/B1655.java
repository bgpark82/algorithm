import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1655 {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        // 자바는 최소힙이 기본
        PriorityQueue<Integer> left = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue();

        for(int i = 0; i < size; i++) {
            
            int num = Integer.parseInt(br.readLine());

            if(left.isEmpty() || right.isEmpty()) {
                left.add(num);
            } else {
                if(num <= left.peek()) {
                    left.add(num);
                } else if(num >= right.peek()) {
                    right.add(num);
                } else {
                    left.add(num);
                }
            }
            
            while(!(left.size() == right.size() || left.size() == right.size() + 1)){
                if(left.size() > right.size()) {
                    right.add(left.poll());
                } else {
                    left.add(right.poll());
                }
            }
             
            System.out.println(left.peek());
        }
    }
}
