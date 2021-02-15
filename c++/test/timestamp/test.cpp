#include <iostream>
#include <vector>
#include <chrono>

using namespace std;
using namespace chrono;

int main(void)
{
    system_clock::time_point start = system_clock::now();

    for (int i = 0; i < 100000; i++)
    {
        // printf가 사알짝 더 빠르다
        printf("%d\n", i);
    };

    system_clock::time_point end = system_clock::now();
    printf("total : %.3fs", (float)(end - start).count() / 1000000);

    return 0;
};