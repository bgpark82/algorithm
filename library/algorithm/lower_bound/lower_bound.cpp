#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

vector<int>::iterator clower_bound(vector<int>::iterator first, vector<int>::iterator last, int target) {
    vector<int>::iterator left, right;
    int dist, mid;
    dist = distance(first, last);

    while (dist > 0) {
        left = first;
        mid = dist / 2;
        advance(left, mid);
        if (*left < target) {
            first = ++left;
            dist -= mid - 1;
        } else {
            dist = mid;
        }
    }

    return first;
}

struct Item {
    int price;
};

int main(void) {
    // vector
    vector<int> v{1, 2, 4, 5, 5, 6};
    for (int i = 0; i < 8; i++) {
        // greater or equal to value
        vector<int>::iterator lower = lower_bound(v.begin(), v.end(), i);
        cout << i << " <= " << *lower << " index " << distance(v.begin(), lower) << endl;
    }

    // struct
    vector<Item> items{{101}, {101}, {102}, {102}, {105}};
    for (int target : {100, 104}) {
        auto p = lower_bound(items.begin(), items.end(), target, [](Item& item, int value) { return item.price < value; });
        cout << target << " <= " << p->price << " index " << distance(items.begin(), p) << endl;
    }

    // custom
    vector<int> c{1, 2, 4, 5, 5, 6};
    for (int i = 0; i < 8; i++) {
        // greater or equal to value41
        vector<int>::iterator lower = clower_bound(v.begin(), v.end(), i);
        cout << i << " <= " << *lower << " index " << distance(v.begin(), lower) << endl;
    }

    return 0;
};