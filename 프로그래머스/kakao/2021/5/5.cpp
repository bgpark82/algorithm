#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

int convert(string time) {
    stringstream ss(time);
    int h, m, s;
    char tmp;
    ss >> h >> tmp >> m >> tmp >> s;
    return h * 60 * 60 + m * 60 + s;
};

// 복잡한 도메인을 간단한 int, string의 collection으로 번역하는 과정
string solution(string play_time, string adv_time, vector<string> logs) {
    string answer = "";

    if (play_time == adv_time) {
        return "00:00:00";
    }

    convert(play_time);

    // for(auto log : logs) {
    //     stringstream ss(log);
    //     string start, end;
    //     getline(ss,start,'-');
    //     getline(ss,end,'-');
    // }

    return answer;
}

int main(void) {
    vector<string> logs = {"01:20:15-01:45:14", "00:40:31-01:00:00",
                           "00:25:50-00:48:29", "01:30:59-01:53:29",
                           "01:37:44-02:02:30"};
    solution("02:03:55", "00:14:15", logs);

    return 0;
};