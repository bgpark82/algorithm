package coding_test.iportfolio;

public class Pelindrom {

    public static int solution(String plain) {
        int answer = 0;

        StringBuilder sb = new StringBuilder(plain);

        int count = 0;
        for (int i = 0; i < plain.length() -1 ; i++) {
            // 맨 앞과 맨 뒤가 다른 경우 대칭되는 자리에 값 추가
            if(sb.charAt(i) != sb.charAt(sb.length() - i - 1)) {
                count++;
//                sb.insert(sb.length() -i , sb.charAt(i));
            } else {
                continue;
            }
        }

        answer= count + plain.length();
//        answer = sb.length();
//        System.out.println(sb.toString());
//        System.out.println(sb.length());
//        System.out.println(count + plain.length());
        return answer;
    };

    public static void main(String[] args) {
        solution("ebisw");
    }
}
