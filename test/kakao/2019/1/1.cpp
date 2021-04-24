#include <iostream>
#include <map>
#include <sstream>
#include <vector>

using namespace std;

struct Person {
    string status;
    string id;
    string name;
};

map<string, string> m;

vector<Person> people;

vector<string> solution(vector<string> record) {
    vector<string> answer;

    for (string r : record) {
        stringstream ss(r);
        string status, id, name;
        ss >> status >> id >> name;
        people.push_back({status, id, name});
        m.insert(make_pair(id, name));
    }

    for (Person p : people) {
        if (p.status == "Enter" || p.status == "Change") {
            m[p.id] = p.name;
        }
    }

    for (Person p : people) {
        if (p.status == "Enter")
            answer.push_back(m[p.id] + "님이 들어왔습니다.");
        if (p.status == "Leave") answer.push_back(m[p.id] + "님이 나갔습니다.");
    }

    return answer;
}

int main(void) {
    vector<string> record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                             "Leave uid1234", "Enter uid1234 Prodo",
                             "Change uid4567 Ryan"};

    auto ans = solution(record);
    for (auto a : ans) {
        cout << a << endl;
    }

    return 0;
};