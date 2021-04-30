
/**
    请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
    例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */

/**
 * Java提供的位运算符有：左移( << )、右移( >> ) 、无符号右移( >>> ) 、位与( & ) 、位或( | )、位非( ~ )、位异或( ^ )，
 * 除了位非( ~ )是一元操作符外，其它的都是二元操作符。
 */

// n&1，判断最右边一位是否为1
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n!=0){
            res += n&1;
            n>>>=1;
        }
        return res;
    }
}

// n&(n-1)，会循环消去最右边的1
// n      = 10101000
//n-1     = 10100111
//n&(n-1) = 10100000
public class Solution2{
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n!=0){
            res++;
            n &= n-1;
        }
        return res;
    }
}