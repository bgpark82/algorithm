#include <iostream>

using namespace std;

int main() {
    /**
     * string
     * - sequence of char
     * - instantiation of the basic_string
     */

    // 0. constructor
    string hello = "hello";
    cout << string() << endl;               // empty
    cout << string("hello") << endl;        // copy string
    cout << string("hello", 3, 2) << endl;  // substring at 3 and span 2 characters
    cout << string("hello", 3) << endl;     // copy the first 3 characters
    cout << string(10, 'x') << endl;        // fill
    cout << string(10, 42) << endl;
    cout << string(hello.begin(), hello.begin() + 3) << endl;  // range

    // 1. size = length
    cout << hello.size() << endl;  // length (bytes)
    cout << hello.length() << endl;

    // 2. resize
    hello.resize(hello.size() + 5, '+');  // insert '+' 5 times
    hello.resize(10);

    // 3. at
    cout << hello.at(1) << endl;

    // 4. front
    cout << hello.front() << endl;

    // 5. back
    cout << hello.back() << endl;

    // 6. append
    string p = "practice";
    cout << hello.append(" world") << endl;
    cout << hello.append("c++!", 3, 1) << endl;  // substr 'c++!' from 3 with size 1
    cout << hello.append("c++!", 3) << endl;     // substr 'c++!' from 0 to 3
    cout << hello.append(3, '.') << endl;        // append '.' 3 times
    cout << hello.append(5, 0x2E) << endl;
    cout << hello.append(p.begin(), p.end()) << endl;
    cout << 0x2E << endl;  // hexadecimal

    cout << hello << endl;

    return 0;
}