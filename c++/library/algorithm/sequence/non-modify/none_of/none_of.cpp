#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool pred(int i) {
    return i < 0;
}

int main(void) {
    vector<int> foo{1, 2, 3, 4, 5, 6};
    vector<int> doo{1, 2, 3, 4, 5, -6};

    cout << none_of(foo.begin(), foo.end(), pred) << endl;  // true, if all of element meet pred
    cout << none_of(doo.begin(), doo.end(), pred) << endl;  // false, if one of element doesn't meet pred

    return 0;
};