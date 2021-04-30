/**
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 */

/**
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0 ;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board, word.toCharArray(), i, j,0)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word,int i,int j,int k){
        // 越界或者不匹配的情况返回false
        if(i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=word[k]) return false;

        if(k==word.length-1) return true; // 最后如果匹配完成，就会返回true
        board[i][j] = '\0';  // 暂时设置为空字符串，为了防止之后四个方向开启递归时的重复遍历

        // 四个方向开启递归
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || 
                        dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);

        // 回溯过程中还原
        board[i][j] = word[k];
        return res;
    }
}