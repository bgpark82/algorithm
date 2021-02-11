#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{

    return 0;
}

vector<int> multiply(const vector<int> &a, const vector<int> &b)
{
    vector<int> c(a.size() + b.size() + 1, 0);
    for (int i = 0; i < a.size(); i++)
    {
        for (int j = 0; j < b.size(); j++)
        {
            c[i + j] += a[i] * b[j];
        }
    }
    return c;
}

void normalize(vector<int> &num)
{
    num.push_back(0);
}