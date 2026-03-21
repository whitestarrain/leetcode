// Created by Bob at 2026/03/20 14:12
// leetgo: dev
// https://leetcode.cn/problems/minimum-absolute-difference-in-sliding-submatrix/

#include "LC_IO.h"
#include <algorithm>
#include <bits/stdc++.h>
#include <ostream>
#include <vector>
using namespace std;

// @lc code=begin

class Solution
{
public:
    vector<vector<int>> minAbsDiff(vector<vector<int>> &grid, int k)
    {
        vector<vector<int>> result(grid.size() - k + 1, vector<int>(grid[0].size() - k + 1, 0));
        if (k == 1) {
            return result;
        }

        vector<int> l(k * k);
        int         k1     = 0;
        int         minAbs = 0;
        int         index  = 0;
        for (int i = 0; i <= grid.size() - k; i++) {
            for (int j = 0; j <= int(grid[0].size() - k); j++) {
                l.clear();
                minAbs = 0;
                index  = 0;
                k1     = 0;
                for (; k1 < k * k; k1++) {
                    l.push_back(grid[int(k1 / k) + i][k1 % k + j]);
                }
                sort(l.begin(), l.end());
                for (; index < l.size() - 1; index++) {
                    int diff = l[index + 1] - l[index];
                    if (diff == 0) continue;
                    minAbs = minAbs == 0 ? diff : (minAbs > diff) ? diff : minAbs;
                }
                result[i][j] = minAbs;
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
    int k;
    LeetCodeIO::scan(cin, k);

    Solution *obj = new Solution();
    auto      res = obj->minAbsDiff(grid, k);
    LeetCodeIO::print(out_stream, res);
    cout << "\noutput: " << out_stream.rdbuf() << endl;

    delete obj;
    return 0;
}
