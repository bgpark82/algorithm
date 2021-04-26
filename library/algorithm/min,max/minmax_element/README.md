# minmax_element

## Definition
- Find the smallest and the greatest element in the range
    - elements are compared using operator `<`
    - elements are compared using given binary comparison function 

## Parameter
- first, last: forward iterator 
- cmp: comparison binary function

## Return 
- a `pair` consisting of forward iterator to the smallest element and the greatest element
- empty range: `make_pair(first,first)`
- equivalent
  - smallest : the forward iterator to the first such element 
  - greatest : the forward iterator to the last such element

## Complex
- `O(N)`  

## Version
- above C++ 11

## Example
```
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    // regular
    vector<int> p{6, 3, 1, 2, 4, 8};
    pair<vector<int>::iterator, vector<int>::iterator> p1 =
        minmax_element(p.begin(), p.end());
    cout << *p1.first << *p1.second << endl;
    cout << distance(p.begin(), p1.first) << endl;
    cout << distance(p.begin(), p1.second) << endl;

    // simple
    vector<int> s{6, 3, 2, 1, 5};
    auto [min, max] = minmax_element(s.begin(), s.end());
    cout << *min << *max << endl;

    return 0;
};
```