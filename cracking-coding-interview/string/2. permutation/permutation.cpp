#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

bool isPermutation2(string origin, string target) {
    // the same size
    if (origin.length() != target.length())
    {
        return false;
    };

    int chars[128] = {0};
    for (int i = 0; i < origin.length(); i++)
    {
        chars[origin[i]]++;
    }
    for (int i = 0; i < origin.length(); i++)
    {
        chars[target[i]]--;
        if(chars[target[i]] < 0) {
            return false;
        }
    }
    return true; 
    
}

bool isPermutation(string origin, string target)
{
    sort(origin.begin(), origin.end());
    sort(target.begin(), target.end());

    // the same size
    if (origin.length() != target.length())
    {
        return false;
    };

    // the same character
    bool ans = origin == target;
    
    return ans;
};

int main(void)
{

    string origin = "abcde";
    string target = "edcba";

    bool ans = isPermutation2(origin, target);
    if (ans)
    {
        cout << "permutation" << endl;
    }
    else
    {
        cout << "not permutation" << endl;
    }

    return 0;
};