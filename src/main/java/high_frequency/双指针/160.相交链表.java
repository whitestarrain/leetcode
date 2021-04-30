
/**
编写一个程序，找到两个单链表相交的起始节点。

剑指offer 双指针 52题
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA,node2 = headB;
        while(node1!=node2){
            node1 = node1!=null ? node1.next : headB;
            node2 = node2!=null ? node2.next : headA;
        }
        return node1;
    }
}