// Created by Bob at 2025/10/13 20:08
// leetgo: dev
// https://leetcode.cn/problems/minimum-path-sum/

#include <bits/stdc++.h>
#include "LC_IO.h"
using namespace std;

// @lc code=begin

// https://www.hugchange.life/posts/202312_recur_dp_parsing.html

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
    }
};

// @lc code=end

int main() {
	ios_base::sync_with_stdio(false);
	stringstream out_stream;

	vector<vector<int>> grid;
	LeetCodeIO::scan(cin, grid);

	Solution *obj = new Solution();
	auto res = obj->minPathSum(grid);
	LeetCodeIO::print(out_stream, res);
	cout << "\noutput: " << out_stream.rdbuf() << endl;

	delete obj;
	return 0;
}
