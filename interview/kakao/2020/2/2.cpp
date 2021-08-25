#include <iostream>
#include <stack>
#include <vector>

using namespace std;

// 올바른 괄호 문자열 확인
bool check(string p, int* pos) {
    int l = 0;
    bool r = true;
    stack<char> s;
    for (int i = 0; i < p.size(); i++) {
        if (p[i] == '(') {
            ++l;
            s.push(p[i]);
        } else {
            --l;
            if (l < 0)
                r = false;
            else
                s.pop();
        }
        if (l == 0) {
            *pos = i + 1;
            return r;
        }
    }
    return r;
}

string solution(string p) {
    if (p.empty()) return p;

    int pos = 0;
    bool correct = check(p, &pos);

    string u = p.substr(0, pos);
    string v = p.substr(pos);

    // u가 올바른 문자열인 경우
    if (correct) return u + solution(v);

    // u가 올바른 문자열인 경우
    string answer = "(" + solution(v) + ")";
    for (int i = 1; i < u.size() - 1; i++) {
        answer += (u[i] == '(') ? ")" : "(";
    }

    return answer;
}

int main(void) {
    string p = "()))((()";
    string ans = solution(p);
    cout << ans << endl;
    return 0;
};