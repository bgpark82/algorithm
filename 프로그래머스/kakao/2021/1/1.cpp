#include <algorithm>
#include <iostream>
#include <regex>
#include <string>
#include <vector>

using namespace std;

bool isValid(char c) {
    // 숫자나 알파벳일 경우 true
    if (isalnum(c)) {
        return true;
    }
    if (c == '-' || c == '_' || c == '.') {
        return true;
    }
    return false;
}

string solution(string new_id) {
    // string도 push_back이 가능하구나
    string answer = "";

    bool lastDot = false;
    for (char ch : new_id) {
        if (!isValid(ch)) continue;
        if (ch == '.') {
            if (answer.length() == 0 || lastDot) continue;
            lastDot = true;
        } else {
            lastDot = false;
        }

        ch = tolower(ch);

        answer.push_back(ch);
    }

    if (answer.length() >= 16) {
        answer.resize(15);
    }

    if (answer.back() == '.') {
        answer.pop_back();
    }

    if (answer.empty()) {
        answer.push_back('a');
    }

    char ch = answer.back();
    while (answer.length() < 3) {
        answer.push_back(ch);
    }

    return answer;
}

int main(void) {
    string new_id = "...!@BaT#*..y.abcdefghijklm";
    string ans = solution(new_id);

    cout << ans << endl;
    return 0;
};