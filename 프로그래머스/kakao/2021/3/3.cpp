#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

vector<vector<string>> Person;
vector<vector<string>> Query;

void getPerson(vector<string> info) {
    for (string i : info) {
        stringstream ss(i);
        string s;
        vector<string> p;
        while (getline(ss, s, ' ')) {
            p.push_back(s);
        }
        Person.push_back(p);
    }
}

void getQuery(vector<string> query) {
    for (string q : query) {
        stringstream ss(q);
        string s;
        vector<string> p;
        while (getline(ss, s, ' ')) {
            if (s != "and") {
                p.push_back(s);
            }
        }
        Query.push_back(p);
    }
}

vector<int> solution(vector<string> info, vector<string> query) {
    getPerson(info);
    getQuery(query);
    vector<int> answer(query.size());

    for (int i = 0; i < Person.size(); i++) {
        vector<string> per = Person[i];
        for (int j = 0; j < Query.size(); j++) {
            vector<string> que = Query[j];

            int cnt = 0;
            for (int k = 0; k < que.size() - 1; k++) {
                if (per[k] == que[k] || que[k] == "-") {
                    cnt += 1;
                }
            }
            if (stoi(per[4]) >= stoi(que[4])) {
                cnt += 1;
            }
            if(cnt == 5) {
                answer[j]++;
            }
        }
    }

    return answer;
}

int main(void) {
    vector<string> info = {"java backend junior pizza 150",
                           "python frontend senior chicken 210",
                           "python frontend senior chicken 150",
                           "cpp backend senior pizza 260",
                           "java backend junior chicken 80",
                           "python backend senior chicken 50"};
    vector<string> query = {"java and backend and junior and pizza 100",
                            "python and frontend and senior and chicken 200",
                            "cpp and - and senior and pizza 250",
                            "- and backend and senior and - 150",
                            "- and - and - and chicken 100",
                            "- and - and - and - 150"};

    auto answer = solution(info, query);

    for (auto a : answer) {
        cout << a << endl;
    }

    return 0;
};