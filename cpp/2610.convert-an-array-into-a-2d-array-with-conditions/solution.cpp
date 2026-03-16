// Created by Bob at 2025/03/19 14:54
// leetgo: dev
// https://leetcode.cn/problems/convert-an-array-into-a-2d-array-with-conditions/

#include "LC_IO.h"
#include <bits/stdc++.h>
#include <map>
using namespace std;

// @lc code=begin

class Solution
{
public:
    vector<vector<int>> findMatrix(vector<int> &nums)
    {
        map<int, int> numMap;
        int           maxOccurNum = 0;
        for (int num : nums) {
            if (numMap.count(num) == 0) {
                numMap[num] = 1;
            }
            else {
                numMap[num]++;
            }
            if (numMap[num] > maxOccurNum) {
                maxOccurNum = numMap[num];
            }
        }
        vector<vector<int>> result(maxOccurNum, vector<int>());
        for (map<int, int>::iterator it = numMap.begin(); it != numMap.end(); it++) {
            int occurNum = it->second;
            for (int i = 0; i < occurNum; i++) {
                result[i].push_back(it->first);
            }
        }
		return result;
    }
};

// @lc code=end

int main()
{
    ios_base::sync_with_stdio(false);
    stringstream out_stream;

    vector<int> nums;
    LeetCodeIO::scan(cin, nums);

    Solution *obj = new Solution();
    auto      res = obj->findMatrix(nums);
    LeetCodeIO::print(out_stream, res);
    cout << "\noutput: " << out_stream.rdbuf() << endl;

    delete obj;
    return 0;
}
