// Created by Bob at 2024/02/12 21:36
// leetgo: dev
// https://leetcode.cn/problems/binary-tree-postorder-traversal/


struct TreeNode
{
    int              val;
    struct TreeNode *left;
    struct TreeNode *right;
};

// @lc code=begin
#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

// recursive
void postorder(struct TreeNode *node, int *res, int *returnSize)
{
    if (node == NULL) {
        return;
    }
    postorder(node->left, res, returnSize);
    postorder(node->right, res, returnSize);
    res[(*returnSize)++] = node->val;
}

/*
iteration
那对于根节点来说，它要被搞 3 次：
    第 1 次经过它，去向左子树。
    第 2 次从左子树回来，经过它，去向右子树。
    第 3 次从右子树回退到它。
初始化一个空栈。
    当【根节点不为空】或者【栈不为空】时，从根节点开始
    每次将当前节点压入栈中，如果当前节点有左子树，就往左子树跑，没有左子树就往右子树跑。
    若当前节点无左子树也无右子树，从栈中弹出该节点，
        如果当前节点是上一个节点（即弹出该节点后的栈顶元素）的左节点，尝试访问上个节点的右子树，
        如果不是，那当前栈的栈顶元素继续弹出。
*/
void postorder_iter(struct TreeNode *node, int *res, int *returnSize)
{
    struct TreeNode **stack = malloc(sizeof(struct TreeNode *) * 100);
    int               top   = 0;

    struct TreeNode *cur_node = node;

    while (cur_node != NULL || top > 0) {
        while (cur_node != NULL) {
            stack[top++] = cur_node;
            // 往左子树跑
            if (cur_node->left != NULL) {
                cur_node = cur_node->left;
            }
            // 否则往右子树
            else {
                cur_node = cur_node->right;
            }
        }

        // 左右跑完之后，当前栈顶为叶子节点，弹出
        cur_node             = stack[--top];
        res[(*returnSize)++] = cur_node->val;

        // 如果栈不为空，且栈顶元素的左节点，是刚刚弹出的节点
        // 那就继续遍历栈顶元素的右节点
        if (top > 0 && cur_node == stack[top - 1]->left) {
            cur_node = stack[top - 1]->right;
        }
        else {
            cur_node = NULL;
        }
    }

    free(stack);
}

int *postorderTraversal(struct TreeNode *root, int *returnSize)
{
    int *res    = malloc(sizeof(int) * 100);
    *returnSize = 0;
    postorder_iter(root, res, returnSize);
    return res;
}

// @lc code=end

int main(int argc, char *argv[])
{
    struct TreeNode node1 = {1, NULL, NULL};
    struct TreeNode node2 = {2, NULL, NULL};
    struct TreeNode node3 = {3, NULL, NULL};
    node1.right           = &node2;
    node2.left            = &node3;

    int  returnSize = 0;
    int *result     = postorderTraversal(&node1, &returnSize);
}
