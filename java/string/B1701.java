import java.util.Arrays;
import java.util.Scanner;

public class B1701 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        String p = sc.next();
        
        int[] arr = kmp(p);
        System.out.println(Arrays.stream(arr).max().getAsInt()); 
    }

    static int[] kmp(String p) {
        int size = p.length();

        int[] next = new int[size];
        next[0] = 0;

        int count = 0;
        for(int i = 1; i < size; i++) {
            if(p.charAt(i) == p.charAt(count)) {
                count++;
                next[i] = count;
            } else {
                if(count > 0) {
                    count = next[count-1];
                } else {
                    next[i] = 0;
                }
            }
        }
        return next;
    }
}
