#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    // regular
    vector<int> p{6, 3, 1, 2, 4, 8};
    pair<vector<int>::iterator, vector<int>::iterator> p1 =
        minmax_element(p.begin(), p.end());
    cout << *p1.first << *p1.second << endl;
    cout << distance(p.begin(), p1.first) << endl;
    cout << distance(p.begin(), p1.second) << endl;

    // simple
    vector<int> s{6, 3, 2, 1, 5};
    auto [min, max] = minmax_element(s.begin(), s.end());
    cout << *min << *max << endl;

    return 0;
};