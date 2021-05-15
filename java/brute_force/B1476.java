package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class B1476 {

    static int[] numbers;

    public static void main(String[] args) {
        /**
         * 숫자에 맞아 떨어지면 1을 더하는 방법
         */
//        Scanner scanner = new Scanner(System.in);
//        numbers = Arrays.stream(scanner.nextLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        int earth = 1;
//        int sun = 1;
//        int moon = 1;
//        int count = 1;
//        while(true) {
//            if(earth % 16 == 0) earth = 1;
//            if(sun % 29 == 0) sun = 1;
//            if(moon % 20 == 0) moon = 1;
//
//            if(isEarth(earth) && isSun(sun) && isMoon(moon)) {
//                break;
//            }
//            earth++;
//            sun++;
//            moon++;
//            count++;
//        }
//        System.out.println(count);
//

        /**
         * 해당 숫자들을 이 맞아 떨어지기 전까지는 방관하다가 맞아 떨어지면 출력
         * 메소드를 함축적으로 사용하는 연습을 좀 해야겠다
         */
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt()-1;
        int s = sc.nextInt()-1;
        int m = sc.nextInt()-1;
        for (int i=0;; i++) {
            if (i % 15 == e && i % 28 == s && i % 19 == m) {
                System.out.println(i+1);
                break;
            }
        }
    }

    private static boolean isEarth(int earth) {
        return earth == numbers[0];
    }
    private static boolean isSun(int sun) {
        return sun == numbers[1];
    }
    private static boolean isMoon(int moon) {
        return moon == numbers[2];
    }
}
