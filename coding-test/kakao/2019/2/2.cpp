#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;

    vector<int> Stages(N);

    for (int i = 0; i < stages.size(); ++i) {
        int stage = stages[i];
        pair<int,int> p;
        for (int j = 1; j <= stage; j++) {
            if(j == stage) {
                
            }
            Stages[j - 1]++;
        }
    }

    for (int i = 0; i < Stages.size(); ++i) {

    }



    return answer;
}

int main(void) {
    vector<int> stages = {2, 1, 2, 6, 2, 4, 3, 3};
    solution(5, stages);

    return 0;
};