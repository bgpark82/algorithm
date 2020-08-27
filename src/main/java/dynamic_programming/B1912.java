package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class B1912 {
    public B1912() {
    }

    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        int var2 = var1.nextInt();
        int[] var3 = new int[var2];
        int[] var4 = new int[var2];

        int var5;
        for(var5 = 0; var5 < var2; ++var5) {
            var3[var5] = var1.nextInt();
        }

        var4[0] = var3[0];

        for(var5 = 1; var5 < var2; ++var5) {
            if (var3[var5] < var4[var5 - 1] + var3[var5]) {
                var4[var5] = var4[var5 - 1] + var3[var5];
            } else {
                var4[var5] = var3[var5];
            }
        }

        var5 = Arrays.stream(var4).max().getAsInt();
        System.out.println(var5);
        var1.close();
    }
}
