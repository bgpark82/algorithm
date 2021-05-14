# find_if

## Definition
- find an iterator to the first element which pred return true;
- if no element match, then return last

## Parameter
- first, last: input iterator
- pred: unary function

## Return
- return iterator to the first element which pred return true
- if pred is false, then return last

## Complexity
- `O(N)`

## Version
- above C++

## Example
```
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

vector<int>::iterator cfind_if(vector<int>::iterator  first, vector<int>::iterator last, bool (*pred)(int)) {
    while (first != last) {
        if (pred(*first)) {
            return first;
        }
        ++first;
    }
    return last;
}

int main(void) {
    vector<int> foo{1, 2, 3, 4, 5};

    cout << *find_if(foo.begin(), foo.end(), [](int i) { return i % 2 == 0; }) << endl;

    return 0;
};
```