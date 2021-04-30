import java.lang.reflect.Array;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/**
请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

注意：

".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 */

/**
 * 解体思路：正则规划，求s[:n]与p[:m]是否匹配。
 * 
 * 需要注意，由于 dp[0][0] 代表的是空字符的状态， 因此 dp[i][j] 对应的添加字符是 s[i - 1] 和 p[j - 1] 
 */

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length()+1;
        int n = p.length()+1;

        // 创建状态转移矩阵，n*m，用来保存s[:m]，p[:n]是否可以匹配
        boolean[][] dp = new boolean[m][n];

        // 接下来会一行一行地扫

        // 初始化第一行第一个
        dp[0][0] = true; // 两个空字符串可以匹配成功
        
        // 第一行第二个，对应正则的第一个字符。
        // 因为此时字符串为空串，正则一开始不可能为*,而为字符或者.都会导致匹配为False
        // 也就是说第一行第二列肯定是false

        // 第一行剩余其他
        for(int j = 2;j<n;j+=2) 
            dp[0][j]=dp[0][j-2] && p.charAt(j-1)=='*'; // 只要是 字符+* ,就可以作为空字符串，因此就能为true。因此不需要一个一个的来，右移两个

        // 剩下的所有行
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){  // 从1开始是因为，如果正则为空串，匹配任何字符都是false
                if(p.charAt(j-1)=='*'){// 当当前字符为*时。
                    // 字符+* 相当于空字符串。只要前前一个为true，这里也能为true。即让字符p[j-2]不出现，能否匹配
                    if(dp[i][j-2]) dp[i][j] = true;  

                    // 当s[:i-2]与p[:j-1]匹配时，此时如果再给s[:i-2]填一个字符，添的字符如果等于p[j-2]，那么匹配成功
                    // 即*让字符 p[j - 2] 多出现 1 次时，能否匹配；
                    else if(dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) dp[i][j] = true; // 2.

                    // 当s[:i-2]与p[:j-1]匹配时。如果p[j-1]为*，前一个字符为.，那么能匹配成功。
                    // 此处的.*对应的是多个.。比如ab和.*可以匹配成功。 ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
                    else if(dp[i - 1][j] && p.charAt(j - 2) == '.') dp[i][j] = true;             // 3.
                }else{
                    // 下面两个都比较好理解。如果s[:i-2]与p[:j-2]匹配成功。那么只要s[i-1]和p[j-1]匹配成功也行。
                    if(dp[i-1][j-1]&&s.charAt(i-1)==p.charAt(j-1)) dp[i][j] = true;
                    else if(dp[i-1][j-1]&&p.charAt(j-1)=='.') dp[i][j] = true;
                }
            }
        }

        return dp[m-1][n-1];
    }
}

/**
aaa与ab*.*匹配示例

        a   b   *   .   *
    1   0   0   0   0   0
a   0   1   0   1   0   1
a   0   0   0   0   1   1
a   0   0   0   0   0   1
 */