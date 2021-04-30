/**
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */

/**
 * 双指针法
 */
class Solution {
    public int fib(int n) {
        int pre = 0;
        int cur = 1;
        int tmp;
        int i = 2;
        if(n<2){
            return n;
        }
        while(i<=n){
            tmp = pre;
            pre = cur;
            cur = (tmp+cur)%1000000007;
            i++;
        }
        return cur;
    }
}

/**
 * 动态规划
 
状态定义： 设 dp 为一维数组，其中 dp[i] 的值代表 斐波那契数列第 ii 个数字 。
转移方程： dp[i + 1] = dp[i] + dp[i - 1]，即对应数列定义 f(n + 1) = f(n) + f(n - 1)
初始状态： dp[0] = 0, dp[1] = 1 ，即初始化前两个数字；
返回值： dp[n] ，即斐波那契数列的第 nn 个数字。

由于 dp 列表第 i 项只与第 i−1 和第 i−2 项有关，因此只需要初始化三个整形变量 sum, a, b ，利用辅助变量 sum 使 a, b 两数字交替前进即可 （具体实现见代码） 。
节省了 dp 列表空间，因此空间复杂度降至 O(1)O(1) 。
 */
class Solution2{
    public int fib(int n){
        int a = 0,b=1;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;
    }
}
