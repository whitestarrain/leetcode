// 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(Character i:s.toCharArray()){
            if(i==' '){
                sb.append("%20");
            }else{
                sb.append(i);
            }
        }
        return sb.toString();
    }
}