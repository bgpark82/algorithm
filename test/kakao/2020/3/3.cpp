#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Node {
   public:
    Node() : child(), cnt(0) {}
    void insert(string str) {
        Node* curr = this;
        for (char ch : str) {
            curr->cnt++;
            if (curr->child[ch - 'a'] == nullptr)
                curr->child[ch - 'a'] = new Node();
            curr = curr->child[ch - 'a'];
        }
        curr->cnt++;
    }
    int search(string str) {
        Node* curr = this;
        for (char ch : str) {
            if (ch == '?') return curr->cnt;
            curr = curr->child[ch - 'a'];
            if (curr == nullptr) return 0;
        }
        return curr->cnt;
    }

   private:
    Node* child[26];
    int cnt;
};

Node ONode[10000];
Node RNode[10000];

vector<int> solution(vector<string> words, vector<string> queries) {
    vector<int> answer;

    for (string str : words) {
        ONode[str.length() - 1].insert(str);
        reverse(str.begin(), str.end());
        RNode[str.length() - 1].insert(str);
    }

    for (string str : queries) {
        if (str[0] != '?') {
            answer.push_back(ONode[str.length() - 1].search(str));
        } else {
            reverse(str.begin(), str.end());
            answer.push_back(RNode[str.length() - 1].search(str));
        }
    }

    return answer;
}

int main(void) {
    vector<string> words = {"frodo",  "front", "frost",
                            "frozen", "frame", "kakao"};
    vector<string> queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

    vector<int> ans = solution(words, queries);

    for (int a : ans) {
        cout << a;
    }

    return 0;
};