#include <iostream>
#include <vector>

using namespace std;

int main(void)
{

    /**
   * 1,2,3의 합의 종류
   * 순서만 다른 것은 같은 것으로
   * n을 1,2,3의 합으로 나타내는 방법의 수
   */

    int n;
    cin >> n;
    vector<int> arr(n + 1);
    int a[n + 1];
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    for (int i = 4; i <= 10000; i++)
    {
        arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
    }

    for (int i = 0; i < n; i++)
    {
        cout << arr[a[i]] << endl;
    }

    return 0;
};