#include <iostream>

using namespace std;

int _lower_bound(int arr[], int size, int key)
{
  int start = 0;
  int end = size - 1;
  int mid = 0;

  while (end - start > 0)
  {
    mid = (start + end) / 2;
    if (arr[mid] < key)
    {
      start = mid + 1;
    }
    else
    {
      end = mid;
    }
  }
  return end;
};

int main(void)
{

  int arr[10] = {1, 2, 3, 4, 5, 6, 6, 7, 7, 7};

  // binary search 이후 찾은 key의 인덱스값 반환
  cout << _lower_bound(arr, 10, 6) << endl;
  cout << *lower_bound(arr, arr + 10, 6) << endl;
  return 0;
};