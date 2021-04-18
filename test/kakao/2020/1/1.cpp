#include <algorithm>
#include <iostream>

using namespace std;

#define INF 10000

string word = "";

void dynamic(string s, string sub, int cnt) {
    int len = sub.length();
    string next = s.substr(0, len);

    if (next == sub) cnt++;

    if (next != sub) {
        string tmp = (cnt == 1) ? "" : to_string(cnt);
        word.append(tmp + sub);
        cnt = 1;
    }

    if (s.length() < len) {
        word.append(s);
        return;
    }

    dynamic(s.substr(len), next, cnt);
}

int solution(string s) {
    int answer = INF;

    for (int len = 1; len <= s.size(); ++len) {
        word = "";
        string sub = s.substr(0, len);
        dynamic(s, sub, 0);
        int size = word.size();
        answer = min(size, answer);
    }

    return answer;
}

int main(void) {
    string s = "aaaaaaaaaab";
    int ans = solution(s);
    cout << ans << endl;
    return 0;
};