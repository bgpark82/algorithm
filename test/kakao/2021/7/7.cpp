#include <iostream>
#include <vector>

using namespace std;

#define INF 987654321

vector<int> Sales;
vector<vector<int>> Children(300000);
int Cost[300000][2];

void traversal(int node) {
    // 노드의 참석 여부
    Cost[node][0] = 0;
    Cost[node][1] = Sales[node];

    // 리프노드
    if (Children[node].empty()) {
        return;
    }

    // 최소한 한명만 참여
    int extra = INF;

    // 자식노드에 값 입력
    for (auto child : Children[node]) {
        traversal(child);
        // 자식이 참석하지 않은 것이 비용이 더 작다면
        if (Cost[child][0] < Cost[child][1]) {
            Cost[node][0] += Cost[child][0];
            Cost[node][1] += Cost[child][0];
            // 추가 비용 = 참석 시킨 비용과 기존의 비용 빼기 (부모 0, 자식 0일
            // 경우 한명이라도 참석 시켜야 하므로)
            extra = min(extra, Cost[child][1] - Cost[child][0]);
            // 자식이 참석하는 것이 비용이 더 작다면
        } else {
            Cost[node][0] += Cost[child][1];
            Cost[node][1] += Cost[child][1];
            // 추가 비용 = 한명이라도 참석하면 추가 비용 없음
            extra = 0;
        }
    }

    // 하
    Cost[node][0] += extra;
}

// 기본적으로 완전탐색을 염두해야겠구나. 왜냐면 컴퓨터처럼 사고해야 하니
int solution(vector<int> sales, vector<vector<int>> links) {
    Sales = sales;

    for (auto link : links) {
        int parent = link[0] - 1;
        int child = link[1] - 1;
        Children[parent].push_back(child);
    }

    traversal(0);

    return min(Cost[0][0], Cost[0][1]);
}

int main(void) {
    vector<int> sales = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
    vector<vector<int>> links = {{10, 8}, {1, 9},  {9, 7}, {5, 4}, {1, 5},
                                 {5, 10}, {10, 6}, {1, 3}, {10, 2}};
    int ans = solution(sales, links);
    cout << ans << endl;
    return 0;
};