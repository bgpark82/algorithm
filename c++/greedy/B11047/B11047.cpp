#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
    // 1<< N << 10
    // 1<< k << 100,000,000
    // 1<< A << 1,000,000
    // 배수
    int n = 0;
    int k = 0;
    int count = 0;

    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    for (int i = n - 1; i >= 0; i--)
    {
        count += k / a[i];
        k %= a[i];
    }
    cout << count << endl;

    return 0;
}