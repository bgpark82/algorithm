#include <iostream>
#include <vector>

using namespace std;

void fillLock(int arr[58][58], vector<vector<int>> lock, int offset) {
    for (int x = 0; x < lock.size(); x++) {
        for (int y = 0; y < lock.size(); y++) {
            arr[offset + x][offset + y] = lock[x][y];
        }
    }
}

void fillKey(int arr[58][58], vector<vector<int>> key, int rot, int i, int j) {
    int size = key.size();

    for (int x = 0; x < size; x++) {
        for (int y = 0; y < size; y++) {
            if (rot == 0) {
                arr[i + x][j + y] += key[x][y];
            }
            if (rot == 1) {
                arr[i + x][j + y] += key[y][size - 1 - x];
            }
            if (rot == 2) {
                arr[i + x][j + y] += key[size - 1 - x][size - 1 - y];
            }
            if (rot == 3) {
                arr[i + x][j + y] += key[size - 1 - y][x];
            }
        }
    }
}

bool isFill(int arr[58][58], int offset, int size) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if (arr[i + offset][j + offset] != 1) {
                return false;
            }
        }
    }
    return true;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    int offset = lock.size() - 1;

    for (int i = 0; i < lock.size() + offset; i++) {
        for (int j = 0; j < lock.size() + offset; j++) {
            for (int r = 0; r < 4; r++) {
                int arr[58][58] = {0};
                fillLock(arr, lock, offset);
                fillKey(arr, key, r, i, j);
                if (isFill(arr, offset, lock.size())) {
                    return true;
                }
            }
        }
    }

    return false;
}

int main(void) {
    vector<vector<int>> key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
    vector<vector<int>> lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    cout << solution(key, lock) << endl;

    return 0;
};