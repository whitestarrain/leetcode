// Created by Bob at 2026/03/21 22:11
// leetgo: dev
// https://leetcode.cn/problems/kth-largest-element-in-an-array/

#include "LC_IO.h"
#include <bits/stdc++.h>
#include <vector>
using namespace std;

// @lc code=begin

// 初版每次减一个元素后都会重新构建堆，导致时间超长，
// 其实build第一次后，后面只需要更新特定一个路径即可
class Solution
{
private:
	// 基于堆排序
    int HeapSortSolution(vector<int> &nums, int k)
    {
        int heapSize = nums.size();
        buildMaxHeap(nums, heapSize);
        for (int i = 0; i < k - 1; i++) {
            nums[0] = nums[heapSize - 1];
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }

        return nums[0];
    }

    void buildMaxHeap(vector<int> &nums, int heapSize)
    {
        int i = heapSize % 2 == 0 ? (heapSize - 2) / 2 : (heapSize - 1) / 2;
        for (; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    void maxHeapify(vector<int> &nums, int i, int heapSize)
    {
        int l       = 2 * i + 1;
        int r       = 2 * i + 2;
        int largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swapNum(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    void swapNum(vector<int> &nums, int i, int j)
    {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

	// 快速选择方法。基本思路和快速排序相同
    int QuickSelectSolution(vector<int> &nums, int k)
    {
		return 0;
    }

public:
    int findKthLargest(vector<int> &nums, int k)
    {
        return HeapSortSolution(nums, k);
    }

    // void buildMaxHeap(vector<int> &nums, int heapSize)
    // {
    //     for (int i = heapSize - 1; i > 0; i--) {
    //         int parent_index = (i % 2 == 0) ? (i - 2) / 2 : (i - 1) / 2;
    // 		if (nums[parent_index] < nums[i]){
    // 			swapNum(nums, i, parent_index);
    // 		}
    //     }
    // }
};

// @lc code=end

int main()
{
    ios_base::sync_with_stdio(false);
    stringstream out_stream;

    vector<int> nums;
    LeetCodeIO::scan(cin, nums);
    int k;
    LeetCodeIO::scan(cin, k);

    Solution *obj = new Solution();
    auto      res = obj->findKthLargest(nums, k);
    LeetCodeIO::print(out_stream, res);
    cout << "\noutput: " << out_stream.rdbuf() << endl;

    delete obj;
    return 0;
}
