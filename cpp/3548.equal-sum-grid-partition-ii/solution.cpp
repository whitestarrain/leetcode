// Created by Bob at 2026/03/26 00:12
// leetgo: dev
// https://leetcode.cn/problems/equal-sum-grid-partition-ii/

#include <bits/stdc++.h>
#include "LC_IO.h"
using namespace std;

// @lc code=begin

class Solution {
public:
    bool canPartitionGrid(vector<vector<int>>& grid) {
        
    }
};

// @lc code=end

int main() {
	ios_base::sync_with_stdio(false);
	stringstream out_stream;

	vector<vector<int>> grid;
	LeetCodeIO::scan(cin, grid);

	Solution *obj = new Solution();
	auto res = obj->canPartitionGrid(grid);
	LeetCodeIO::print(out_stream, res);
	cout << "\noutput: " << out_stream.rdbuf() << endl;

	delete obj;
	return 0;
}
