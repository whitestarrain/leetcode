
/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 思路：中序遍历，得到递增序列
 */
class Solution {
    // 记录结果
    private int min;

    // 用来记录中序遍历得到的序列中，当前所在节点的前一个值。
    private int pre = -1;

    public int minDiffInBST(TreeNode root) {
        this.min = Integer.MAX_VALUE;
        dfs(root);
        return min;
    }
    public void dfs(TreeNode node){
        if(node == null) return;
        // 左
        dfs(node.left);

        // 中
        if(pre==-1){
            pre = node.val;
        }else{
            this.min = Math.min(min, node.val-pre);
            pre = node.val;
        }

        // 右
        dfs(node.right);
    }
}