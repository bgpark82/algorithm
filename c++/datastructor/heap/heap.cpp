#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
    cout << __cplusplus << endl;

    vector<int> v = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    /**
     *          9
    *         /   \
    *       8      7                                               
    *     /   \     
    *   15    20
    */
    make_heap(v.begin(), v.end());

    for (int i : v)
    {
        cout << i << endl;
    }

    return 0;
};