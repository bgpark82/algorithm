#include <iostream>
#include <vector>

using namespace std;

void print(pair<int, int> &obj)
{
    cout << "first: " << obj.first << " second : " << obj.second << endl;
}

/**
 * pari<T1, T2> obj;
 * 
 * enable to combine two difference data type into one struct
 * map, mulltimap, unorder map, unroder multimap 을 만들 수 있다
 * 
 */
int main(void)
{
    {
        pair<int, int> obj(10, 20);
        print(obj);
    }
    {
        pair<int, int> obj1 = make_pair(30, 40);
        print(obj1);
    }

    vector<pair<string, int> > list;
    list.push_back(make_pair("park", 1));
    list.push_back(make_pair("byeong", 1));
    list.push_back(pair<string, int>("gil", 3));

    for (int i = 0; i < list.size(); i++)
    {
        cout << list[i].first << " " << list[i].second << endl;
    }

    return 0;
};