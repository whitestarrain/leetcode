
/**
 * 
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:
     3
    / \
   4   5
  / \
 1   2

给定的树 B：
   4 
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    /**
     * isSubStructure遍历所有的节点，对每个节点执行recur(A,B)
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null&&B!=null) // 确保两棵树都不为空。
                &&
                (recur(A, B)|isSubStructure(A.left, B)||isSubStructure(A.right, B));
                
    }
    /**
     * recur用来判断A为跟的子树中是否包含树B
     */
    public boolean recur(TreeNode A, TreeNode B){
        if(B==null) return true;
        if(A==null||A.val!=B.val) return false;

        // B是A的子树的话，只要B的节点不是null，A的节点就要值就要和B的节点的值相同。
        //当B为null，时，表名遍历B到了尽头，返回true  // 本方法第一行
        // A为null或者A.value!=B.value时，说明A没有节点可以匹配上B的节点，返回false // 本方法第二行
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}