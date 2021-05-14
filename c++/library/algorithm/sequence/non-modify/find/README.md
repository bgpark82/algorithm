# find

## Definition
- find an iterator to the first element in the range that equal to val
- if not found, then return last iterator
  
## Parameter
- first, last: input iterator
- val: value to search
  
## Return
- iterator to the first element found
- if no element match, then return last
  
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

int *cfind(int *first, int *last, int val) {
    while (first != last) {
        if (*first == val) {
            return first;
        }
        ++first;
    }
    return last;
}

int main(void) {
    int foo[] = {6, 4, 3, 7, 2, 5};
    cout << *find(foo, foo + 5, 2) << endl;
    cout << *cfind(foo, foo + 5, 6) << endl;
    for_each(find(foo, foo + 6, 4), find(foo, foo + 6, 5), [](int i) { cout << i << endl; });

    return 0;
};
```