# binary_search

## Definition
- Check the given element is within the range
- It has to be in order

## Parameter
- first, last: the range of elements
- value: value to find in the range
- comp: comparison binary function

## Return
- true: if value found
- false: if value not found
  
## Complexity
- `O(log2(N))`

## Version
- since C++ 20
## Exmaple
```
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
```
