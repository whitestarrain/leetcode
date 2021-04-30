import java.util.concurrent.ConcurrentHashMap;

/**
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */


// 基于快速排序的
// * 快速选择方法
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 第k大就是 排序后 index 为length-k的数
        quickSelect(nums, 0, nums.length-1,nums.length-k);
        return nums[nums.length-k];
    }

    /**
     * 
     * @param nums 数组
     * @param l 数组左边界
     * @param r 数组右边界
     * @param m 第k小的数，也就是排序后index为m的数
     * @return
     */
    public void quickSelect(int[] nums,int l,int r,int m){
        if(l>=r) return;
        int i = l;
        int j = r;

        // 根据当前哨兵进行排序
        while(i<j){
            while(i<j&&nums[j]>=nums[l]) j--; // 找到右侧小于哨兵的
            while(i<j&&nums[i]<=nums[l]) i++; // 找到左侧大于哨兵的
            swap(nums, i, j); // 进行交换
        }
        // 当前结果就是 【哨兵】【小于哨兵的】【大于哨兵的】 三段

        // 左哨兵和当前i位置处进行交换。(因为哨兵位于左侧)
        swap(nums, i, l);

        // 求第m小的数
        // i为当前哨兵所在index
        // 只对m所在的一侧进行排序
        if(m==i) return;
        if(m<i) quickSelect(nums, l, i-1, m);
        else quickSelect(nums, i+1, r, m);
    }
    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


// 构建堆进行排序
class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        } 
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        } 
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}