
import java.util.Arrays;
import java.util.Scanner;

public class B11053 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] d = new int[n];
        for(int i = 0; i < n; i++)
            arr[i]=sc.nextInt();

        for(int i = 0; i < n; i++){
            d[i] = 1;
            for(int j = 0; j < i; j++)
                if(arr[j] < arr[i] && d[i] < d[j] + 1 )
                    d[i] = d[j] + 1;
        }
        int result = Arrays.stream(d).max().getAsInt();
        System.out.println(result);

        sc.close();
    }
}