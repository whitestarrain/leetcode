// 反转一个单链表。

/**
 * 双指针
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode temp = null;

        head.next = null;

        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

/**
 * 递归
 */
class Solution1{
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }
    public ListNode reverse(ListNode pre,ListNode cur){
        if(cur==null) return pre;

        ListNode res =  reverse(cur,cur.next); // 只是为了返回结果，才保存到res中。

        cur.next = pre;
        return res;
    }
}