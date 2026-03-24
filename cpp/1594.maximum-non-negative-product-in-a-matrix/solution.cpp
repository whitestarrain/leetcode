// Created by Bob at 2026/03/23 11:24
// leetgo: dev
// https://leetcode.cn/problems/maximum-non-negative-product-in-a-matrix/

#include "LC_IO.h"
#include <algorithm>
#include <bits/stdc++.h>
using namespace std;

// @lc code=begin

class Solution
{
public:
    int maxProductPath(vector<vector<int>> &grid)
    {
        vector<vector<long long>> maxr(grid.size(), vector<long long>(grid[0].size()));
        vector<vector<long long>> minr(grid.size(), vector<long long>(grid[0].size()));
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (i == 0 && j == 0) {
                    maxr[i][j] = grid[i][j];
                    minr[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    maxr[i][j] = grid[i][j] * maxr[i][j - 1];
                    minr[i][j] = grid[i][j] * minr[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    maxr[i][j] = grid[i][j] * maxr[i - 1][j];
                    minr[i][j] = grid[i][j] * minr[i - 1][j];
                    continue;
                }
                if (grid[i][j] > 0) {
                    maxr[i][j] = max(grid[i][j] * maxr[i - 1][j], grid[i][j] * maxr[i][j - 1]);
                    minr[i][j] = min(grid[i][j] * minr[i - 1][j], grid[i][j] * minr[i][j - 1]);
                }
                else {
                    maxr[i][j] = max(grid[i][j] * minr[i - 1][j], grid[i][j] * minr[i][j - 1]);
                    minr[i][j] = min(grid[i][j] * maxr[i - 1][j], grid[i][j] * maxr[i][j - 1]);
                }
            }
        }
        if (maxr[grid.size() - 1][grid[0].size() - 1] < 0) {
            return -1;
        }
        return maxr[grid.size() - 1][grid[0].size() - 1] % (1000000007);
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
    auto      res = obj->maxProductPath(grid);
    LeetCodeIO::print(out_stream, res);
    cout << "\noutput: " << out_stream.rdbuf() << endl;

    delete obj;
    return 0;
}
