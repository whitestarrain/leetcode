import java.util.Arrays;

/**
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */



/**
 * 使用快排
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length-1);
        return Arrays.copyOf(arr, k);
    }
    /**
     * @param arr 要排序的数组
     * @param l 要排序部分的左端index，arr[l]也就是哨兵
     * @param r 要排序部分的右端index
     */
    private void quickSort(int[] arr,int l,int r){
        if (l >= r) return;
        int i = l;
        int j = r;
        while(i<j){
            while(i<j&&arr[j]>=arr[l]) j--; // 找到右侧小于哨兵的
            while(i<j&&arr[i]<=arr[l]) i++; // 找到左侧大于哨兵的
            swap(arr, i, j); // 进行交换
        }

        // 左哨兵和当前i位置处进行交换。(因为哨兵位于左侧)
        swap(arr, i, l);

        // 交换位置后的哨兵把数组分为两段。两端继续快排
        quickSort(arr, l, i-1);
        quickSort(arr, i+1, r);
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // 为何不行？？？？
        // arr[i] = arr[i] ^ arr[j];
        // arr[j] = arr[i] ^ arr[j];
        // arr[i] = arr[i] ^ arr[j];
    }
}

