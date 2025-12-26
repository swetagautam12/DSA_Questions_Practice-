/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:

    void helper(Node* root, int d, map<int, vector<Node*>>& lv) {
        if (!root) return;

        lv[d].push_back(root);

        helper(root->left, d+1, lv);
        helper(root->right, d+1, lv);
    }

    Node* connect(Node* root) {
        map<int, vector<Node*>> lv;
        helper(root, 0, lv);

        for (auto& pair : lv) {
            for (int i = 0; i < pair.second.size() - 1; i++) {
                pair.second[i]->next = pair.second[i+1];
            }
        }

        return root;
    }
};