#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Trie {
   public:
    Trie() { cnt = 0; };

    void insert(string s) {
        Trie* curr = this;
        for (char ch : s) {
            curr->cnt++;
            if (curr->children[ch - 'a'] == nullptr) {
                curr->children[ch - 'a'] = new Trie();
            }
            curr = curr->children[ch - 'a'];
        }
        curr->cnt++;
    }
    int search(string s) {
        Trie* curr = this;
        for (char ch : s) {
            if (ch == '?') return curr->cnt;
            curr = curr->children[ch - 'a'];
            if (curr == nullptr) return 0;
        }
        return 0;
    }

   private:
    int cnt;
    Trie* children[26];
};

// index : 단어의 길이
// Trie
//  - cnt : 문자의 개수
//  - child :
Trie Origin[10000];
Trie Reverse[10000];

vector<int> solution(vector<string> words, vector<string> queries) {
    vector<int> answer;

    for (string w : words) {
        Origin[w.length() - 1].insert(w);
        reverse(w.begin(), w.end());
        Reverse[w.length() - 1].insert(w);
    }

    for (string q : queries) {
        if (q[0] != '?') {
            answer.push_back(Origin[q.length() - 1].search(q));
        } else {
            reverse(q.begin(), q.end());
            answer.push_back(Reverse[q.length() - 1].search(q));
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
        cout << a << endl;
    }
    return 0;
};