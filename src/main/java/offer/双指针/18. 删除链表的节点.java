/**
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

题目保证链表中节点的值互不相同

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode p1 = head,p2=head;
        if(p1.val==val){
            return p1.next;
        }

        // p2 永远紧跟着p1
        p1 = p1.next;
        while(p1!=null&&p1.val!=val){
            p2 = p1;
            p1 = p1.next;
        }
        if(p1!=null){
            p2.next = p1.next;
        }
        return head;
    }
}