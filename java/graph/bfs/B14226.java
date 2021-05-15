package graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14226 {

    public static void main(String[] args) {

        /**
         * 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
         * 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
         * 3. 화면에 있는 이모티콘 중 하나를 삭제한다
         */

        int MAX = 1000;
        int target = 4;

        Queue<Integer> q = new LinkedList();
        int[][] answer = new int[target + 1][target + 1];
        for(int[] a : answer) {
            Arrays.fill(a,-1);
        }
        q.add(1);
        q.add(0);
        answer[1][0] = 0;

        while(!q.isEmpty()) {
            int start = q.remove();
            int clipboard = q.remove();

            // answer[start][start]를 한번도 방문한 적이 없다면 시도 가능하다.
            if(answer[start][start] == -1) {
                answer[start][start] = answer[start][clipboard] + 1;                       // 1. 화면의 모든 이모티콘을 복사해서 클립보드에 저장
                q.add(start);
                q.add(start);
            }
            // answer[start + clipboard][clipboard]를 한번도 방문한 적이 없다면 시도 가능하다.
            // 최종적으로 가고 싶은 곳이 start + clipboard 이기 때문에 target보다 커서는 안된다
            if( start + clipboard <= target && answer[start + clipboard][clipboard] == -1) {
                answer[start + clipboard][clipboard] = answer[start][clipboard] + 1;       // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
                q.add(start + clipboard);
                q.add(clipboard);
            }
            // start는 무조건 1부터 시작하기 때문에 1을 뺐을 때 0보다 작으면 안된다
            if(start - 1 >= 0 && answer[start - 1][clipboard] == -1) {
                answer[start - 1][clipboard] = answer[start][clipboard] + 1;                 // 3. 화면에 있는 이모티콘 중 하나를 삭제
                q.add(start -1);
                q.add(clipboard);
            }
        }
        for(int i = 0; i < target; i++) {
            System.out.println(answer[target][i]);
        }
        // 최종적으로 원하는 것은 해당 숫자로 가기위한 가장 최소의 방법의 수를 얻는 것이다.

    }
}
