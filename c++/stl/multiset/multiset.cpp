#include <iostream>
#include <set>

using namespace std;

class Person
{
public:
    float age;
    string name;
};

int main(void)
{
    // 오름차순 정렬 (기본 오름차순)
    multiset<int, less<int> > n;
    // 내림차순 정렬
    multiset<int, greater<int> > m;
    m.insert(10);
    m.insert(20);
    m.insert(30);
    m.insert(10);
    m.insert(20);

    multiset<int>::iterator iter;
    for (iter = m.begin(); iter != m.end(); iter++)
    {
        cout << *iter << endl;
    }

    return 0;
};