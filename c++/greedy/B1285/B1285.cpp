#include <stdio.h>
#include <iostream>
#define MIN(a, b) ((a) < (b) ? (a) : (b))

const int MAX_SIZE = 20;
using namespace std;

int N;
char map[MAX_SIZE][MAX_SIZE];

/**
 * 브루트 포스 + 그리디
 * 
 */ 
int main(void)
{
    int ans = 2100000000;

    scanf("%d", &N);

    for (int i = 0; i < N; i++)
    {
        for (int col = 0; col < N; col++)
        {
            while (true)
            {
                scanf("%c", &map[i][col]);

                if (map[i][col] != '\n')
                    break;
            }
        }
    }

    /** 
     * k < (1 << N)
     * 행에 대한 모든 경우의 수를 구한다
     * k = 0 : 000 : 모두 안뒤집는 경우
     * k = 1 : 001 : 1행만 뒤집음
     * k = 2 : 010 : 2행만 뒤집음
     * k = 3 : 011 : 1,2행만 뒤집음
     * k = 4 : 100 : 3행만 뒤집음
     * k = 5 : 101 : 1,3행만 뒤집음
     * k = 6 : 110 : 2,3행만 뒤집음
     * k = 7 : 111 : 1,2,3행 모두 뒤집음
     */
    for (int k = 0; k < (1 << N); k++) // 각 행에 대해서 뒤집을지?
    {
        int sum = 0;
        for (int col = 0; col < N; col++) // 열
        {
            int nowT = 0;
            for (int row = 0; row < N; row++) // 행
            {
                char now = map[row][col];

                /**
                 * 1 << i
                 * 한 열에서 하나씩 뒤집었을 때의 경우의 수
                 * 1 << 0 : 001 : 3열만 뒤집는다
                 * 1 << 1 : 010 : 2열만 뒤집는다
                 * 1 << 2 : 100 : 1열만 뒤집는다
                 * 
                 * k & (1 << i)
                 * 앞에서 구한 k의 경우가 맞는지 검사한다
                 * 예를들어
                 * k = 3 : 011이고 1 << 0 : 001이면 
                 * k로 부터 2행 3행을 뒤집을지 정해졌다
                 * i로 부터 3행을 뒤집는 것으로 정해졌으므로
                 * 해당 조건으로 3행 3열을 뒤집는다
                 */
                if ((1 << row) & k)
                {
                    cout << "k: " << k << ", (1<<i)&k: " << ((1 << row) & k) << ", 열: " << col << ", 행: " << i << endl;

                    if (now == 'T')
                        now = 'H';
                    else
                        now = 'T';
                }

                if (now == 'T')
                    nowT++;
            }

            // 이 열을 뒤집는게 이득인지
            sum += MIN(nowT, N - nowT);
        }

        ans = MIN(ans, sum);
    }

    printf("%d\n", ans);

    return 0;
}