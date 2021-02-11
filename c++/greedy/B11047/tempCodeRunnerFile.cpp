#include <iostream>

using namespace std;

int main(void)
{
    // 1<< N << 10
    // 1<< k << 100,000,000
    // 1<< A << 1,000,000
    // 배수
    int n, k, count;

    cin >> n >> k;

    int arr[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    sort(arr, arr + n, greater<int>());

    for (int i = 0; i < n; i++)
    {
        if (arr[i] < k)
        {
            int temp = k / arr[i];
            k = k % (temp * arr[i]);
            count = count + temp;
        }
    }
    cout << count << endl;

    return 0;
}