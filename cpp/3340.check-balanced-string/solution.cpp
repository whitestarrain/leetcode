// Created by Bob at 2025/03/14 15:46
// leetgo: dev
// https://leetcode.cn/problems/check-balanced-string/

#include <bits/stdc++.h>
#include "LC_IO.h"
using namespace std;

// @lc code=begin

class Solution {
public:
    bool isBalanced(string num) {
        int diff = 0;
        int sign = 1;
        for(char c : num) {
            int d = c - '0';
            diff = diff + d * sign;
            sign = -sign;
        }
        return diff == 0;
    }
};

// @lc code=end

int main() {
	ios_base::sync_with_stdio(false);
	stringstream out_stream;

	string num;
	LeetCodeIO::scan(cin, num);

	Solution *obj = new Solution();
	auto res = obj->isBalanced(num);
	LeetCodeIO::print(out_stream, res);
	cout << "\noutput: " << out_stream.rdbuf() << endl;

	delete obj;
	return 0;
}
