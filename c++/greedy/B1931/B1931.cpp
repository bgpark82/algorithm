#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

// TODO: struct vs class
struct Meeting
{
    int start, end;
};

bool cmd(const Meeting &u, const Meeting &v)
{
    if (u.end == v.end)
    {
        return u.start < v.start;
    }
    else
    {
        return u.end < v.end;
    }
}

int main(void)
{
    // 1. vector에 Meeting 담기
    int n = 0;
    // TODO: scanf vs cin
    scanf("%d", &n);

    // 2. vector 정렬, 시작 -> 끝이 연속하도록

    // TODO: vector functions
    vector<Meeting> a(n);

    for (int i = 0; i < n; i++)
    {
        scanf("%d %d", &a[i].start, &a[i].end);
    }

    // TODO : sort
    sort(a.begin(), a.end(), cmd);

    // 3. 회의 시작 -> 끝 계속 이동
    int now = 0;
    int ans = 0;
    for (int i = 0; i < n; i++)
    {
        if (now <= a[i].start)
        {
            now = a[i].end;
            ans++;
        }
    }

    printf("%d", ans);

    // 순서 : 정렬 -> 출력
    // 정렬 기준 : 시작점과 끝점이 최대한 연속적으로 맞닿을 수 있도록
    // 출력 기준 : 끝점이 다음 시작점 보다 작을 때마다 출력

    return 0;
};