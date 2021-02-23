#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
  string s;
  cin >> s;

  int sum = 0;
  for (char c : s)
  {
    // char를 숫자로 만들 떄!!
    sum += c - '0';
  }

  // 오름차순 정렬
  sort(s.begin(), s.end(), greater<int>());

  // 모든자리 숫자값을 더한 값이 3으로 나눠 떨어지면 3의 배수
  if (s[s.size() - 1] == '0' && sum % 3 == 0)
  {
    cout << s;
  }
  else
  {
    cout << -1;
  }

  return 0;
};