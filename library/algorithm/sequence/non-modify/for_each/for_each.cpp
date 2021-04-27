#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void cfor_each(vector<int>::iterator first, vector<int>::iterator last, void (*func)(int)) {
    while (first != last) {
        func(*first);
        ++first;
    }
}

void pred(int i) {
    cout << i << endl;
}

int main(void) {
    vector<int> foo{1, 2, 3, 4, 5};
    for_each(foo.begin(), foo.end(), pred);
    cfor_each(foo.begin(), foo.end(), pred);

    return 0;
};