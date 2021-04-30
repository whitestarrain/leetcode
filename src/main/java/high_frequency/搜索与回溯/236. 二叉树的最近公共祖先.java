
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/**
 * 重要：树的搜索与回溯，本质上就可以理解成树的遍历。
 * return就是回溯
 */


/**
 * 解题思路：最近公共祖先的定义： 设节点 root 为节点 p, p 的某公共祖先，
 * 若其左子节点 root.left和右子节点 root.right都不是 p,q的公共祖先，则称 root 是 “最近的公共祖先” 。
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        if(root==p||root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right =  lowestCommonAncestor(root.right, p, q);

        if(left==null&&right==null){
            return null;
        }
        if(left==null) return right;
        if(right==null) return left;
        return root;  // left!=null and right!=null;
    }

}