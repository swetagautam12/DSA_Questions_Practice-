/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *rev_l1 = reverse_ll(l1);
        ListNode *rev_l2 = reverse_ll(l2);

        int t = 0;
        ListNode *prev_node = nullptr;
        ListNode *last = nullptr;
    
        while (rev_l1 && rev_l2) {
            int sum = rev_l1->val + rev_l2->val + t;
            t = sum / 10;

            ListNode *new_node = new ListNode(sum % 10);
            last = new_node;

            if (!prev_node) {
                prev_node = new_node;
                prev_node->next = nullptr;
            } else {
                new_node->next = prev_node;
                prev_node = new_node;
            }

            rev_l1 = rev_l1->next;
            rev_l2 = rev_l2->next;
        }

        while (rev_l1) {
            int sum = rev_l1->val + t;
            t = sum / 10;

            ListNode *new_node = new ListNode(sum % 10);
            last = new_node;

            if (!prev_node) {
                prev_node = new_node;
                prev_node->next = nullptr;
            } else {
                new_node->next = prev_node;
                prev_node = new_node;
            }

            rev_l1 = rev_l1->next;
        }

        while (rev_l2) {
            int sum = rev_l2->val + t;
            t = sum / 10;

            ListNode* new_node = new ListNode(sum % 10);
            last = new_node;

            if (!prev_node) {
                prev_node = new_node;
                prev_node->next = nullptr;
            } else {
                new_node->next = prev_node;
                prev_node = new_node;
            }

            rev_l2 = rev_l2->next;
        }

        if (t) {
            ListNode *new_node = new ListNode(1);
            last = new_node;

            if (!prev_node) {
                prev_node = new_node;
                prev_node->next = nullptr;
            } else {
                new_node->next = prev_node;
            }
        }

        return last;
    }
private:
    ListNode *reverse_ll(ListNode *node) {
        ListNode *prev = node;
        ListNode *curr = node->next;
        prev->next = nullptr;

        while (curr) {
            ListNode *aux = curr->next;
            curr->next = prev;
            prev = curr;
            curr = aux;
        }

        return prev;
    }
};