#include <iostream>
#include <vector>
#include <algorithm>
#include <chrono>

using namespace std;
using namespace chrono;

int main(void)
{

    // 그냥 시간이 짧은 순서대로 정렬하면 될 거 같은데??
    int n = 0, count = 0, sum = 0;
    scanf("%d", &n);

    vector<int> v(n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &v[i]);
    }

    sort(v.begin(), v.end());
    for (int i = 0; i < n; i++)
    {
        sum += v[i];
        count += sum;
    }

    printf("%d", count);

    return 0;

    /**
     * 지금까지 느낀 greedy 알고리즘은 
     * linear한 배열에 sort만 잘해도 통과할 수 있는 것 같다
     */
};