import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

示例:
给定如下二叉树，以及目标和 target = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
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
 * 1. 思路分析：
 * 二叉树并没有进行排序，因此深度优先遍历，相加即可。
 * 
 * 每一个节点都调用一次add方法，用来递归查找。
 * 返回的List<List<Integer>> 为当前节点到叶子节点相加为target的所有路径。
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list =  add(root,target);
        if(list!=null)
            for (List<Integer> l : list) {
                if(l!=null)
                    Collections.reverse(l);
            }
        return list!=null ? list : new ArrayList<List<Integer>>();
    }

    public List<List<Integer>> add(TreeNode node,int target){

        // 3. 设置终结条件
        if(node.val == target&&node.left == null && node.right == null){
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            List<Integer> tempList = new ArrayList<Integer>();
            tempList.add(node.val);
            list.add(tempList);
            return list;
        }

        // 2. 设置递归

        // 2.1 为null的情况
        if(node.left==null && node.right == null){
            return null;
        }


        // 用来存储结果
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        // ------------------------------
        // 得到左侧路径和右侧路径，冰洁放到list中。

        // 2.2 左侧路径
        if(node.left!=null){
            List<List<Integer>> listLeft = add(node.left,target-node.val);
            if(listLeft!=null)
                list.addAll(listLeft);
        }

        // 2.3 右侧路径
        if(node.right!=null){
            List<List<Integer>> listRight = add(node.right,target-node.val);
            if(listRight!=null){
                list.addAll(listRight);
            }
        }

        // ------------------------------

        // 2.4把当前节点添加到路径中。
        for (List<Integer> l : list) {
            l.add(node.val);
        }

        // 返回
        return list;
    }

}

// ======================================

/**
 * 官方题解
 * 思路和上面的一样，但是简化了很多
 */
class Solotion1{
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}
