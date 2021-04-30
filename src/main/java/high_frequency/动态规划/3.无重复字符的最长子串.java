import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// 双指针
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int i = -1; // 左边界
        int res = 0; // 结果

        // j 是右边界
        // 计算 j-i 的最大值
        for(int j = 0;j<s.length();j++){
            // j 一直往右走
            // i 则是用来记录j对应字符的倒数第二次出现位置，以及最近出现的重复字符的右侧index
            // j-i 就是最长不重复字符
            if(map.keySet().contains(s.charAt(j)))
                i =  map.get(s.charAt(j));
            map.put(s.charAt(j), j);
            res = Math.max(res, j-i);
        }
    }
}

// 动态规划
// 实质上，状态转移方程和双指针逻辑一样。
/**
状态定义：设动态规划列表dp,dp[j]代表以字符s[j]为结尾的“最长不重复子字符串”的长度。
转移方程：固定右边界j,设字符s[j]左边距离最近的相同字符为s[i],即s[i]=s[j]。
1.当i<0,即s[j]左边无相同字符，则dp[j]=dp[j-1]+1;
2.当dplj-1]<j-i,说明字符s[i]在子字符串dp[j-1]区间之外，则dp[j=dp[j-1]+1;
3.当dplj-1]≥j-i,说明字符s[i]在子字符串dp[j-1]区间之中，则dpLj的左边界由s[i]决定，即 dplj]=j-i;
 */
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}

// 队列
class Solution2 {
    public int lengthOfLongestSubstring(String s) {

    }
}
