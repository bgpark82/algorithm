#include <iostream>
#include <algorithm>
#include <unordered_map>
#include <vector>

using namespace std;

// 변수 정의
unordered_map<string, int> FoodMaps[11];
int MaxCnt[11] = {0};

void comb(string order, int pos, string cand) {
    if(pos >= order.length()) {
        int len = cand.length();
        if(len >= 2) {
            FoodMaps[len][cand]++; // 최초에는 0에서 시작
            MaxCnt[len] = max(FoodMaps[len][cand], MaxCnt[len]);
        }
        return;
    }

    comb(order, pos+1, cand + order[pos]);
    comb(order, pos+1, cand);
}

vector<string> solution(vector<string> orders, vector<int> course) {

    for(auto order: orders) {
        sort(order.begin(), order.end());
        comb(order, 0, "");
    }

    vector<string> answer;
    for(int len: course){
        for(auto item: FoodMaps[len]) {
            if(item.second >= 2 && item.second == MaxCnt[len]) {
                answer.push_back(item.first);
            }
        }
    }

    sort(answer.begin(),answer.end());

    return answer;
};

int main(void) {
    vector<string> orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
    vector<int> course = {2, 3, 4};

    auto answer = solution(orders, course);
    
    for(auto a: answer) {
        cout << a << endl;
    }

    return 0;
};
