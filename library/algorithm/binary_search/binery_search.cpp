#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    vector<int> s{1, 3, 4, 5, 9};
    if (binary_search(s.begin(), s.end(), 3)) {
        cout << "found" << endl;
    }

    return 0;
};