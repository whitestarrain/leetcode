/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// 计数，简单但也高校
class Solution {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while(cur!=null){
            cur = cur.next;
            count++;
        }
        int[] res = new int[count];
        cur = head;
        while(cur!=null){
            res[(count--)-1] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}

// 递归方式


class Solution2 {
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }
}


// 先入栈，再出栈
class Solution3 {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
    return res;
    }
}