#include <algorithm>
#include <iomanip>
#include <iostream>
#include <iterator>
#include <numeric>
#include <string>
#include <utility>
#include <vector>

using namespace std;

void print(vector<int>& list) {
    for (int l : list) {
        cout << l << ", ";
    }
    cout << endl;
}

int main() {
    vector<int> v{1, 2, 3, 4, 5};

    // 1. at
    v.at(1) = 6;              // set element at index
    cout << v.at(1) << endl;  // get element at index
    // cout << v.at(10) << endl;    // out of range error (it will be much saferthan operator [])

    // 2. operator []
    v[1] = 5;
    cout << v[1] << endl;
    cout << v[10] << endl;

    // 3. front
    cout << v.front() << endl;
    cout << *v.begin() << endl;  // pointer of the first element address

    // 4. back
    cout << v.back() << endl;
    cout << *prev(v.end()) << endl;  // 1th predecessor of v.end()

    // 5. begin
    cout << *v.begin() << endl;

    // 6. end
    cout << *(v.end() - 1) << endl;

    // 7. rbegin
    cout << *v.rbegin() << endl;

    // 8. rend
    cout << *(v.rend() - 1) << endl;

    // 9. empty
    cout << v.empty() << endl;

    // 10. size
    cout << v.size() << endl;

    // 11. max_size
    cout << v.max_size() << endl;  // size limit of container

    // 12. capacity
    cout << v.capacity() << endl;  // current capacity without increasing size (1,2,4,6,16,...)

    // 13. clear
    // v.clear();

    // 14. insert (copy)
    cout << *v.insert(v.begin(), 100) << endl;                 // init, value : insert value before position
    cout << *v.insert(v.begin(), 1, 200) << endl;              // init, size, value : insert value before position with size
    cout << *v.insert(v.begin(), v.begin(), v.end()) << endl;  // init, range : insert range values before position

    // 15. emplace (construct)
    v.emplace(v.end(), -1);
    v.emplace(v.begin(), -1);

    // 16. erase
    cout << *v.erase(v.begin() + 2, v.end()) << endl;

    // 17. push_back
    string value = "hello";
    vector<string> values;
    values.push_back(value);
    values.push_back(move(value));  // move string value to vector
    cout << quoted(value) << endl;  // check empty value

    // 18. pop_back
    v.pop_back();

    // 19. swap
    vector<int> a{1, 2, 3};
    vector<int> b{4, 5, 6};
    a.swap(b);  // swap two different vector
    print(a);
    print(b);

    auto a1 = next(a.begin());

    print(v);
    return 0;
}