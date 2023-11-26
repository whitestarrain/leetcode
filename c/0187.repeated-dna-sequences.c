// Created by whitestarrain at 2023/11/05 23:42
// leetgo: 1.3.8
// https://leetcode.cn/problems/repeated-dna-sequences/

// @lc code=begin

#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

typedef struct
{
    void        *key;
    void        *value;
    struct Node *next;
} *Node;

typedef struct
{
    Node node;
    Node next;
} List;

void hashmap() {}

void hashmap_free() {}

void hashmap_put() {}

void hashget() {}

char **findRepeatedDnaSequences(char *s, int *returnSize)
{
    return NULL;
}

// @lc code=end

int main(int argc, char *argv[])
{
    return EXIT_SUCCESS;
}
