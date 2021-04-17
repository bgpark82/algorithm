#include <cmath>
#include <iostream>
#include <map>
#include <queue>
#include <vector>

using namespace std;

#define INF 987654321

vector<vector<int>> Board;

struct Point {
    int row, col, cnt;
};

// 상하좌우 offset 값 정의
int D[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

// [bfs 탐색]
int bfs(Point src, Point dst) {
    bool visited[4][4] = {false};
    queue<Point> q;
    q.push(src);

    while (!q.empty()) {
        Point curr = q.front();
        q.pop();
        // 출발지와 목적지가 같은 경우
        if (curr.row == dst.row && curr.col == dst.col) {
            return curr.cnt;
        }
        // 상하좌우 탐색
        for (int i = 0; i < 4; ++i) {
            // 1칸 이동
            int nr = curr.row + D[i][0];
            int nc = curr.col + D[i][1];

            if (nr > 3 || nr < 0 || nc > 3 || nc < 0) {
                continue;
            }

            if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                q.push({nr, nc, curr.cnt + 1});
            }

            // 2칸, 3칸 이동한 경우
            for (int j = 0; j < 2; ++j) {
                if (Board[nr][nc] != 0) {
                    break;
                }
                if (nr + D[i][0] < 0 || nr + D[i][0] > 3 || nc + D[i][1] < 0 ||
                    nc + D[i][1] > 3) {
                    break;
                }

                nr += D[i][0];
                nc += D[i][1];
            }

            if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                q.push({nr, nc, curr.cnt + 1});
            }
        }
    }
    return INF;
}

// [순열: 전체탐색 ]
int permutate(Point src) {
    int ret = INF;
    // 순열을 나타낼 때는 보통 반복문을 사용 (1번 카드부터 6번카드까지 조회)
    for (int num = 1; num <= 6; ++num) {
        vector<Point> card;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (Board[i][j] == num) {
                    card.push_back({i, j, 0});
                }
            }
        }

        // 카드가 다 뒤집어진 경우
        if (card.empty()) continue;

        // 빈 공간에서 가장 가까운 카드까지 입력 횟수
        int one = bfs(src, card[0]) + bfs(card[0], card[1]) + 2;
        int two = bfs(src, card[1]) + bfs(card[1], card[0]) + 2;

        // 카드 삭제
        for (int i = 0; i < 2; ++i) {
            Board[card[i].row][card[i].col] = 0;
        }

        // 마지막 위치에서 탐색
        ret = min(ret, one + permutate(card[1]));
        ret = min(ret, two + permutate(card[0]));

        // 복원
        for (int i = 0; i < 2; ++i) {
            Board[card[i].row][card[i].col] = num;
        }
    }

    if (ret == INF) {
        return 0;
    }

    return ret;
}

int solution(vector<vector<int>> board, int r, int c) {
    Board = board;

    // initializer list
    return permutate({r, c, 0});
}

int main(void) {
    vector<vector<int>> board = {
        {1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}};
    int ans = solution(board, 1, 0);
    cout << ans << endl;
    return 0;
};