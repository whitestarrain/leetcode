/**
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：
     5
    / \
   2   6
  / \
 1   3

示例 1： 
输入: [1,6,3,2,5]
输出: false

示例 2：
输入: [1,3,2,6,5]
输出: true
 */

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        // [左子树][右子树][根节点]

        return recur(postorder,0,postorder.length-1);
    }

    public boolean recur(int[] tree,int left,int right){
        // 说明为空，返回true
        if(left>=right){return true;}

        // 如何找到左子树根节点：找到最后一个比节点小的数
        int p = left; // p开始奔跑
        while(tree[p]<tree[right]) p++;
        int m = p-1;  // m用来保存左子树根节点

        // 如何找到右子树根节点：找到比根节点大的最后一个数，也就是倒数第二个数
        while(tree[p]>tree[right]) p++;

        // 如何判断本棵树是否正确。[左子树]<根节点<[右子树]
        // 只要p最后能跑到最右边，说明符合上面那个规则，为后序遍历

        return p==right&&recur(tree,left,m)&&recur(tree, m+1, right-1);
    }

}