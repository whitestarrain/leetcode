import java.util.HashMap;

/**
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]

返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7

*/



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int[] preorder = null;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i); // 中序遍历中，值-->位置 的映射

        if(preorder.length==0) return null;
        return recur(0,0,preorder.length-1);
    }
    /**
     * @param root 当前子树的根节点
     * @param left root为根节点，左子树在中序遍历中的边界
     * @param right root为根节点，右子树在中序遍历中的边界
     * @return
     */
    public TreeNode recur(int root,int left,int right){
        if(left>right) return null;
        TreeNode node = new TreeNode(this.preorder[root]);
        int i = this.map.get(this.preorder[root]);
        node.left = recur(root+1, left,i-1);
        // 先遍历左子树，再遍历右子树。因此右子树的根节点索引为左子树的节点数。
        // i - left + root + 1   :   根节点索引 + 左子树长度 + 1
        node.right = recur(root+i-left+1,i+1, right); 
        return node;
    }
}