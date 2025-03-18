// Created by Bob at 2025/03/18 10:29
// leetgo: dev
// https://leetcode.cn/problems/prime-in-diagonal/

#include <bits/stdc++.h>
#include "LC_IO.h"
using namespace std;

// @lc code=begin

class Solution {
public:
    int diagonalPrime(vector<vector<int>> &nums)
    {
        int ans    = 0;
        int length = nums.size();
        for (int i = 0; i < length; i++) {
            if (check_is_prime(nums[i][i])) {
                ans = nums[i][i] > ans ? nums[i][i] : ans;
            }
            if (check_is_prime(nums[i][length - i - 1])) {
                ans = nums[i][length - i - 1] > ans ? nums[i][length - i - 1] : ans;
            }
        }
		return ans;
    }

private:
    bool check_is_prime(int number)
    {
        if (number <= 1) {
            return false;
        }
        int i = 2;
        while (i * i <= number) {
            if (number % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
};

// @lc code=end

int main() {
	ios_base::sync_with_stdio(false);
	stringstream out_stream;

	vector<vector<int>> nums;
	LeetCodeIO::scan(cin, nums);

	Solution *obj = new Solution();
	auto res = obj->diagonalPrime(nums);
	LeetCodeIO::print(out_stream, res);
	cout << "\noutput: " << out_stream.rdbuf() << endl;

	delete obj;
	return 0;
}
