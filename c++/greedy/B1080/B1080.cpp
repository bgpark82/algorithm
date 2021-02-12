#include <iostream>
#include <vector>
#include <chrono>

using namespace std;
using namespace chrono;

// TODO: N과 M은 50보다 작은 자연수이므로 전역변수로 먼저 선언해놓는다
int a[50][50]; // 50*50*2 = 5000 = 5mb
int b[50][50];

void flip(int row, int column)
{
    for (int i = row; i < row + 3; i++)
    {
        for (int j = column; j < column + 3; j++)
        {
            a[i][j] = 1 - a[i][j];
        }
    };
}

int main(void)
{

    int n = 0, m = 0, count = 0;
    scanf("%d %d", &n, &m);
    // 2차원 벡터

    // TODO: scanf는 한자씩 가져올 수 있다 (대신 %1d로 한자리라는 것을 명시)
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%1d", &a[i][j]);
        }
    };
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%1d", &b[i][j]);
        }
    };

    for (int i = 0; i < n - 2; i++)
    {
        for (int j = 0; j < m - 2; j++)
        {
            if (a[i][j] != b[i][j])
            {
                flip(i, j);
                count++;
            }
        }
    };

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (a[i][j] != b[i][j])
            {
                printf("%d", -1);
                return 0;
            }
        }
    };

    printf("%d", count);

    return 0;
};