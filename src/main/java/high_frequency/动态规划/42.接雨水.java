/**
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */


/**
思路:
1. 对于下标 i，水能达到的最大高度等于下标 i 左右两侧的最大高度的最小值，再减去 height[i] 就能得到当前柱子所能存的水量。
2. 通过动态规划求下标位i位置处的左侧最大和右侧最大
*/
class Solution {
    public int trap(int[] height) {

        if(height.length<3){
            return 0;
        }

        // 3.左侧最大
        int[] leftMax = new int[height.length];
        // 4. 之后要 Math.min(leftMax[i], rightMax[i]) - height[i];
        // 要确保index为0的地方和n-1的地方结果为0.（因为根本装不了雨。）
        leftMax[0] = height[0];

        // 开始状态转移
        for(int i = 1;i<height.length;i++){
            // 之所以要把leftMax[i-1]和height[i]相比较
            // 是因为之后还要通过减去height[i]得到水量。
            // 因此最小要置为height[i]
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        // 右侧最大
        int[] rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];

        // 开始状态转移
        for(int i = height.length-2;i>=0;i--){
            // 原因同上
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        int res = 0;

        for(int i = 0;i<height.length;i++){
            res+=Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;

    }
}