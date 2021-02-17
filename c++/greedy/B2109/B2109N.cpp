#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct Lecture
{
    int p;
    int d;
};

bool compare(Lecture &a, Lecture &b)
{
    // 내림차순 정렬
    return a.d > b.d;
}

int main(void)
{
    int n;
    cin >> n;

    vector<Lecture> v(n);
    for (int i = 0; i < n; i++)
    {
        cin >> v[i].p >> v[i].d;
    }

    // 벡터를 날짜의 내림차순으로 정렬한다
    sort(v.begin(), v.end(), compare);

    int k = 0, ans = 0;
    priority_queue<int> q;
    for (int i = 10000; i >= 1; i--)
    {
        // 해당 날짜에 해당하는 모든 Lecture를 priority queue에 넣는다
        // k는 vector의 다음 인덱스를 계속 가르킨다
        while (k < n && v[k].d == i)
        {
            q.push(v[k].p);
            k += 1;
        }
        // 해당 날짜의 priority queue의 가장 큰거 하나만 출력하고 loop끝낸다
        if (!q.empty())
        {            
            ans += q.top();
            q.pop();
        }
    }

    cout << ans << endl;

    return 0;
};