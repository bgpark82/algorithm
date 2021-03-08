#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int mod = 127;
int base = 256;

int h(string s)
{
    int ans = 0;
    for (int i = 0; i < s.length(); i++)
    {
        int a = s[i];
        ans = (ans * base + a) % mod;
        // a = 97 : (0 * 256 + 97) / 127
        cout << ans << endl;
    }
    return 0;
};

int match(string &a, string &b)
{
    int n = a.length();
    int m = b.length();
    if (n < m)
        return 0;

    int hash_p = h(b);
    return 0;
};

int main(void)
{

    /**
   * 부분 문자열: 문자열의 연속된 일부
   * 한글자 이상
   * 1,000,000
   */
    string a, b;
    cin >> a >> b;
    cout << match(a, b) << endl;

    return 0;
};