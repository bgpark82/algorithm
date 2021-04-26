# Min

## Definition
- Return the smaller value of a and b

## Parameter
- a, b : the values to compare
- cmp : comparison function  
  - `true` : a < b 
  - `false` : a > b
  - `bool cmp(T &a, T &b);`

## Return value
- The smaller of a and b

## Complexity
- two values : `O(1)`
- initializer list : `O(n)`

## Examples
```
#include <algorithm>
#include <initializer_list>
#include <iostream>
#include <vector>

using namespace std;

// define binary function
bool comp(int a, int b) {
    return a < b;  // true
}

int comp2(int a, int b) { return (a < b) ? a : b; }

int comp3(int a, int b) { return (comp(a, b) ? a : b); }

int main(void) {
    // number
    cout << min(1, 1) << endl;
    cout << min(1, 2) << endl;
    cout << min(2, 1) << endl;
    cout << min('a', 'z') << endl;
    cout << min(3.15, 2.32) << endl;

    // compare
    cout << min(5, 6, comp) << endl;
    cout << min(6, 6, comp) << endl;

    // initializer list
    cout << min({1, 2, 3, 4, 5}) << endl;
    cout << min({1, 2, 3, 4, 5}, comp) << endl;
    cout << min({1, 2, 3, 4, 5}, comp2) << endl;
    cout << min({1, 2, 3, 4, 5}, comp3) << endl;

    return 0;
};
```