#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main(void)
{

/**
 * 대학 : 0 <= n개 <= 10000
 * 날짜 : 1 <= d일내 <= 10000
 * 강연료 : 1 <= p원 <= 10000
 * 가장많이 버는 강연
 * 하루에 최대 한곳
 * 
 * p : 50 10 20 30
 * d : 2  1  2  1
 */
    int n = 0;
    scanf("%d", &n);

    multimap<int, int> m;

    for (int i = 0; i < n; i++)
    {
        int d = 0, p = 0;
        scanf("%d %d", &p, &d);
        m.insert(pair<int, int>(d, p));
    };

    int sum = 0;
    int count[10000];
    multimap<int, int>::iterator iter;

    for (iter = m.begin(); iter != m.end(); iter++)
    {
        if (count[iter->first] == 0)
        {
            count[iter->first] = iter->second;
            sum += iter->second;
        }
    }

    cout << sum << endl;

    return 0;
};