#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle)
{
    vector<vector<int>> a(triangle.size());
    for (int i = 0; i < triangle.size(); i++)
    {
        for (int j = 0; j < triangle[i].size(); j++)
        {
            a[i].push_back(-1);
        }
    }

    a[0][0] = triangle[0][0];
    for (int i = 0; i < triangle.size(); i++)
    {
        for (int j = 0; j < triangle[i].size(); j++)
        {
            if (i + 1 < triangle.size())
            {
                if (a[i + 1][j] < a[i][j] + triangle[i + 1][j])
                {
                    a[i + 1][j] = a[i][j] + triangle[i + 1][j];
                }
                if (j + 1 < triangle[i].size())
                {
                    if (a[i + 1][j + 1] < a[i][j] + triangle[i + 1][j + 1])
                    {
                        a[i + 1][j + 1] = a[i][j] + triangle[i + 1][j + 1];
                    }
                }
            }
        }
    }
    int max = *max_element(a[triangle.size() - 1].begin(), a[triangle.size() - 1].end());

    return max;
}

int main(void)
{
    vector<vector<int>> v = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
    solution(v);

    return 0;
};