#include <iostream>

using namespace std;

int main(void) {
    string key = "key";
    string k = key.substr(1);
    auto ans = key == "ey";

    cout << k << " : " << ans << endl;

    return 0;
};