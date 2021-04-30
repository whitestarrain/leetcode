/**

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

示例 1:
    输入: [7,5,6,4]
    输出: 5

限制：0 <= 数组长度 <= 50000
 */

/**
 * 最基本的遍历方式
 * 超出时间限制
 */
class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    count++;
                }
            }
        }

        return count;
    }
}

/**
 * * 归并排序，
 * 很容易理解
 */
class Solution1 {
    int[] nums;
    int[] temp;
    int count=0;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        this.temp = new int[nums.length];
        mergeSort(0,nums.length-1);
        return count;
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
                count+=m-i+1;    // ! 注意，与普通的归并排序相比只多了这一行。
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



/**
 * 归并排序，对merge方法进行超简化。
 */
class Solution2{
    int[] nums, tmp;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }
    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;

        // 把要合并的数放到temp数组中
        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];
        
        // 归并
        // 归并的超简化写法，看不懂看    排序算法/归并排序.java
        for (int k = l; k <= r; k++) {
            if (i == m + 1)  // 如果i==m+1，说明左侧序列已经归并完了，把右侧归并了就行
                nums[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])  // 如果j==r+1说明，右侧已经归并完了，把左侧进行归并就行了。或者tmp[i]<=tmp[j]的。应该
                nums[k] = tmp[i++];
            else { // 也就是右序列还没排完，并且右序列较小，左序列较大的情况。
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }
}