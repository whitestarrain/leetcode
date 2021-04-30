/**
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
 

说明：

用返回一个整数列表来代替打印
n 为正整数
 */

/**
 * 主要是要解决大叔越界问题。
 * 但是题目要求返回int[]，没有考到点上。
 * 具体解决看下面的Solution1
 */
class Solution {
    public int[] printNumbers(int n) {

    }
}

/**
 * 大数用字符串保存。
 * 所有的数，通过全排列的方式解决
 * 然后再删除高位的0.
 */
class Solution1 {
    StringBuilder res;
    char[] num;
    char[] loop = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    int count = 0;
    int n;

    public String printNumbers(int n) {
        this.n = n;
        this.res = new StringBuilder();// 用来存储结果 1,2,3,4,5.......格式
        this.num = new char[n]; // 长度为n的字符数组，用来临时存储结果。

        dfs(0);// 开始递归
        res.deleteCharAt(res.length()-1); // 删除多余逗号

        return res.toString();
    }

    /**
     * 为了提高速度，使用公用res。
     * 深度优先遍历，固定高位后，再选低位。
     * 
     * dfs(index)是固定index位。固定的结果存储在num中。
     */
    public void dfs(int index){
        if(index == n){ // 固定完所有位
            res.append(String.valueOf(this.num)+",");
            return;
        }

        for (int i = 0; i < this.n; i++) {
            num[index] = loop[i]; // 固定index位，n种可能
            dfs(x+1);
        }
    }
}


