import java.util.*;

/**
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
 */


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      if(root==null) return Collections.emptyList();
      Deque<TreeNode> q = new ArrayDeque<>();
      q.offer(root);
      List<List<Integer>> res = new ArrayList<>();
      while(!q.isEmpty()){
        int size = q.size();
        List<Integer> t = new ArrayList<>();
        while(size-->0){
          TreeNode node = q.poll();
          t.add(node.val);
          if(node.left!=null) q.offer(node.left);
          if(node.right!=null) q.offer(node.right);
        }
        res.add(t);
      }

      return res;
    }
}
