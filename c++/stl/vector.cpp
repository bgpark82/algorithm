#include <iostream>
#include <vector>

using namespace std;
/**
 * 
 * https://www.cplusplus.com/reference/vector/vector/
 * 
 * sequence container
 * List in java = enable to change its size, size handle by container
 * it grows the size when it needs to allocate more elements
 * allocate new array and move all elements into
 * but do not allocate each time
 * so they prepare extra space for storage for the future
 * constant time complexity anyway
 * less heavier than array, but more efficient
 * 
 * container
 * holding the colletion object
 * properties 
 * 1. sequence : linear order
 * 2. dynamic array : enable to change size dynamically (fast addition, removal)
 * 3. allocator aware : 
 * 
 * template
 * - Generic in Java
 */
void printl(vector<int> a)
{
    for (int i = 0; i < a.size(); i++)
    {
        cout << a[i] << " ";
    }
    cout << endl;
}
void prints(int a)
{
    cout << a << endl;
}

int main(void)
{
    vector<int> a;
    vector<int> b(3);    // size : 3, element : 0
    vector<int> c(3, 2); // size : 3, element : 2
    vector<int> d(c);    // size : 3, element : 2

    d.assign(5, 2);
    prints(d.at(0));
    prints(d[1]);
    prints(d.front());
    prints(d.back());
    d.clear();
    d.push_back(5);
    d.pop_back();
    // iterator
    d.begin();
    d.end();
    d.rbegin();
    d.rend();
    // d.reserve(10);
    d.resize(10, 3);
    prints(sizeof(d));    // size of memory:
    prints(d.size());     // length of vector
    prints(d.capacity()); // length of vector
    b.swap(d);            // swap b and d, to remove capacity of d vector
    //d.insert(1, 2);

    printl(b);
    printl(d);

    // size vs capacity
    vector<int> h;
    for (int i = 0; i < 50; i++)
    {
        h.push_back(i);
        cout << h[i] << ":" << h.size() << ":" << h.capacity() << endl;
    }

    return 0;
};