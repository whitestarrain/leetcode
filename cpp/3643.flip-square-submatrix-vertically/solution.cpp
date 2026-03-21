// Created by Bob at 2026/03/21 17:19
// leetgo: dev
// https://leetcode.cn/problems/flip-square-submatrix-vertically/

#include "LC_IO.h"
#include <bits/stdc++.h>
using namespace std;

// @lc code=begin

/*
 * [3,4,2,3]
 * [2,3,4,2]
 * [2,3,4,2]
 * */


class Solution
{
public:
    vector<vector<int>> reverseSubmatrix(vector<vector<int>> &grid, int x, int y, int k)
    {
        float middleLine = x + float(k - 1) / 2;
        for (int i = x; i < middleLine; i++) {
            int i2 = middleLine + (middleLine - i);
			if (i == i2) continue;
            for (int j = y; j < y + k; j++) {
                grid[i][j]  = grid[i][j] ^ grid[i2][j];
                grid[i2][j] = grid[i][j] ^ grid[i2][j];
                grid[i][j]  = grid[i][j] ^ grid[i2][j];
            }
        }

        return grid;
    }
};

// @lc code=end

int main()
{
    ios_base::sync_with_stdio(false);
    stringstream out_stream;

    vector<vector<int>> grid;
    LeetCodeIO::scan(cin, grid);
    int x;
    LeetCodeIO::scan(cin, x);
    int y;
    LeetCodeIO::scan(cin, y);
    int k;
    LeetCodeIO::scan(cin, k);

    Solution *obj = new Solution();
    auto      res = obj->reverseSubmatrix(grid, x, y, k);
    LeetCodeIO::print(out_stream, res);
    cout << "\noutput: " << out_stream.rdbuf() << endl;

    delete obj;
    return 0;
}
