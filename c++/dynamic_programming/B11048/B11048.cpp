#include <iostream>

using namespace std;

int a[1001][1001];
int d[1001][1001];

int max3(int x, int y, int z)
{
    return max(x, max(y, z));
};

// 큰 문제에서 아래 대각선으로 가면서 문제가 작아진다 = 다이나믹 프로그래밍
// D[i][j] = 1,1에서 시작해서 [i,j]에 도착하는 최대값
// [i,j]는 어딘가에서 왔을 것이다. [i-1, j], [i-1,j-1], [i,j-1]로 부터왔다
// 제일 마지막 부분에서 [0,0]으로 돌아가면 문제를 풀 수 있다
// i,j까지가는 최대의 경우 + a[i,j]
int main(int argc, char const *argv[])
{

    int y, x;
    cin >> y >> x;

    for (int i = 1; i <= y; i++)
    {
        for (int j = 1; j <= x; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }

    for (int i = 1; i <= y; i++)
    {
        for (int j = 1; j <= x; j++)
        {
            int z1 = d[i - 1][j];
            int z2 = d[i - 1][j - 1];
            int z3 = d[i][j - 1];
            d[i][j] = max3(z1, z2, z3) + a[i][j];
        }
    }
    cout << d[y][x];
    return 0;
}
