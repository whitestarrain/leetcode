/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */


import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class CQueue {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    public CQueue() {
        this.stack1 = new LinkedList<Integer>();
        this.stack2 = new LinkedList<Integer>();
    }
    
    public void appendTail(int value) {
        stack1.addLast(value);
    }
    
    // stack2删完了，再把stack1中的放到stack2中
    public int deleteHead() {
        if(!stack2.isEmpty()) return stack2.removeLast();
        if(stack1.isEmpty()) return -1;
        while(!stack1.isEmpty()) stack2.addLast(stack1.removeLast());
        return stack2.removeLast();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */