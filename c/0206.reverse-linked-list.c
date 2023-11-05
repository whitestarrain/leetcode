// Created by whitestarrain at 2023/11/05 23:43
// leetgo: 1.3.8
// https://leetcode.cn/problems/reverse-linked-list/


struct ListNode
{
    int              val;
    struct ListNode *next;
};

// @lc code=begin

#include <stddef.h>

struct ListNode *reverseList(struct ListNode *head)
{
    struct ListNode *preNode = NULL;
    struct ListNode *curNode = head;

    while (curNode) {
        struct ListNode *next = curNode->next;
        curNode->next         = preNode;
        preNode               = curNode;
        curNode               = next;
    }

    return preNode;
}

// @lc code=end

