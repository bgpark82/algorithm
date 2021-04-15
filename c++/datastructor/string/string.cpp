#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

int main(void) {
    string key = "key";
    string k = key.substr(1);
    auto ans = key == "ey";

    cout << k << " : " << ans << endl;

    string text = "1 2 3 4 5";
    stringstream ss(text);
    string s;
    vector<string> p;
    while(getline(ss, s, ' ')) {
        p.push_back(s);
    }
    for(auto v: p) {
        cout << v << endl;
    }

    return 0;
};