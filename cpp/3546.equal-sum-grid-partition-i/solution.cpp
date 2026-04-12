// Created by Bob at 2026/04/12 18:03
// leetgo: dev
// https://leetcode.cn/problems/equal-sum-grid-partition-i/

#include "LC_IO.h"
#include <bits/stdc++.h>
using namespace std;

// @lc code=begin

class Solution
{
public:
    bool canPartitionGrid(vector<vector<int>> &grid)
    {
        int       m = grid.size(), n = grid[0].size();
        long long total = 0;
        // 二维前缀和
        vector<vector<long long>> sum(m + 1, vector<long long>(n + 1, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + grid[i][j];
            }
        }

        for (int i = 1; i < m; i++) {
            if (total == sum[i][n] * 2) {
                return true;
            }
        }

        for (int i = 1; i < n; i++) {
            if (total == sum[m][i] * 2) {
                return true;
            }
        }
        return false;
    }
};

// @lc code=end

int main()
{
    ios_base::sync_with_stdio(false);
    stringstream out_stream;

    vector<vector<int>> grid;
    LeetCodeIO::scan(cin, grid);

    Solution *obj = new Solution();
    auto      res = obj->canPartitionGrid(grid);
    LeetCodeIO::print(out_stream, res);
    cout << "\noutput: " << out_stream.rdbuf() << endl;

    delete obj;
    return 0;
}
