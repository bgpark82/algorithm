import java.util.*;
import java.util.Map.Entry;

class Solution {

    // 메뉴 개수에 따라 max 사이즈만 궁금하다
    List<Map<String, Integer>> menus = new ArrayList<>();
    int[] max = new int[11];

    // dfs 탐색 + 백트레킹
    // 그래프의 가장 끝까지 갔을 때 데이터를 처리
    public void backtracking(String order, int index, String letter) {

        if (index >= order.length()) {
            if (letter.length() > 1) {
                int len = letter.length();
                Map<String, Integer> map = menus.get(len);
                map.compute(letter, (key, value) -> (value == null) ? 1 : value + 1);

                max[len] = Math.max(max[len], map.get(letter));
            }
            return;
        }

        // 2. 나중 조건
        backtracking(order, index + 1, letter + order.charAt(index));
        backtracking(order, index + 1, letter);
    }

    // 자바는 초기화 문제 발생
    // List 보다는 array
    void init() {
        for (int i = 0; i < 11; i++) {
            menus.add(new HashMap());
        }
    }

    String sort(String order) {
        char[] c = order.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    String[] ans(int[] course) {
        List<String> answer = new ArrayList<String>();

        for (int c : course) {
            int len = max[c];
            if (len <= 1)
                continue;
            Map<String, Integer> menu = menus.get(c);
            for (Entry<String, Integer> entry : menu.entrySet()) {
                if (entry.getValue() == len) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    public String[] solution(String[] orders, int[] course) {
        init();

        for (String order : orders) {
            order = sort(order);
            // 1. 초기값
            backtracking(order, 0, "");
        }

        return ans(course);
    }

    public static void main(String[] args) {
        String[] orders = { "XYZ", "XWY", "WXA" };
        int[] course = { 2, 3, 5 };
        Solution solution = new Solution();
        String[] ans = solution.solution(orders, course);
        for (String a : ans) {
            System.out.println(a);
        }
    }
}