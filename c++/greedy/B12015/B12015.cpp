#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{

    /**
 * 가장 긴 증가하는 부분 수열
 * 증가와 부분이 핵심인듯
 * 수열은 크기는 1~1,000,000
 * 인자의 크기는 1~1,000,000
 * 10, 20, 30,
 */

    int n = 0;
    cin >> n;
    vector<int> v;
    for (int i = 0; i < n; i++)
    {
        int num;
        cin >> num;
        // lower_bound에 해당하는 값 위치를 반환
        vector<int>::iterator iter = lower_bound(v.begin(), v.end(), num);
        // 아무것도 없거나 num이 vector의 특정값보다 클 때
        if (iter == v.end())
        {
            v.push_back(num);
        }
        // num이 vector의 특정값보다 작거나 같을 때, num보다 바로 위의 숫자를 num으로 바꾼다. 그렇게 연속된 숫자의 차이를 줄여준다
        else
        {
            *iter = num;
        }
    }

    cout << v.size() << endl;

    return 0;
};