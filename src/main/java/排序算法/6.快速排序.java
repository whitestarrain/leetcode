/**
 * 使用最左侧的值为哨兵
 */
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int left,int right){
        if(left>=right) return;
        int i = left;
        int j = right;
        while(i<j){
            while(i<j&&nums[j]>=nums[left]) j--;
            while(i<j&&nums[i]<=nums[left]) i++;
            swap(nums,i,j);
        }
        swap(nums,i,left);
        quickSort(nums, left, i-1);
        quickSort(nums,i+1, right);
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * 不使用swap
 */
class Solution2{
    public void quickSort(int[] nums, int i, int j) {
        if (i >= j) return;
        int left = i, right = j;
        int tmp = nums[i];
        while (i < j) {
            while (i < j && compare(tmp, nums[j])) j--;
            nums[i] = nums[j];
            while (i < j && !compare(tmp, nums[i])) i++;
            nums[j] = nums[i];
        }
        nums[i] = tmp;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}

/**
 * 使用随机数为哨兵
 */
class Solution1{

}