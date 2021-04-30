import java.util.Arrays;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
    要求时间复杂度为O(n)。
 */


/**
 * 动态规划
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        for(int i = 1;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>max){
                max = dp[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

/**
 * 动态规划，不再构建dp数组
 */
class Solution2 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = nums[0];
        for(int i = 1;i<nums.length;i++){
            pre = Math.max(pre+nums[i],nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
