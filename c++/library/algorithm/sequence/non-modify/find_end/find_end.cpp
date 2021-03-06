#include <iostream>
#include <vector>

using namespace std;

vector<int>::iterator cfind_end(vector<int>::iterator first1, vector<int>::iterator last1, vector<int>::iterator first2, vector<int>::iterator last2) {
    if (first2 == last2) {  // empty target
        return last1;
    }

    vector<int>::iterator ret = last1;
    while (first1 != last1) {
        vector<int>::iterator it1 = first1;
        vector<int>::iterator it2 = first2;
        while (*it1 == *it2) {
            ++it1;
            ++it2;
            if (it2 == last2) {
                ret = first1;
                break;
            }
            if (it1 == last1) {
                return ret;
            }
        }
        ++first1;
    }
    return ret;
}

bool pred(int i, int j) {
    return i == j;
}

int main(void) {
    vector<int> foo{1, 2, 3, 4, 5};
    vector<int> doo{2, 3, 4};

    cout << *find_end(foo.begin(), foo.end(), doo.begin(), doo.end()) << endl;
    cout << *cfind_end(foo.begin(), foo.end(), doo.begin(), doo.end()) << endl;
    cout << *find_end(foo.begin(), foo.end(), doo.begin(), doo.end(), pred) << endl;

    return 0;
};