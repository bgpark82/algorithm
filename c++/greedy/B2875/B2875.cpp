#include <iostream>

using namespace std;

int main(void)
{

    /**
 * 여 2, 남 1
 * N 여, M 남
 * K명 인턴십 참석
 * 인턴십 참여하면 대회 못감
 * 최대의 팀 수
 * 
 * 여2, 남1 해서 남은 값이 인원 수보다 
 */
    int n, m, k;
    cin >> n >> m >> k;
    int count = 0;
    for (int i = 0; i < 100; i++)
    {
        if (n - 2 >= 0 && m - 1 >= 0)
        {
            n = n - 2;
            m = m - 1;
            if (n + m >= k)
            {
                count++;
            };
        }
    }
    cout << count << endl;

    return 0;
};