/**
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null||isSymmetricSon(root.left, root.right);
    }
    /**
     * 当 L 和 R 同时越过叶节点： 此树从顶至底的节点都对称，因此返回 true ；
     * 当 L 或 R 中只有一个越过叶节点： 此树不对称，因此返回 false ；
     * 节点 L 值 != 节点 R 值： 此树不对称，因此返回 false ；
     */
    public boolean isSymmetricSon(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null||left.val!=right.val) return false;
        return isSymmetricSon(left.left,right.right)&&isSymmetricSon(right.left,right.right);
    }
}