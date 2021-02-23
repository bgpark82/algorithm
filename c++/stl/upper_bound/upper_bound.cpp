#include <iostream>
#include <algorithm>

using namespace std;

int _upper_bound(int arr[], int size, int key)
{
    int left = 0;
    int right = size - 1;
    int mid = 0;
    while (left < right)
    {
        mid = (left + right) / 2;
        if (arr[mid] <= key)
        {
            left = mid + 1;
        }
        else
        {
            right = mid;
        }
    }
    return mid + 1;
}

int main(void)
{

    int arr[10] = {1, 2, 3, 4, 5, 6, 6, 7, 7, 7};

    // binary search 이후 찾은 key의 인덱스값 반환
    cout << _upper_bound(arr, 10, 6) << endl;
    cout << *upper_bound(arr, arr + 10, 6) << endl;


    return 0;
};