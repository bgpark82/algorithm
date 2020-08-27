package brute_force.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11723 {

    public static void main(String[] args) throws IOException {
        // BufferReader, InputStreamReader와 readLine으로 시간절약 가능
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.valueOf(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int N = 21;
        int S = 0;
        for (int i = 0; i < size; i++) {
            String line = bf.readLine();
            String[] command = line.split(" ");
            if(command[0].equals("add")) {
                int number = Integer.parseInt(command[1]);
                S = S | (1 << number);
            } else if(command[0].equals("remove")) {
                int number = Integer.parseInt(command[1]);
                S = S & ~(1 << number);
            } else if(command[0].equals("check")){
                int number = Integer.parseInt(command[1]);
                int result = S & (1 << number);
                if(result == 0) {
                    sb.append("0\n");
                } else {
                    sb.append("1\n");
                }
            } else if(command[0].equals("toggle")) {
                int number = Integer.parseInt(command[1]);
                S = S ^ (1 << number);
            } else if(command[0].equals("all")) {
                S = (1 << N) - 1;
            } else if(command[0].equals("empty")) {
                S = 0;
            }
        }
        System.out.println(sb.toString());
    }
}
