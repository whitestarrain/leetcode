import java.util.Map;

/**

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。
 */

/**
 * 使用哈希表
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0,n=nums.length; i < n; i++) {
            int num = target-nums[i];
            if(map.containsKey(num)){
                return new int[]{i,map.get(num)};
            }
            // 比较完之后再put，否则可能会使用两次同一个数。
            map.put(nums[i], i);
        }
        return null;
    }
}