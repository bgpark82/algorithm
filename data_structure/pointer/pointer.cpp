#include <iostream>
#include <vector>

using namespace std;

// 파라미터 '정의' 부분
// 여기서 *은 '정의'할 떄의 포인터
void swap(int *a, int *b) {
    int temp;

    temp = *a;
    *a = *b;
    *b = temp;
}

int main(void) {
    int a = 5;
    int b = 1;
    int* ptr;
    ptr = &a;

    char arr[6] = "hello";
    char* cptr = &arr[1] + 3;

    cout << sizeof(a) << endl;  // a 타입의 크기
    cout << sizeof(ptr) << endl; // a 주소의 크기 (ptr로 할당된) = 메모리 주소 사이즈 (기본 8바이트)
    cout << sizeof(&a) << endl; // a 주소의 크기 = 메모리 주소 사이즈 (기본 8바이트)
    cout << ptr << endl; // a의 주소
    cout << &a << endl; // a의 주소
    cout << *ptr << endl; // a의 주소의 값
    cout << *&a << endl; // a의 주소의 값

    swap(&a, &b);

    cout << a << " : " << b << endl;

    cout << *cptr << endl;



    return 0;
};