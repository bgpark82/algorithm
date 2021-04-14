#include <iostream>
#include <unordered_map>

using namespace std;

int main(void) {
    unordered_map<string, int> Maps;

    Maps.insert(make_pair("key2", 2));
    Maps["key"] = 1;

    for (auto m : Maps) {
        cout << m.first << " : " << m.second << endl;
    }
    string key = "key";
    string k = key.substr(2);
    cout << k << endl;

    return 0;
};