package coding_test.kakao.kakao2021;

import java.util.Arrays;

public class Q3 {

    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
        Arrays.stream(solution(info, query)).forEach(System.out::println);
    }

    public static int[] solution(String[] info, String[] query) {
        // 1. 각 배열의 문자열을 배열로 정리 (매칭 준비)
        String[][] infoArr = new String[info.length][5];
        String[][] queryArr = new String[info.length][5];
        String[] ti;
        String[] tq;
        for (int i = 0; i < info.length; i++) {
            tq = new String[5];
            ti = info[i].split(" ");
            infoArr[i] = ti;

            String[] temp = query[i].split(" and ");
            for (int j = 0; j < 4; j++) {
                tq[j] = temp[j];
            }
            String[] s = temp[3].split(" ");
            tq[3]= s[0];
            tq[4]= s[1];
            queryArr[i] = tq;
        }

        int[] answer = new int[info.length];

        // 2. 각 배열의 문자들을 하나하나 매칭
        for (int row = 0; row < queryArr.length; row++) {
            for (int i = 0; i < infoArr.length; i++) {
                boolean check = true;
                for (int j = 0; j < 5; j++) {
                    if(!check) break;
                    // 문자가 같거나 "-" 일 때
                    if(j == 4) {
                        if(Integer.parseInt(infoArr[i][j]) >= Integer.parseInt(queryArr[row][j])) {
                            continue;
                        }
                    }
                    if(queryArr[row][j].equals("-") || infoArr[i][j].equals(queryArr[row][j])) {
                        continue;
                    } else {
                        check = false;
                    }
                }
                if(check) {
                    answer[row] += 1;
                }
            }
        }
        return answer;
    }
}
