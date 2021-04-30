/**
 * 统计一个数字在排序数组中出现的次数。
*/

class Solution {
    public int search(int[] nums, int target) {
        
        System.out.println(binarySearch(nums , target+1));
        System.out.println(binarySearch(nums , target));
        return binarySearch(nums , target+1)-binarySearch(nums, target);
    }
    public int binarySearch(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        int m;
        while(l<=r){
            m = (l+r)/2;
            if(target>nums[m]){
                l = m+1;
            }else{ // 等于的情况时，移动左侧指针，因此如果有多个数字相同的话，会指向那些数字的左边界
                    // 同理，也可以指向右边界
                r = m-1;
            }
        }
        return l;
    }
}