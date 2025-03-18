// Created by Bob at 2025/03/17 19:37
// leetgo: dev
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

#include <bits/stdc++.h>
#include <iostream>
#include <set>
#include "LC_IO.h"
using namespace std;

// @lc code=begin

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.empty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int       ans = 0;
        int       lft = 0, rgt = 0;
        set<char> char_set;
        while (lft < s.length()) {
            rgt = lft;
            char_set.clear();
            while (rgt < s.length()) {
                if (char_set.find(s[rgt]) == char_set.end()) {
                    char_set.insert(s[rgt]);
                    ans = char_set.size() > ans ? char_set.size() : ans;
                }
                else {
                    break;
                }
                rgt++;
            }
            lft++;
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
	auto res = obj->lengthOfLongestSubstring(s);
	LeetCodeIO::print(out_stream, res);
	cout << "\noutput: " << out_stream.rdbuf() << endl;

	delete obj;
	return 0;
}
