#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

int main(void)
{

    /**
     * N+1일 최사
     * N일 동안 많은 상담
     * 하루에 하나씩 서로 다른 사람의 상담
     * 상담을 완료하는데 T기간일 경우 금액은 P
     * 최대수익
     * 
     * 다이나믹 프로그래밍
     * 1. 기존의 배열에 인수 입력
     * 2. 새로운 배열을 생성
     * 3. 다이나믹 프로그래밍은 언제든지 되돌아 갈 수 있으므로 기억할 수 있는 공간에 저장하자
     */
    int n;
    cin >> n;

    vector<pair<int, int> > v;
    for (int i = 0; i < n; i++)
    {
        int first, second;
        cin >> first >> second;
        v.push_back(make_pair(first, second));
    };

    vector<int> a(n + 1);

    for (int i = 0; i < n; i++)
    {
        int day = v[i].first;
        int money = v[i].second;

        if (money + a[i] > a[i + day] && i + day < n)
        {
            a[i + day] = money + a[i];
        }
    }

    cout << *max_element(a.begin(), a.end()) << endl;

    return 0;
};