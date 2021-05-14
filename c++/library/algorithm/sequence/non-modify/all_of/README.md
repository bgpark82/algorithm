# all_of

## Definition
- check if all elements meets condition

## Parameter
- first, last: iterators of first and last position
- include first, not include last
- pred: unary function (filter function)

## Return
- true: if condition meets
- false: if condition not meets

## Complexity
- `O(N)`

## Version
- above C++ 11

## Example
```
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool call_of(vector<int>::iterator first, vector<int>::iterator last, int (*func)(int)) { // function as argument: (return type) (*func)(argument type)
    while (first != last) {
        if (!func(*first)) {
            return false;
        }
        ++first;
    }
    return true;
}

int main(void) {
    // unary function
    vector<int> v{3, 5, 7, 9};
    if (all_of(v.begin(), v.end(), [](int i) { return i % 2; })) {
        cout << "odd" << endl;
    }

    // custom
    if (call_of(v.begin(), v.end(), [](int i) { return i % 2; })) {
        cout << "odd" << endl;
    }
    return 0;
};
```