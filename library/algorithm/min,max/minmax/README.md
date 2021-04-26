# minmax

## Definition
- Return `pair` of the smaller and the greater of a and b
- Return `pair` of the smallest and the greatest of the elements in initializer list

## Parameter
- a, b: The values to compare
- initializer list: initializer list to compare
- comp: comparison binary function
 
## Return values
- `pair<int,int>(a, b)`: a <= b
- `pair<int,int>(b, a)`: b < a
- `pair<int,int>(a, b)`
  - a : **the smallest** or **left most if it is equivalent to the smallest** in the initializer list
  - b : **the greatest** or **right most if it is equivalent to the greatest** in the initializer list

## Complexity
- a, b: `O(1)`
- initializer list: `O(n*3/2)`

## Examples
```cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool comp(int a, int b) { return (a < b); }

void print(int a, int b) { cout << "min: " << a << ", max:" << b << endl; }

int main(void) {
    // number
    pair<int, int> p = minmax(1, 2);
    print(p.first, p.second);

    // comparision
    pair<int, int> c = minmax(1, 2, comp);
    print(c.first, c.second);

    // initializer list
    pair<int, int> l = minmax({1, 2, 3, 4, 5});
    print(l.first, l.second);

    return 0;
};
```