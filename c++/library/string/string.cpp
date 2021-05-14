#include <string.h>

#include <iostream>
#include <sstream>
#include <string>

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

    // 7. push_back
    char h = 'h';
    hello.push_back(h);  // push one letter back
    hello.push_back('h');

    // 8. assign
    cout << hello.assign("hello") << endl;
    cout << hello.assign("hello", 0, 3) << endl;
    cout << hello.assign("hello", 3) << endl;
    cout << hello.assign(10, '*') << endl;

    // 9. insert
    string::iterator it;

    cout << hello.insert(6, "hello") << endl;        // insert 'hello' at index 6
    cout << hello.insert(6, "hello", 0, 3) << endl;  // insert 'hel' at index 6
    cout << hello.insert(6, "hello", 3) << endl;     // insert 'hel' at index 6
    cout << hello.insert(6, 3, '-') << endl;         // insert '-' 3 times at index 6
    hello.insert((hello.begin() + 6), '>');          // insert '>' at index 6
    hello.insert(hello.begin(), 6, '>');             // insert '>' 6 times at index 0

    // 10. erase
    cout << hello.erase(0, 10) << endl;           // erase from 0 to 10th
    hello.erase(hello.begin() + 10);              // erase 10th
    hello.erase(hello.begin(), hello.end() - 4);  // erase from 0 to -4th
    cout << hello << endl;

    // 11. replace
    cout << hello.replace(0, 5, "hello") << endl;        // replace from 0 to 5 to 'hello'
    cout << hello.replace(0, 5, "hello", 0, 3) << endl;  // replace from 0 to 5 to 'hello' from 0 to 3
    cout << hello.replace(3, 5, 3, '!') << endl;         // from to size 'char'
    cout << hello.replace(hello.begin(), hello.end(), "hello!!") << endl;
    cout << hello.replace(hello.begin() + 5, hello.end(), 3, '!') << endl;

    // 12. swap
    string hi = "hello!";
    hello.swap(hi);

    // 13. pop_back
    hello.pop_back();

    // 14. c_str
    string s = string("abcd");
    const char *pch = s.c_str();
    cout << pch << endl;

    // 15. find
    string f = "find the string value the one";
    cout << f.find("the") << endl;  // find first occurrence
    bool npos = f.find("poter") == string::npos;
    cout << npos << endl;  // return npos if no string found

    // 16. rfind
    cout << f.rfind("the") << endl;  //find last occurrence
    cout << f.replace(f.rfind("the"), 3, "!") << endl;

    // 17. find_first_of
    cout << f.find_first_of("aeiou") << endl;  // find first char matches any of the characters in arugmenet

    // 18. find_last_of
    cout << f.find_last_of("aeiou") << endl;  // find first char matches any of the characters in arugmenet

    // 19. find_first_not_of
    cout << f.find_first_not_of("abcdefghijklmnopqrstuvwxyz ") << endl;  // find first char not matches any of the characters in argument

    // 20. find_last_not_of
    cout << f.find_last_not_of("abcdefghijklmnopqrstuvwxyz ") << endl;  // find first char not matches any of the characters in argument

    // 21. substr
    cout << f.substr(1, 3) << endl;  // substr from with length

    // 22. compare
    string a = "apple";
    string b = "banana";
    cout << a.compare(a) << endl;  // 0: equal
    cout << a.compare(b) << endl;  // -1: left is less than right (<)
    cout << b.compare(a) << endl;  // 1: left is greater than right (>)
    cout << a.compare(0, 3, "app") << endl;
    cout << a.compare(0, 3, "apple", 0, 3) << endl;

    // 23. npos
    // static memeber constant value
    // indicate no matches
    cout << string::npos << endl;

    // 24. getline
    stringstream ss("hello world!");  // get line from stream and store in variable
    string name;                      // until the  delimiter, new line(\n), end of string or error
    getline(ss, name, ' ');
    // ss >> name;
    cout << name << endl;

    cout << f << endl;
    cout << hello << endl;

    return 0;
}