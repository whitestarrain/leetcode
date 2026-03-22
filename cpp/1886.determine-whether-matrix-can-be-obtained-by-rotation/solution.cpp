// Created by Bob at 2026/03/22 18:52
// leetgo: dev
// https://leetcode.cn/problems/determine-whether-matrix-can-be-obtained-by-rotation/

#include "LC_IO.h"
#include <bits/stdc++.h>
#include <vector>
using namespace std;

// @lc code=begin

class Solution
{
public:
    bool findRotation(vector<vector<int>> &mat, vector<vector<int>> &target)
    {
        if (mat == target) return true;
        vector<vector<int>> a1 = mat;
        vector<vector<int>> a2(mat.size(), vector<int>(mat[0].size()));
        for (int i = 0; i < 3; i++) {
            rotate(a1, a2);
            if (a2 == target) {
                return true;
            }
            a1 = a2;
        }
        return false;
    }

    void rotate(vector<vector<int>> &origin, vector<vector<int>> &target)
    {
        for (int i = 0; i < origin.size(); i++) {
            for (int j = 0; j < origin[0].size(); j++) {
                target[j][origin.size() - 1 - i] = origin[i][j];
            }
        }
    }
};

// @lc code=end

int main()
{
    ios_base::sync_with_stdio(false);
    stringstream out_stream;

    vector<vector<int>> mat;
    LeetCodeIO::scan(cin, mat);
    vector<vector<int>> target;
    LeetCodeIO::scan(cin, target);

    Solution *obj = new Solution();
    auto      res = obj->findRotation(mat, target);
    LeetCodeIO::print(out_stream, res);
    cout << "\noutput: " << out_stream.rdbuf() << endl;

    delete obj;
    return 0;
}
