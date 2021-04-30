import java.util.LinkedList;

/**
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */


/**
 * 这个是思路，有些冗余
 * 下面那个是Solution1是整理好的代码
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0&&popped.length==0){
            return true;
        }
        if(pushed.length!=popped.length){
            return false;
        }

        int push = 0;
        int pop = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        // 先进行压栈，直到压入pop出的第一个值
        while(pushed[push]!=popped[pop]){
            stack.push(pushed[push]);
            push++;
        }

        // 然后pop出第一个值。
        // 上面没有压入，也就相当于压入后又pop了
        // 开始找下一个pop的值
        pop++;

        while(pop<popped.length){
            // 检查栈顶是否为要pop出的下一个值，如果是就pop，如果不是就继续压栈。
            if(stack.peek()!=popped[pop]){
                push++;
                if(push>=pushed.length){
                    return false;
                }
                stack.push(pushed[push]);
            }else{
                stack.pop();
                pop++;
            }
        }

        System.out.println(stack);
        return stack.isEmpty();
    }
}


/**
 * 把前半部分整合了
 */
class Solution1 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0&&popped.length==0){
            return true;
        }
        if(pushed.length!=popped.length){
            return false;
        }

        int push = 0;
        int pop = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        while(pop<popped.length){
            // 检查栈顶是否为要pop出的下一个值，如果是就pop，如果不是就继续压栈。
            if(stack.isEmpty()||stack.peek()!=popped[pop]){
                if(push>=pushed.length){
                    return false;
                }
                stack.push(pushed[push]);
                push++;
            }else{
                stack.pop();
                pop++;
            }
        }
        return stack.isEmpty();
    }
}