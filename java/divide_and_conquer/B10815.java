import java.util.Arrays;
import java.util.Scanner;

public class B10815 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        StringBuilder sb = new StringBuilder();

        int c = sc.nextInt(); // 상근이가 가진 숫자 카드 개수 (1 ~ 500,000)
        int[] cards = new int[c];
        for(int i = 0; i < c; i++) {
            cards[i] = sc.nextInt(); // 카드 숫자 (-10,000,000 ~ 10,000,000)
        }
        Arrays.sort(cards);

        int n = sc.nextInt(); // 상근이가 가진 숫자 카드 개수 (1 ~ 500,000)
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt(); // 카드 숫자 (-10,000,000 ~ 10,000,000)
            if(search(cards, num)) sb.append("1 ");
            else sb.append("0 ");
        }
        System.out.println(sb.toString());
    }

    static boolean search(int[] cards, int num) {

        int left = 0;
        int right = cards.length-1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(num == cards[mid]) return true;
            if(num > cards[mid]) left = mid+1; // +1 해줘야 left와 right가 교차가능
            else right = mid-1; // -1 해줘야 left와 right가 교차가능
        }
        return false;
    }
}
