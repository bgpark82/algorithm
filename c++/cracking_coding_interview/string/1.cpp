#include <iostream>
#include <algorithm>

using namespace std;

int main(void)
{

    // 모든 문자가 unique한지 자료구조없이 찾아봐라
    string a = "abcdae";
    bool check = true;
    int arr[128]; 
    fill(arr, arr + 128, 0);

    for (int i = 0; i < a.length(); i++)
    {
        for (int j = 0; j < 128; j++)
        {
            int index = int(a[i]);
            if (arr[index] == 0)
            {
                arr[index] = 1;
                break;
            }
            else
            {
                check = false;
                break;
            }
        }
    }

    if (check)
    {
        cout << "유니크한 값" << endl;
    }
    else
    {
        cout << "유니크하지 않은 값" << endl;
    }

    return 0;
};