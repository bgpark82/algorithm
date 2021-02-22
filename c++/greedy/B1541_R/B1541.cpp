#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

vector<string> v;

void split(string line, char delimiter)
{

    stringstream ss(line);
    string temp;

    while (getline(ss, temp, delimiter))
    {
        v.push_back(temp);
    }
}

int splitSum(string line, char delimiter)
{
    stringstream ss(line);
    string temp;

    int sum = 0;
    while (getline(ss, temp, delimiter))
    {
        sum += stoi(temp);
    }
    return sum;
}

int main(void)
{

    /**
     * 양수, +, -, ()
     * 괄호로 최소값 만들기
     * 숫자 : 0에서 5자리
     * 전체 길이는 <= 50 
     * 
     * 음수일때네??
     * 40 - 50 - 30 - 20 + 10 + 10 - 40
     * 다음 음수가 나오기 전까지 기록했다가 괄호를 묶는다
     */

    string line;
    getline(cin, line);

    split(line, '-');
    
    int sum = stoi(v[0]);

    for (int i = 1; i < v.size(); i++)
    {
        sum -= splitSum(v[i], '+');
    }

    cout << sum << endl;

    return 0;
};