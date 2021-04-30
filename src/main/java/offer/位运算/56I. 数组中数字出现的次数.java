/**
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */

/**
题目要求时间复杂度 O(N)O(N) ，空间复杂度 O(1)O(1) ，因此首先排除 暴力法 和 哈希表统计法 。
 */

/**
 * a⊕a=0 
 * 因此，若将 numsnums 中所有数字执行异或运算，留下的结果则为 出现一次的数字
 * 但因为有两个只出现一次的数字。
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        int x=0,y=0,n=0,m=1;
        for(int num:nums){
            n^=num;
        }
        
        // 找到两个只出现一次的数的二进制中，从右到左第一位不一样的位置
        while((n&m)==0){
            m<<=1;
        }

        // 根据那个位置将整个数组分为两份。
        for(int num:nums){
            if((num&m)==0) x^=num;
            else y^=num;
        }
        return new int[]{x,y};
    }
}