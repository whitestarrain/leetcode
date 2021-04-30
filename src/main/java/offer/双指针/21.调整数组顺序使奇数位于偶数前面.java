/**
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */


class Solution {
    public int[] exchange(int[] nums) {
        if(nums.length<=1){
            return nums;
        }
        // i指针在j指针左边
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            // j找到奇数位置
            while(i<j&&nums[j]%2==0) j--;

            // i找到偶数位置
            while(i<j&&nums[i]%2==1) i++;

            // 进行交换
            swap(nums, i, j);
        }
        return nums;
    }

    public void swap(int[] nums,int l,int r){
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }
}