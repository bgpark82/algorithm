package coding_test.kakao.kakao2021;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmn.p"	));
    }

    static public String solution(String new_id) {
        // step 1. 대문자 -> 소문자
        new_id = new_id.toLowerCase();

        // step 2. 특수문자 제거
        new_id = new_id.replaceAll("[^a-z1-9-_.]","");

        // step 3. ...를 .로 치환
        String newId = "" + new_id.charAt(0);
        int index = 0;
        for (int i = 1; i < new_id.length(); i++) {
            if(newId.charAt(index) == '.' && newId.charAt(index) == new_id.charAt(i)) {
                continue;
            }
            char character = new_id.charAt(i);
            newId = newId + character;
            index += 1;
        }

        // step 4. 처음과 끝의 . 제거
        if(newId.charAt(0) == '.') {
            newId = newId.substring(1);
        }
        if(newId.length() >= 1 && newId.charAt(newId.length() -1) == '.') {
            newId = newId.substring(0, newId.length() -1);
        }

        // step 5. 빈문자열일 경우 a
        if(newId.length() == 0) {
            newId = "a";
        }

        // step 6. 15자 이상 제거
        if(newId.length() > 15) {
            newId = newId.substring(0, 15);
        }
        if(newId.length() >= 1 && newId.charAt(newId.length() -1) == '.') {
            newId = newId.substring(0, newId.length() -1);
        }

        // step 7. 길이가 1또는 2라면 맨 끝 문자를 반복하여 3으로 맞춘다
        if(newId.length() <= 2) {
            char lastChar = newId.charAt(newId.length() - 1);
            while(newId.length() <= 2) {
                newId += lastChar;
            }
        }
        return newId;
    }

}
