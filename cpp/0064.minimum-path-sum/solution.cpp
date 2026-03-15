// Created by Bob at 2025/10/13 20:08
// leetgo: dev
// https://leetcode.cn/problems/minimum-path-sum/

#include "LC_IO.h"
#include <algorithm>
#include <bits/stdc++.h>
#include <cstdio>
#include <iostream>
#include <vector>
using namespace std;

// @lc code=begin

// https://www.hugchange.life/posts/202312_recur_dp_parsing.html

class Solution
{
    /*
     * [1,3,1]
     * [1,5,1]
     * [4,2,1]
     *
     */

public:
    int minPathSum(vector<vector<int>> &grid)
    {
        if (grid.size() == 0 || grid[0].size() == 0) {
            return 0;
        }
        vector<vector<int>> dp(grid.size(), vector<int>(grid[0].size()));
        for (int x = 0; x < grid[0].size(); x++) {
            for (int y = 0; y < grid.size(); y++) {
                if (x == 0 && y == 0) {
                    dp[y][x] = grid[0][0];
                    continue;
                }
                if (x == 0) {
                    dp[y][x] = grid[y][x] + dp[y - 1][x];
                    continue;
                }
                if (y == 0) {
                    dp[y][x] = grid[y][x] + dp[y][x - 1];
                    continue;
                }
                dp[y][x] = min(grid[y][x] + dp[y - 1][x], grid[y][x] + dp[y][x - 1]);
            }
        }
        return dp[grid.size() - 1][grid[0].size() - 1];
    }

    // too slow
    // minPathSumXY(grid, int(grid[0].size()) - 1, int(grid.size()) - 1);
    // int minPathSumXY(vector<vector<int>> &grid, int x, int y)
    // {
    //     if (x == 0 && y == 0) {
    //         return grid[0][0];
    //     }
    //     if (x == 0) {
    //         return grid[y][x] + minPathSumXY(grid, x, y - 1);
    //     }
    //     if (y == 0) {
    //         return grid[y][x] + minPathSumXY(grid, x - 1, y);
    //     }
    //     return grid[y][x] + min(minPathSumXY(grid, x - 1, y), minPathSumXY(grid, x, y - 1));
    // }
};

// @lc code=end

int main()
{
    ios_base::sync_with_stdio(false);
    stringstream out_stream;

    vector<vector<int>> grid;
    LeetCodeIO::scan(cin, grid);

    Solution *obj = new Solution();
    auto      res = obj->minPathSum(grid);
    LeetCodeIO::print(out_stream, res);
    cout << "\noutput: " << out_stream.rdbuf() << endl;

    delete obj;
    return 0;
}
