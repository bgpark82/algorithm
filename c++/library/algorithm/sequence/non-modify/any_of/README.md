# any_of

## Definition
- check any of element in range has the target value

## Parameter
- first, last: input iterators from initial to final in a sequence
- pred: Unary function that accept an element in the range, return true if value exist

## Return
- true: if pred return true for any of elements in range exist
- false: if pred return false for any of elements in range not exist or empty range
  
## Complexity
- `O(N)`


## Version
- above C++ 11

## Example
```
#include <algorithm>
#include <array>
#include <iostream>
#include <vector>

using namespace std;

bool cany_of(vector<int>::iterator first, vector<int>::iterator last, bool (*func)(int i)) {
    while (first != last) {
        if (func(*first)) {
            return true;
        }
        ++first;
    }
    return false;
}

bool pred(int i) {
    return i < 0;
}

int main(void) {
    vector<int> foo = {0, 1, -1, 3, -3, 5, -5};
    cout << any_of(foo.begin(), foo.end(), pred) << endl;
    cout << any_of(foo.begin(), foo.end( ), [](int i) { return i > 0; }) << endl;
    cout << cany_of(foo.begin(), foo.end(), pred) << endl;

    return 0;
};
```