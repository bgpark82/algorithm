#include <iostream>
#include <algorithm>

using namespace std;

int _max_element(int arr[], int end)
{
    int start = 0;
    while(++start != end) {
        
    }
    
    cout << arr << endl;
    return 0;
}

int main(void)
{

    int arr[10] = {1, 7, 8, 4, 6, 8, 3, 2, 5, 2};

    cout << _max_element(arr, 10) << endl;
    cout << *max_element(arr, arr + 10) << endl;

    return 0;
};