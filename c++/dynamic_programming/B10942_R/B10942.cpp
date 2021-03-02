#include <iostream>
#include <vector>

using namespace std;

int main(void)
{

    /**
   * 자연수 n개를 적는다 (1 <= n <= 2000)
   * 질문을 총 m번한다 (1 <= m < 1,000,000)
   * 각 질문은 두 정수 S와 E (1 <= S <= E <= n)
   * S번쨰 수부터 E번쨰 수까지 팰린드롬
   */

    int n, m;
    cin >> n;

    vector<int> v(n);
    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
    }

    cin >> m;
    vector<int> a(m);
    // 1,000,000
    for (int i = 0; i < m; i++)
    {
        int left, right;
        cin >> left >> right;
        int start = left - 1;
        int end = right - 1;

        bool check = true;
        // 2,000
        while (start <= end)
        {
            // 펠린드롬
            if (v[start] == v[end])
            {
                
                start += 1;
                end -= 1;
            }
            else
            {
                check = false;
                break;
            }
        }
        if (check)
        {
            a[i] = 1;
        }
        else
        {
            a[i] = 0;
        }
    }

    for (int i = 0; i < m; i++)
    {
        cout << a[i] << endl;
    }

    return 0;
};