public class RabinKarp {

    private final static int d = 256; // extended ascii = 알파벳 캐릭터 숫자 = 256진수
    private final static int mod = 127; // hash 값을 127미만으로 줄이기 위해 사용

    public static void main(String[] args) {
        match("edabcde","abc");
    }

    static void match(String txt, String pattern) {
        int n = txt.length();
        int m = pattern.length();
        int t = 0;
        int p = 0;
        int h = 1;
        int i, j;

        // 패턴의 첫자리수 (ex. 십진수에서 100자리는 10^2)
        for(i = 0; i < m-1; i++) {
            h = (h * d)% mod;
        }

        // pattern의 크기만큼 txt와 pattern의 해시값 (txt가 "edbfd"이고 pattern이 "abc"라면 "edb"의 해시값)
        for(i = 0; i < m; i++) {
            p = d * p % mod + pattern.charAt(i) % mod;
            t = d * t % mod + txt.charAt(i) % mod;
        }
        
        for(i = 0; i <= n-m; i++) {
            if(p == t) {
                for(j = 0; j < m; j++) {
                    if(txt.charAt(i+j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if(j == m) {
                    System.out.println("pattern found " + i);
                }
            }
            
            if(i < n-m) {
                // txt의 다음 해시값
                t = d*t%mod - d*txt.charAt(i)*h%mod + txt.charAt(i+m)%mod;

                if(t < 0) {
                    t = t + mod;
                }
            }
        }
    }

    
    
}
