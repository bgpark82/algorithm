#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void change(vector<int> &a, int index)
{
    for (int i = index - 1; i <= index + 1; i++)
    {
        if (i >= 0 && i <= a.size() - 1)
        {
            a[i] = 1 - a[i];
        }
    }
}

// TODO: 매개변수를 그냥 받으면 새로운 값 생성
// TODO: 매개변수를 &로 받으면 힙의 객체를 참조,
pair<bool, int> check(vector<int> origin, vector<int> &goal)
{
    int count = 0;
    for (int i = 0; i < origin.size() - 1; i++)
    {
        if (origin[i] != goal[i])
        {
            change(origin, i + 1);
            count++;
        }
    }
    if (origin == goal)
    {
        return make_pair(true, count);
    }
    else
    {
        return make_pair(false, count);
    }
}

/**
 * 이 문제의 핵심은 두개의 행렬을 비교했을 때 특정 인덱스의 값을 두번 바꿀 수 있다는 것이다.
 * 예를들어 a,b 벡터의 0번 인덱스가 같아도 1번 인덱스에서 0번 인덱스의 값을 바꿀 수 있다.
 * 그러므로 일관성이 떨어진다
 * 이는 0번 인덱스의 값을 정해놓으면 다음 인덱스에서 스위치를 눌리면 인덱스 0번의 값은 변하지 않기 때문에 
 * 벡터의 끝까지 가도 한번씩만 바꿀 수 있다는 것이다.
 */
int main(void)
{

    int n = 0, countA = 0, countB = 0, isA = false, isB = false;
    scanf("%d", &n);

    vector<int> a(n);
    vector<int> b(n);

    for (int i = 0; i < n; i++)
    {
        scanf("%1d", &a[i]);
    }
    for (int i = 0; i < n; i++)
    {
        scanf("%1d", &b[i]);
    }

    // 켜지 않은 경우
    pair<bool, int> p = check(a, b);

    change(a, 0);

    pair<bool, int> p1 = check(a, b);

    if (p.first && !p1.first)
    {
        cout << p.second << endl;
    }
    if (!p.first && p1.first)
    {
        cout << p1.second + 1 << endl;
    }
    if (p.first && p1.first)
    {
        cout << min(p.second, p1.second + 1) << endl;
    }
    if (!p.first && !p1.first)
    {
        cout << -1 << endl;
    }

    // 켠 경우

    return 0;
};