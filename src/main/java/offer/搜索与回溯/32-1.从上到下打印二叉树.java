import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.ListenerNotFoundException;

/**
 * 二叉树的广度优先遍历
 */



public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        List<Integer> arr =new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode node = q.poll();
                arr.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
        }
        int[] res = new int[arr.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}