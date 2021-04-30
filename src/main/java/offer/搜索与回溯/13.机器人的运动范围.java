import java.util.Arrays;

/**

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，
因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

示例 1：

输入：m = 2, n = 3, k = 1
输出：3
 */

class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m,n,0,0,k,visited);
    }
    public int dfs(int m,int n,int i,int j,int k,boolean[][] visited){
        // 越界返回0
        if(i<0||i>m-1||j<0||j>n-1) return 0;

        // 已访问过返回0
        if(visited[i][j]) return 0;
        visited[i][j] = true;

        // 必须要小于k
        int temp = i;
        int sum = 0;
        while(temp>0){
            sum+=temp%10;
            temp = temp/10;
        }
        temp = j;
        while(temp>0){
            sum+=temp%10;
            temp = temp/10;
        }
        if(sum>k) 
            return 0;

        // 可以继续往下走
        return 1+dfs(m,n,i+1,j,k,visited)+dfs(m,n,i-1,j,k,visited)+dfs(m,n,i,j+1,k,visited)+dfs(m,n,i,j-1,k,visited);
    }

}