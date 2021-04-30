import java.util.concurrent.RecursiveAction;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// 递归
class Solution{
    public ListNode reverseList(ListNode head) {
        return reverse(null,head);
    }
    private ListNode reverse(ListNode pre,ListNode cur){
        if(cur == null) return pre; //到达了最后一次递归，pre就是最后一个Node
        ListNode res = reverse(cur,cur.next); // 如果没有到达最后，就一直往后递归

        // 当回溯是开始执行下方代码
        cur.next = pre; // 修改节点饮用指向
        return res; // 递归到最后，pre为最后一个节点，返回后，一直返回到这里
    }
}

// 迭代，双指针
class Solution2{
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}