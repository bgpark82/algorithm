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

string toString(int hour) {
    return (hour / 10 == 0) ? "0" + to_string(hour) : to_string(hour);
}

string time(int time) {
    int hour = time / 60 / 60;
    int min = time / 60 % 60;
    int sec = time % 60;
    return toString(hour) + ":" + toString(min) + ":" + toString(sec);
}

pair<int, int> trim(string time) {
    stringstream ss(time);
    string start, end;
    getline(ss, start, '-');
    getline(ss, end, '-');
    return make_pair(convert(start), convert(end));
}

// 복잡한 도메인을 간단한 int, string의 collection으로 번역하는 과정
string solution(string play_time, string adv_time, vector<string> logs) {
    if (play_time == adv_time) {
        return "00:00:00";
    }

    vector<int> Play(100 * 3600);
    for (string log : logs) {
        pair<int, int> time = trim(log);
        for (int i = time.first; i < time.second; i++) {
            Play[i]++;
        }
    }

    int play = convert(play_time);
    int adv = convert(adv_time);

    // 64 비트에서 long 값
    long long sum = 0;
    for (int i = 0; i < adv; i++) {
        sum += Play[i];
    }

    int start = 0;
    long long max = 0;
    for (int i = adv; i < play; ++i) {
        sum = sum + Play[i] - Play[i - adv];
        if (sum > max) {
            max = sum;
            start = i - adv + 1;
        }
    }
    cout << start / 60 / 60 << endl;
    return time(start);
}

int main(void) {
    vector<string> logs = {"69:59:59-89:59:59", "01:00:00-21:00:00",
                           "79:59:59-99:59:59", "11:00:00-31:00:00"};
    string t = solution("99:59:59", "25:00:00", logs);

    cout << t << endl;
    return 0;
};