#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

struct Jewelry
{
    int weight;
    int value;
};

bool compare(Jewelry &u, Jewelry &v)
{
    // 가격을 내림차순
    return u.value > v.value;
}

int main(void)
{

    /**
     * 보석 N개
     * - 무게 M
     * - 가격 V
     * 
     * 가방 K개
     * - 무게 C
     * - 한 가방에 한개의 보석만 가능
     * 
     * 보석의 최대가격은?
     */

    // 1 <= N,K <= 30,000
    int n = 0, k = 0;
    cin >> n >> k;

    vector<Jewelry> jewelry(n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d %d", &jewelry[i].weight, &jewelry[i].value);
    }
    sort(jewelry.begin(), jewelry.end(), compare);

    multiset<int> bag;
    for (int i = 0; i < k; i++)
    {
        int t;
        scanf("%d", &t);
        // 오름차순 정렬
        bag.insert(t);
    }

    long long ans = 0;
    for (int i = 0; i < n; i++)
    {
        // cout << jewelry[i].weight << " : " << jewelry[i].value << endl;
        auto it = bag.lower_bound(jewelry[i].weight);
        if (it != bag.end())
        {
            ans += jewelry[i].value;
            bag.erase(it);
            // for (auto i = bag.begin(); i != bag.end(); i++)
            // {
            //     cout << *i << endl;
            // }
        }
    }

    printf("%lld", ans);

    // 두번 돌리면 시간초과된다
    // 한번에 하는 방법을 찾아야 한다
    // 2가 주어졌다면 조건은 1과 2가 된다
    // 1과 2중에서 가장 가치있는 값을 먼저 넣는다
    // 근데 for 돌리면 안되니까 다른 방법이 필요하다
    // 무조건 돌리면 시간초과

    return 0;
};