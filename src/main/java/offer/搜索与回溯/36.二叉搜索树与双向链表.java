/**
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。


我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dbies/
 */

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

/**
 * 中序遍历
 */
/*
class Solution {
    Node head;
    Node last;
    public Node treeToDoublyList(Node root) {
        middleTravel(root);
        head.left = last;
        last.right = head;
        return head;
    }

    public Node middleTravel(Node root){
        if(root==null) return null;

        // 遍历左节点
        Node left = middleTravel(root.left);

        if(left!=null){
            // 找到头结点（最左下的节点）
            if(left.left==null){
                head=left;
            }
            left.right= root;
            root.left = left;
        }

        // 遍历右节点
        Node right = middleTravel(root.right);

        if(right!=null){
            // 找到尾结点（最左下的节点）
            if(right.right==null){
                last = right;
            }
            root.right = right;
            right.left = root;
        }

        // 返回子链表的最后一个节点
        // 当遍历完成后也就是整个链表的最后一个节点
        return last;
    }
}
*/

/**
<pre>
- 终止条件： 当节点 cur 为空，代表越过叶节点，直接返回；
- 递归左子树，即 dfs(cur.left) ；
- 构建链表：
    - 当 pre 为空时： 代表正在访问链表头节点，记为 head ；
    - 当 pre 不为空时： 修改双向节点引用，即 pre.right = cur ， cur.left = pre ；
    - 保存 cur ： 更新 pre = cur ，即节点 cur 是后继节点的 pre ；
- 递归右子树，即 dfs(cur.right) ；
</pre>
 */
class Solution1{
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        dfs(root);

        head.left = pre; // 遍历到最后，pre为last
        pre.right = head;

        return head;
    }
    public void dfs(Node cur){
        if(cur==null) return;
        dfs(cur.left);

        if(pre==null) head=cur;
        else pre.right = cur;
        
        cur.left = pre;

        // 向前走一步，当前节点成pre、
        pre = cur;

        dfs(cur.right);
    }
}