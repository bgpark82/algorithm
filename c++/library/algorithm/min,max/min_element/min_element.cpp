#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool comp(int a, int b) { return a < b; }

vector<int>::iterator cmin_element(vector<int>::iterator first,
                                   vector<int>::iterator last) {
    if (first == last) return first;

    vector<int>::iterator smallest = first;
    ++first;
    for (; first != last; ++first) {
        if (*first < *smallest) {
            smallest = first;
        }
    }
    return smallest;
}

int main(void) {
    // operator
    vector<int> v{1, 2, 3, 4, 5};
    vector<int>::iterator v1 = min_element(v.begin(), v.end());
    cout << *v1 << endl;

    // comparison
    vector<int> c{1, 2, 3, 4, 5};
    vector<int>::iterator c1 = min_element(c.begin(), c.end(), comp);
    cout << *c1 << endl;                      // min value
    cout << distance(c.begin(), c1) << endl;  // min location

    // equivalent
    vector<int> i{1, 1, 1, 4, 5};
    vector<int>::iterator i1 = min_element(i.begin(), i.end());
    cout << *i1 << endl;
    cout << distance(i.begin(), i1) << endl;
    cout << distance(i1, i.end()) << endl;

    // custom
    vector<int> custom{5, 4, 1, 2, 3, 1, 4, 5};
    vector<int>::iterator custom1 = cmin_element(custom.begin(), custom.end());
    cout << *custom1 << endl;
    cout << distance(custom.begin(), custom1) << endl;
    return 0;
};