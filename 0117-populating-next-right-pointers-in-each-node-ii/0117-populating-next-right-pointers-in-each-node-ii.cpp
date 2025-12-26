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
    Node* connect(Node* root) {
        if(root == NULL) return root;

        Node* lvlstart = root;
        while(lvlstart!=NULL){
            Node* curr = lvlstart;
            Node* dummy = new Node(0);
            Node* prev = dummy;

            while(curr!=NULL){
                if(curr->left!=NULL){
                    prev->next = curr->left;
                    prev = prev->next;
                }
                if(curr->right!=NULL){
                    prev->next = curr->right;
                    prev = prev->next;
                }
                curr = curr->next;

            }
            lvlstart = dummy->next;
            delete dummy;
        }
        return root;
    }
};