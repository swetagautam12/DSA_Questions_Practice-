class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(head==NULL) return NULL;
        ListNode* temp=head->next;
        ListNode* prev=head;
        while(temp!=NULL)
        {   bool flag=false;
            while(temp!=NULL && temp->val==prev->val)
            {
                temp=temp->next;
                flag=true;
            }
            if(flag) prev->next=temp;
            prev=temp;
            if(temp!=NULL)temp=temp->next;
        }
        return head;
    }
};