#include <iostream>
#include <vector>

using namespace std;

const int MAX = 20;
vector<string> arr(MAX);

int main(void)
{
    int n = 0;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    int answer = n * n;
    for (int x = 0; x < (1 << n); x++)
    {
        int sum = 0;
        for (int col = 0; col < n; col++)
        {
            int count = 0;
            for (int row = 0; row < n; row++)
            {
                char letter = arr[row][col];
                // 정해진 열의 x와 같은 뒤집는 조건의 행을 뒤집는다
                // x : 100
                // 1<<0 :
                if (x & (1 << row))
                {
                    if (letter == 'T')
                    {
                        letter = 'H';
                    }
                    else
                    {
                        letter = 'T';
                    }
                }
                if (letter == 'T')
                {
                    count++;
                }
            }
            sum += min(count, n - count);
        }
        answer = min(answer, sum);
    }

    printf("%d", answer);

    return 0;
};