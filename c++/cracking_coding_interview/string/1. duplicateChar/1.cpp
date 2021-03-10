#include <iostream>
#include <algorithm>

using namespace std;
bool arr[128];

bool answer(string s)
{
    // index out of bound check
    if (s.length() > 128)
    {
        return false;
    }
    for (int i = 0; i < s.length(); i++)
    {
        int index = int(s[i]);
        if (arr[index])
        {
            return false;
        }
        arr[index] = true;
    }
    return true;
}
bool answer2(string s)
{
    // 1, 11, 111, 1111, .... 
    int check = 0;
    for (int i = 0; i < s.length(); i++)
    {
        int index = int(s[i]) - 'a';
        
        // check each digits : 111 & 1, 111 & 10, 111 & 100
        if (check & ((1<<index) > 0))
        {
            return false;
        }
        // mark each digits
        check = check | (1 << index);
    }
    return true;
}

int main(void)
{
    // 모든 문자가 unique한지 자료구조없이 찾아봐라
    string s = "abcde";
    bool ans = answer2(s);

    if (ans)
    {
        cout << "유니크한 값" << endl;
    }
    else
    {
        cout << "유니크하지 않은 값" << endl;
    }

    return 0;
};