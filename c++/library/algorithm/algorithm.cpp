#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void print(vector<int> v) {
    for (int i = 0; i < v.size(); i++) {
        cout << v[i] << " ";
    }
    cout << endl;
}

void any_of(vector<int> v) {
    bool check = any_of(v.begin(), v.end(), [](int i) { return i % 2 == 0; });
    cout << check << endl;
    print(v);
}

void for_each(vector<int> v) {
    for_each(v.begin(), v.end(), [](int &n) { n++; });
    print(v);
}

void count(vector<int> v) {
    int cnt = count(v.begin(), v.end(), 3);
    cout << cnt << endl;
}

void count_if(vector<int> v) {
    int cnt = count_if(v.begin(), v.end(), [](int i) { return i >= 2; });
    cout << cnt << endl;
}

void mismatch(vector<int> v) {
    vector<int> v1 = {0, 1, 2, 3, 4};
    pair<vector<int>::iterator, vector<int>::iterator> result = mismatch(v.begin(), v.end(), v1.begin());
    print(v);

    auto it = v.begin();
    while (it != result.first) {
        cout << *it << " ";
        ++it;
    }
    cout << endl;
}

void find_end() {
    vector<int> v{1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4};
    vector<int> t1{1, 2, 3};

    vector<int>::iterator result = find_end(v.begin(), v.end(), t1.begin(), t1.end());

    cout << distance(v.begin(), result) << endl;
}

int main() {
    vector<int> v(10);
    for (int i = 0; i < v.size(); i++) {
        v[i] = i;
    }

    // 검색
    any_of(v);
    for_each(v);
    count(v);
    count_if(v);
    mismatch(v);
    find_end();

    return 0;
}