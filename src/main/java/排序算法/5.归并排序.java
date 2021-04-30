/**
 * offer/分治算法/51 中有merge方法的超简化方式
 */

/**
 * 归并排序
 */
class Solution {
    int[] nums;
    int[] temp;

    public int[] sortArray(int[] nums) {
        this.nums = nums;
        this.temp = new int[nums.length];
        mergeSort(0,nums.length-1);
        return nums;
    }

    public void mergeSort(int left,int right){
        if(left>=right) return;
        int m = (left+right)/2;
        mergeSort(left, m);  // 左边归并排序，使得子序列有序
        mergeSort(m+1, right);  // 右边归并排序，使得子序列有序 

        // 将两个子序列归并起来
        merge(left,m,right,temp);
    }

    public void merge(int l,int m,int r,int[] temp){
        int i = l;// 左序列指针
        int j = m+1; // 右序列指针
        int t = 0; // 临时序列指针

        //左右两个序列，小的在左，放到temp中
        while(i<=m&&j<=r){
            if(nums[i]<=nums[j]){
                temp[t++] =nums[i++];
            }else{
                temp[t++] =nums[j++];
            }
        }

        // 之后可能有一个剩下
        // 如果左序列剩下了
        while(i<=m){
            temp[t++] = nums[i++];
        }

        // 如果右序列剩下了
        while(j<=r){
            temp[t++] = nums[j++];
        }

        // 将排好序的部分拷贝到原数组中
        t=0;
        while(l<=r){
            nums[l++] = temp[t++];
        }
    }
}