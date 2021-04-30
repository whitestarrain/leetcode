
/**
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */

/**
设 dp[i] 表示 [0..i] 中，以 nums[i] 结尾的最大子数组和，状态转移方程 dp[i] = nums[i] + max(dp[i - 1], 0)。

由于 dp[i] 只与子问题 dp[i-1] 有关，故可以用一个变量 f 来表示。
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = nums[0];// 用来存储 dp[i-1]
        int max = nums[0];// 用来存储结果值。

        for (int i = 1; i < nums.length; i++) {
            // dp[i] = nums[i] = max(dp[i-1],0)
            pre = nums[i] + Math.max(pre,0);
            if(pre>max){
                // 更新结果
                max = pre;
            }
        }

        return max;
    }
}