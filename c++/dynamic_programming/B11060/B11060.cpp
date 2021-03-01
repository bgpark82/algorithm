#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{

    /**
    * 1. 출력하기 좋은 형태로 만드는 것이 좋겠다
    * 2. 코드가 실패한다면 꼭 디버깅을 해라
    * 3. DP는 정답을 구하는 배열하나만 있어도 된다
    */
    int n;
    cin >> n;

    vector<int> a(n);
    fill(a.begin(), a.end(), 1000000);

    a[0] = 0;
    for (int i = 0; i < n; i++)
    {
        int s;
        cin >> s;
        for (int j = 1; j <= s; j++)
        {
            if (i + j < n)
            {
                a[i + j] = min(a[i] + 1, a[i + j]);
            }
        }
    }

    if (a[n - 1] == 1000000)
    {
        cout << -1 << endl;
    }
    else
    {
        cout << a[n - 1] << endl;
    }

    return 0;
};