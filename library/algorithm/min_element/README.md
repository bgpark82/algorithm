# min_element

## Definition
- Find the smallest value in the range [first , last)


## Parameter
- first, last: forward iterator defining the range
- comp : comparision binary function

## Return Value
- Iterator to the smallest in the range
- equivalent : iterator to the first such element
- empty range : last in the range

## Complexity
- `O(N)`

## Version
- since C++ 17


## Example
```
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool comp(int a, int b) { return a < b; }

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
    cout << distance(i1, i.end());

    return 0;
};
```