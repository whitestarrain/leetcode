/**
输入两个链表，找出它们的第一个公共节点。
 */



public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**

指针 A 先遍历完链表 headA ，再开始遍历链表 headB ，当走到 node 时，共走步数为：
a + (b - c)

指针 B 先遍历完链表 headB ，再开始遍历链表 headA ，当走到 node 时，共走步数为：
b + (a - c)

如下式所示，此时指针 A , B 重合，并有两种情况：
a + (b - c) = b + (a - c)


若两链表 有 公共尾部 (即 c > 0 ) ：指针 A , B 同时指向「第一个公共节点」node 。
若两链表 无 公共尾部 (即 c = 0 ) ：指针 A , B 同时指向 null 。
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA,B = headB;
        while(A!=B){
            A = A!=null ? A.next : headB;
            B = B!=null ? B.next : headA;
        }
        return A;
    }
}