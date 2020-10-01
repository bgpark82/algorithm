package data_structure;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class DfsTest {

    @Test
    public void dfs_list() {
        Map<String,Integer> map = new HashMap<>();
        String[] answer = new String[2];
        combination(0, 0, 2, "XWY", answer, map);
    }

    private static void combination(int index, int depth, int course_size, String order, String[] answer, Map<String, Integer> map) {
        // 3. 마지막 노드까지 갔을 때 Map에 입력
        if(depth == course_size) {
            String join = String.join("", answer);
            System.out.println(join);
//            if(map.get(join) == null) {
//                map.put(join,0);
//            }else {
//                map.put(join, map.get(join) + 1);
//            }
            return;
        }

        // 4. order의 사이즈를 넘어갔을 때는 그냥 리턴
        if(index == order.length()) {
            return;
        }
        // 1. 정답 입력
        answer[depth] = "" + order.charAt(index);
        // 2. 다음 단계로 이동
        combination(index + 1,depth + 1, course_size, order, answer, map);
        combination(index + 1, depth, course_size, order, answer, map);
    }
}
