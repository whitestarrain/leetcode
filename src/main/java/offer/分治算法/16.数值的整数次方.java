/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * -2^31<n<2^31-1
 * 
 * 不需要考虑大数问题。
 */

// x可能为小数，n可能为负数
// 最简单的方法是n个x相乘，，时间复杂度为O(n)

/**
    快速幂法，O(logn)
    快速幂实际上是分治思想的一种应用。

    当n为偶数时。 x^n = (x^2)^(n//2)
    当n为奇数时。 x^n = (x^2)^(n//2) * x
                                    -----
                                    即：res 
    一直循环到n为0，不断向res中添加
    最后得到结果
 */
class Solution {
    public double myPow(double x, int n) {
        if(x==0.0d){
            return 0.0d;
        }
        long b = n;
        // 之所以使用long是为了避免-b=b时报错。
        // 因为 -2^31<n<2^31-1
        double res = 1.0;
        if(b<0){
            x = 1/x;
            b = -b;
        }
        while(b>0){
            if((b&1)==1) // 即 b%1 == 1
                res*=x;
            x*=x;
            b>>=1; // 即： n//=2
        }
        return res;
    }
}