#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool comp(int a, int b) { return (a < b); }

void print(int a, int b) { cout << "min: " << a << ", max:" << b << endl; }

int main(void) {
    // number
    pair<int, int> p = minmax(1, 2);
    print(p.first, p.second);

    // comparision
    pair<int, int> c = minmax(1, 2, comp);
    print(c.first, c.second);

    // initializer list
    pair<int, int> l = minmax({1, 2, 3, 4, 5});
    print(l.first, l.second);

    return 0;
};
