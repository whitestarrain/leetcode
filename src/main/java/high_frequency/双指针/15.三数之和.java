import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/**
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
*/

/**

该解法超出时间限制

思路是
    排序
    固定第一个数
    双指针都是从左到右移动，遍历
    需找 i2+i3 = -i1 的数
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length<3){
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int one = 0; one < nums.length-2; one++) {

            if(one>0 && nums[one]==nums[one-1]) continue;

            int i = one+1;
            int j = one+2;

            // 最小的两个数都比 -nums[one]大，没希望了。直接continue
            if(nums[i]+nums[j]>-nums[one]) continue;


            for(;i<nums.length-1;i++){

                // 如果和前面一个数一样，那么前面那个数对应的结果已经添加了，不需要重复添加
                if(i>one+1 && nums[i]==nums[i-1]) continue;

                for(j = i+1;j<nums.length;j++){

                    if(j>i+1 && nums[j]==nums[j-1]) continue;

                    if(nums[i]+nums[j]==-nums[one]){
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[one]);
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        list.add(tempList);
                    }
                }
            }
        }

        return list;
    }
}

/**
和上面一样，都是固定一个值
再移动双指针
唯一区别是
一个指针从右向左。
一个指针从左向右。
 */
class Solution1{
    public List<List<Integer>> threeSum(int[] nums) {
        int n;
        if(nums==null||(n = nums.length)<3) 
            return Collections.emptyList();
        
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0;i<n-2;i++){
            // 和前面一个数字重复的话，就不需要再进行查找了
            if(i>0&&nums[i]==nums[i-1]) continue;

            int p = i+1;
            int q = n-1;

            while(p<q){
                // 和前面一个数字重复的话，就不需要再进行查找了
                if (p > i + 1 && nums[p] == nums[p - 1]) {
                    ++p;
                    continue;
                }

                // 和前面一个数字重复的话，就不需要再进行查找了
                if (q < n - 1 && nums[q] == nums[q + 1]) {
                    --q;
                    continue;
                }

                if(nums[i]+nums[p]+nums[q]>0){
                    q--;
                }else if(nums[i]+nums[p]+nums[q]<0){
                    p++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[p],nums[q]));
                    // 正好为0的情况。现在同时向中间移动，寻找新的和为0的点。
                    p++;
                    q--;
                }
            }
        }
        return res;
    }
}