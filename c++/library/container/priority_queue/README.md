# priority_queue

## Difinition
- queue which store element in descending order

## Example
```
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main(void) {
    // index: desc sort
    priority_queue<int> pq;

    pq.push(1);
    pq.push(2);
    pq.push(3);

    while (!pq.empty()) {
        cout << pq.size();
        cout << pq.top() << endl;
        pq.pop();
    }

    return 0;
};
```