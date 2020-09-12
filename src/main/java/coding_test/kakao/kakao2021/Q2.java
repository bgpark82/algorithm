package coding_test.kakao.kakao2021;

import java.util.*;
import java.util.stream.Collectors;

public class Q2 {

    public static void main(String[] args) {
        String[] order = new String[]{"XYZ", "XWY", "WXA"};
        int[] course = new int[]{2,3,4};
        String[] solution = solution(order, course);
        Arrays.stream(solution).forEach(System.out::println);

    }

    private static String[] solution(String[] orders, int[] course) {

        List<String> arr = new ArrayList<>();
        // 1. 각 코스 길이별로 조합의 수를 만들어 Map에 입력
        for (int course_size = 0; course_size < course.length; course_size++) {
            // 2. 각 조합들을 담을 map
            // key : 조합들
            // value : 조합들이 나온 횟수
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < orders.length; i++) {
                // 정답의 크기를 담아야 되므로 course_size를 크기를 갖는 배열
                int courseSize = course[course_size];
                String[] temp = new String[courseSize];
                combination(0, 0, courseSize, orders[i], temp, map);
            }

            int max_value = 0;
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                max_value = Math.max(max_value, entry.getValue());
            }

            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(max_value != 1 && entry.getValue().equals(max_value)) {
                    arr.add(entry.getKey());
                }
            }
        }

        Collections.sort(arr);

        return arr.toArray(new String[0]);
    }

    private static void combination(int index, int depth, int course_size, String order, String[] answer, Map<String, Integer> map) {
        // 3. 마지막 노드까지 갔을 때 Map에 입력
        if(depth == course_size) {
            String[] copy = new String[answer.length];
            for (int i = 0; i < copy.length; i++) {
                copy[i] = answer[i];
            }
            Arrays.sort(copy);
            String join = String.join("", copy);


            if(map.get(join) == null) {
                map.put(join,1);
            }else {
                map.put(join, map.get(join) + 1);
            }
            return;
        }

        // 4. order의 사이즈를 넘어갔을 때는 그냥 리턴
        if(index == order.length()) {
            return;
        }
        // 1. 정답 입력
        answer[depth] =  "" + order.charAt(index);
        // 2. 다음 단계로 이동
        combination(index + 1,depth + 1, course_size, order, answer, map);
        combination(index + 1, depth, course_size, order, answer, map);
    }
}
