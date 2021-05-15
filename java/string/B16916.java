public class B16916 {

    public static void main(String[] args) {
        String s = "baekjoon";
        String p = "aek";
        int ans = solution(s, p);
        System.out.println(ans);
    }   
    
    static int solution(String s, String p) {

        return match(s, p);
    }

    static int match(String s, String p) {
        int n = s.length();
        int m = p.length();
        
        for(int i = 0; i < n - m; i++) {

            boolean ok = true;
            
            for(int j = 0; j < m; j++) {
                
                if(s.charAt(i+j) != p.charAt(j)) {
                    ok = false;
                }
            }

            if(ok) return i;
        }

        return -1;
    }
}
