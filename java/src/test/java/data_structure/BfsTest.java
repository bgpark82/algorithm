package data_structure;

import org.junit.Test;

public class BfsTest {

    @Test
    public void bfs() {
        String input = "XWY";
        boolean[] check = new boolean[input.length()];
        String[] answer = new String[input.length()];
        permutation(input.length(), 2, input, check, answer, 0);

    }

    public void permutation(int n, int r, String input, boolean[] check, String[] answer, int depth) {
        if(depth == r) {
            String ans = "";
            for(String s : answer) {
                if(s != null){
                    ans +=s;
                }
            }
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < n; i++){
            if (!check[i]) {
                check[i] = true;
                answer[depth] = "" + input.charAt(i);
                permutation(n, r, input, check, answer, depth+1);
                check[i] = false;
            }
        }
    }
}
