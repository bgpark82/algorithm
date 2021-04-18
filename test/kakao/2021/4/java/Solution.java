public class Solution {

    private int[][] routes = new int[201][201];
    private int INF = 987654321;

    void getRoute(int[][] fares) {
        for (int[] fare : fares) {
            int start = fare[0] - 1;
            int end = fare[1] - 1;
            int dist = fare[2];

            // 그래프 양방향
            routes[start][end] = dist;
            routes[end][start] = dist;
        }
    }

    void floydwarshall(int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (routes[i][k] + routes[k][j] < routes[i][j]) {
                        routes[i][j] = routes[i][k] + routes[k][j];
                    }
                }
            }
        }
    }

    void init(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    routes[i][j] = 0;
                } else {
                    routes[i][j] = INF;
                }
            }
        }
    }

    int getMinPath(int n, int s, int a, int b) {
        int min = INF;
        for (int k = 0; k < n; k++) {
            min = Math.min(min, routes[s][k] + routes[k][a] + routes[k][b]);
        }
        return min;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        init(n);
        getRoute(fares);
        floydwarshall(n);
        return getMinPath(n, --s, --a, --b);
    }

    public static void main(String[] args) {
        int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
                { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };

        Solution q = new Solution();
        int min = q.solution(6, 4, 6, 2, fares);
        System.out.println(min);
    }

}
