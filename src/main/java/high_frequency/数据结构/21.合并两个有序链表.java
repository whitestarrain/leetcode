
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 递归解法
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } 
    }
}

/**
 * 循环解法
 */
class Solution1{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 如果一个为null，就直接返回另一个即可。
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        // dummy仅仅是为了用dummy.next保存链表表头索引。
        // 最后返回dummy.next
        ListNode  dummy = new ListNode(0);
        ListNode cur = dummy;
        dummy.next  = cur;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            // cur.next已经赋值，向前走。
            cur = cur.next;
        }
        cur.next = l1==null ? l2 : l1;
        return dummy.next;
    }
}