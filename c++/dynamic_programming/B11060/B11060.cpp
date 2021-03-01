#include <iostream>
#include <vector>

using namespace std;

int main(void)
{

    /**
   * 1 2 4 5 6 8  = 1 x N
   * 각 칸에는 정수 
   * An 이하 만큼 오른쪽으로 떨어진 칸으로 한번에 점프 가능
   * 미로의 가장 왼쪽 끝에서 가장 오른쪽 끝으로
   * 최소 몇번 점프로 갈 수 있는가
   * 못가는 경우 -1
   * 
   * 자고로 최소값이라면
   * 1. 방문 한번도 안했을 때는 방문해줘야지
   * 2. 방문 한번 했으면 조건에 맞을 때만 방문해줘야지
   */
    int n;
    cin >> n;

    vector<int> v(n);
    vector<int> a(n);
    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
        a[i] = 1000000;
    }
    // 시작점은 무조건 1번은 들어간다
    a[0] = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j <= v[i]; j++)
        {
            // 만약 v[i]가 3인 경우 j는 1,2,3만큼 이동한다
            // i에서 v[i]만큼 이동
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