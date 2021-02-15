#include <iostream>

using namespace std;

int main(void)
{

    // 001과 011을 비교하여 001의 결과를 얻는다 = 1의 자리가 유효/체크/뒤집어 졌는지 확인
    cout << ((1 << 0) & 3) << endl;
    cout << ((1 << 1) & 3) << endl;

    return 0;
};