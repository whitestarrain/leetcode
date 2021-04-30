import java.util.Arrays;

/**
夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。

商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。
Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。

给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。

注意：Tony 可以按任意顺序购买雪糕。
 */

/**
 * 动态规划
 * 超出内存限制
 */
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int[][] dp = new int[n][coins + 1];

        for (int j = 1; j <= coins; j++) {
            if (costs[0] <= j) dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <=coins; j++) {
                if (costs[i] <= j) {
                    dp[i][j] = Math.max(
                            dp[i - 1][j]
                            ,
                            1 + dp[i - 1][j - costs[i]]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][coins];
    }
}

class solution1{
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        for(int i = 0;i<costs.length;i++){
            sum+=costs[i];
            if(sum>=coins){
                return i;
            }
        }
        return 0;
    }
}