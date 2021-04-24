#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Node {
    int x;
    int y;
    int num;
    Node* left;
    Node* right;
};

vector<Node> nodes;

bool comp(Node& a, Node& b) {
    if (a.y == b.y) return a.x < b.x;
    return a.y > b.y;
};

void dynamic(Node* p, Node* c) {
    if (p->x > c->x) {
        if (p->left == nullptr)
            p->left = c;
        else
            dynamic(p->left, c);
    } else {
        if (p->right == nullptr)
            p->right = c;
        else
            dynamic(p->right, c);
    }
}

void preorder(Node* root, vector<int>& s) {
    if (root == nullptr) return;
    s.push_back(root->num);
    preorder(root->left, s);
    preorder(root->right, s);
}

void postorder(Node* root, vector<int>& s) {
    if (root == nullptr) return;
    postorder(root->left, s);
    postorder(root->right, s);
    s.push_back(root->num);
}

vector<vector<int>> solution(vector<vector<int>> nodeinfo) {
    vector<vector<int>> solution = {{}, {}};

    for (int i = 0; i < nodeinfo.size(); i++) {
        nodes.push_back({nodeinfo[i][0], nodeinfo[i][1], i + 1});
    }

    sort(nodes.begin(), nodes.end(), comp);

    for (int i = 1; i < nodeinfo.size(); i++) {
        dynamic(&nodes[0], &nodes[i]);
    }

    preorder(&nodes[0], solution[0]);
    postorder(&nodes[0], solution[1]);

    return solution;
}

int main(void) {
    vector<vector<int>> nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1},
                                    {1, 3}, {8, 6},  {7, 2},  {2, 2}};
    auto ans = solution(nodeinfo);

    for (int i : ans[0]) {
        cout << i << " ";
    }
    cout << endl;
    for (int i : ans[1]) {
        cout << i << " ";
    }

    return 0;
};