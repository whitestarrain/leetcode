
/**

给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

提示：

num1 和num2 的长度都小于 5100
num1 和num2 都只包含数字 0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */

/**
 * 模拟普通计算
 */
class Solution {
    public String addStrings(String num1, String num2) {
        if(num1==null||num1.length()==0){
            return num2;
        }
        if(num2==null||num2.length()==0){
            return num1;
        }

        StringBuilder sb = new StringBuilder();
        String numLong;
        String numShort;
        if(num1.length()<num2.length()){
            for(int i = 0;i<num2.length()-num1.length();i++){
                sb.append("0");
            }
            sb.append(num1);
            numShort = sb.toString();
            numLong = num2;

            sb.delete(0,sb.length());
        }else{
            for(int i = 0;i<num1.length()-num2.length();i++){
                sb.append("0");
            }
            sb.append(num2);
            numShort = sb.toString();
            numLong = num1;

            sb.delete(0,sb.length());
        }

        int carry = 0; // 进位

        for(int i = numLong.length()-1;i>=0;i--){
            int n1 = Integer.parseInt(numShort.substring(i,i+1));
            int n2 = Integer.parseInt(numLong.substring(i,i+1));
            int r = n1+n2+carry;
            sb.append(r%10);
            carry = r/10;
        }
        if(carry>0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

/**
 * 双指针
 * 原理和上面的一样
 * 只不过优化了许多，没有补0
 */

class Solution1{
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }
}