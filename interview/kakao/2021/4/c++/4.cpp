#include <iostream>
#include <vector>
#define INF 40000000

using namespace std;

int Map[200][200];

void map(int n, vector<vector<int>> fares) {
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (i == j) {
                Map[i][j] = 0;
            } else {
                Map[i][j] = INF;
            }
        }
    }

    for (auto fare : fares) {
        int start = fare[0] - 1;
        int end = fare[1] - 1;
        int dis = fare[2];
        Map[start][end] = dis;
        Map[end][start] = dis;
    }
}

// 3중 for문
// i, j로 가는 경우, 경유지를 거치는 경우와 그렇지 않은 경우 중 가장 거리가 짧은
// 방법을 선택
void floyd(int n) {
    // 경유지 인덱스 (모든 경유지를 돌면서)
    for (int k = 0; k < n; ++k) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (Map[i][k] + Map[k][j] < Map[i][j]) {
                    Map[i][j] = Map[i][k] + Map[k][j];
                }
            }
        }
    }
}

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    // map 생성
    map(n, fares);
    // 경유지 탐색
    floyd(n);

    --s;
    --a;
    --b;

    int answer = INF;
    for (int k = 0; k < n; ++k) {
        answer = min(answer, Map[s][k] + Map[k][a] + Map[k][b]);
    }

    return answer;
}

int main(void) {
    vector<vector<int>> fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2},
                                 {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
                                 {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
    int ans = solution(6, 4, 6, 2, fares);
    cout << ans << endl;
    return 0;
};