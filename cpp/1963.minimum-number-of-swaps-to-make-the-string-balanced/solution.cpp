// Created by Bob at 2025/03/17 00:25
// leetgo: dev
// https://leetcode.cn/problems/minimum-number-of-swaps-to-make-the-string-balanced/

#include <bits/stdc++.h>
#include "LC_IO.h"
using namespace std;

// @lc code=begin

class Solution {
public:
	// 标准解法是 数学归纳法
    int minSwaps(string s) {
		int ans = 0;
        if (s.empty()) {
            return ans;
        }
        // [ 为+1， ] 为-1，不断累加
        // sign 一直大于等于0，才是平衡字符串
        int sign  = 0;
        int s_len = s.length();
        int j     = s_len - 1;
        for (int i = 0; i < s_len; i++) {
            char c = s[i];
            if (c == '[') {
                sign++;
            }
            else {
                if (sign > 0) {
                    sign--;
                }
                else {
                    // 从最右侧开始交换。']' 交换得越靠右，sign 越可能不小于0
                    while (j > 0 && s[j] != '[') {
                        j--;
                    }
                    s[i] = '[';
                    s[j] = ']';
                    sign++;
					ans++;
                }
            }
        }
        return ans;
    }
};

// @lc code=end

int main() {
	ios_base::sync_with_stdio(false);
	stringstream out_stream;

	string s;
	LeetCodeIO::scan(cin, s);

	Solution *obj = new Solution();
	auto res = obj->minSwaps(s);
	LeetCodeIO::print(out_stream, res);
	cout << "\noutput: " << out_stream.rdbuf() << endl;

	delete obj;
	return 0;
}
