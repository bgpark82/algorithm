#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main(void) {
    queue<int> q;

    cout << q.empty() << endl;
    cout << q.size() << endl;

    q.push(1);
    q.push(2);
    q.push(3);

    cout << q.front() << endl;
    cout << q.back() << endl;
    q.pop();

    return 0;
};