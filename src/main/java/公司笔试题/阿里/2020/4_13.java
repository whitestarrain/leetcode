import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 选动物老大，n个小动物，编号1-n,代表武力值，值越小，武力值越高，
 * 每个小动物都有一票投票权，可以投给自己或者自己崇拜的动物，或者和自己崇拜的动物跟票。只能崇拜武力值比自己厉害的动物
 */

class Question1 {
    public static void main(String[] args) {
        int[] t = new int[]{0, 1, 1, 1};
        int n = t.length;
        int[] ret = new int[n + 1];

        // 遍历第一遍，为崇拜对象投票
        for (int i = 0; i < n; i++) {
            if (t[i] != 0) {
                ret[t[i]] += 1;
            }
        }

        // 遍历第二遍，添加跟票
        for (int i = n - 1; i >= 0; i--) {
            // 因为0号位没用，所以要加个1

            if (t[i] != 0) {
                ret[t[i]] += ret[i + 1];
            }
        }

        // ! 可以优化，把第一个遍历改成从右往左，再把两个+=合起来。

        // 加上给自己投的票
        for (int i = 1; i < ret.length; i++) {
            ret[i] += 1;
        }

        System.out.println(Arrays.toString(ret));
    }
}


/**
n个城市n个人，每个城市一个人，选择一个城市x，所有人去那聚会，聚合结束所有人返回各自城市。
有m条单向路径，保证每个人可以到达城市x，一个人所消耗时间为往返时间和，每个人选择自己的最短路径，问最长的时间是多少。

输入：**第一行：n个城市，m个单向路数量，x是参加聚会的城市 4 8 2
后面m行：单向路起点 终点 花费的时间1 2 4；1 3 2；1 4 7；2 1 1；2 3 5；3 1 2；3 4 4；4 2 3；

输出：**花费时间最多的是多少 10（4到2 的时间为3；2回到4的时间是7：所以答案是10）
 */

class Solution2{
    public static void main(String[] args) {
        int n = 5;

        // 为了更易理解，0的那列不用了
        int[][] distance = new int[n+1][n+1];
        Scanner scan = new Scanner(System.in);

        for(int i = 1;i<n;i++){
            for(int j=1;j<n;j++){
                distance[i][j] =10000;
                if(i==j) distance[i][j] =0;
            }
        }
        for(int i = 0;i<n;i++){
            distance[scan.nextInt()][scan.nextInt()] = scan.nextInt();
        }

        int targetCity = scan.nextInt();

        // 生成点到点最短距离
        initMinMap(distance);

        // 计算到某一个城市来回的时间
        int distanceSum[] = new int[n];
        for(int i = 1;i<=n;i++){
            if(i!=targetCity)
                distanceSum[i] = distance[i][targetCity]+distance[targetCity][i];
        }

        System.out.println(max(distanceSum));
    }
    /**
     * 填充点到点间的最短距离
     * * 就是十分浪费空间和时间的  Dijkstra算法
     * 能不能算得上还得另说
     */
    public static void initMinMap(int[][] distance){
        int n = distance.length;

        for(int k = 1;k<=n;k++){
            for(int i = 1;k<=n;k++){
                for(int j = 1;k<=n;k++){
                    if(distance[i][j]>distance[i][k]+distance[k][j]){
                        distance[i][j]=distance[i][k]+distance[k][j];
                    }
                }
            }
        }
    }
    public static int max(int[] arr){
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
}
