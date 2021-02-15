#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main(void)
{

    // char arr[5][5];
    vector<string> arr(5);

    // for (int i = 0; i < 5; i++)
    // {
    //     for (int j = 0; j < 5; j++)
    //     {
    //         // line breaker 읽어오네
    //         scanf("%c", &arr[i][j]);
    //     }
    // }

    // TODO : cin과 scanf의 차이점
    for (int i = 0; i < 5; i++)
    {
        cin >> arr[i];
    }

    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            printf("%c ", arr[i][j]);
        }
    }

    return 0;
};