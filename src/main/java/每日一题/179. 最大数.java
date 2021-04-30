import java.util.Arrays;
import java.util.Comparator;

import sun.security.ssl.Alert;

/**
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。

注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */

/**
 * 自己实现快排
 * 发现使用swap会超出时间限制
 */
class Solution {
    public String largestNumber(int[] nums) {

        // 解决[0,0]情况
        boolean is0 = true;
        for(int i = nums;i<nums.length;i++){
            if(nums[i]>0){
                is0 = false;
                break;
            }
        }
        if(is0){return "0";}

        quickSort(nums, 0, nums.length-1); // 按照排序规则，从小到大排序
        StringBuilder sb = new StringBuilder();
        for (int i = nums.length-1; i >= 0 ; i--) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public void quickSort(int[] nums, int left ,int right){
        if(left>=right) return;
        int l = left;
        int r = right;
        while(l<r){
            while(l<r&&compare(nums[left], nums[r])) r--;
            while(l<r&&compare(nums[l],nums[left])) l++;
            swap(nums, r, l);
        }
        swap(nums,left,l);

        quickSort(nums, left, l-1);
        quickSort(nums,l+1, right);
    }

    /**
     * 比较两个数拼起来后，哪一个在前大。
     * 可以这样认知：如果a拼b 比 b拼a小，那么 a < b。
     * 如： 21<9。类似于字典序（但是不是）。
     * <br />
     * 实现方法：<br />
     * 将位数小的一个数，乘10 来 补0，补到位数相同，再进行比较
     * @param a 左边的数
     * @param b 右边的数
     * @return 如果 a拼b 比b拼a 小，那么就返回true
     */
    public  boolean compare(int a,int b){
        return (a+""+b).compareTo(b+""+a) < 0;
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * 快排，不使用swap
 */

class Solution {
    public boolean compare(int num1, int num2) {
        if (num1 == 0) return false;
        if (num2 == 0) return true;
        int num1bak = num1;
        int num2bak = num2;
        int num1Length = 0;
        int num2Length = 0;
        while (num1 > 0) {
            num1Length += 1;
            num1 /= 10;
        }
        while (num2 > 0) {
            num2Length += 1;
            num2 /= 10;
        }
        double n1 = num1bak * Math.pow(10, num2Length) + num2bak;
        double n2 = num2bak * Math.pow(10, num1Length) + num1bak;
        return n1 > n2;
    }

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
    public String largestNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < nums.length && nums[i] == 0) i++;
        while (i < nums.length) {
            sb.append(nums[i]);
            i++;
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}

/**
 * 内部api
 */
class Solution1 {
    public String largestNumber(int[] nums) {
        boolean is0 = true;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0){
                is0 = false;
                break;
            }
        }
        if(is0){return "0";}

        Integer[] integerArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArr, new IntComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = integerArr.length-1; i >= 0 ; i--) {
            sb.append(integerArr[i]);
        }
        return sb.toString();
    }

    public class IntComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b) {
            return (a+""+b).compareTo(b+""+a);
        }
    }

}


/**
 * 内部api 2
 */
class Solution2{
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }
}