// Created by Bob at 2026/03/24 23:51
// leetgo: dev
// https://leetcode.cn/problems/construct-product-matrix/

#include "LC_IO.h"
#include <bits/stdc++.h>
#include <vector>
using namespace std;

// @lc code=begin

class Solution
{
public:
	// 2  3  4 5
	// 60 20 5 1
	// 1  2   6  24
    vector<vector<int>> constructProductMatrix(vector<vector<int>> &grid)
    {
        int                 mod = 12345;
        vector<vector<int>> result(grid.size(), vector<int>(grid[0].size()));
        long long           t = 1;
        for (int i = grid.size() - 1; i >= 0; i--) {
            for (int j = grid[0].size() - 1; j >= 0; j--) {
                result[i][j] = t;
                t            = (grid[i][j] * t) % mod;
            }
        }

        t = 1;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                result[i][j] = result[i][j] * t % mod;
                t            = (grid[i][j] * t) % mod;
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

    vector<vector<int>> grid;
    LeetCodeIO::scan(cin, grid);

    Solution *obj = new Solution();
    auto      res = obj->constructProductMatrix(grid);
    LeetCodeIO::print(out_stream, res);
    cout << "\noutput: " << out_stream.rdbuf() << endl;

    delete obj;
    return 0;
}
