import java.util.Queue;

/**

如何得到一个数据流中的中位数？
如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例 1：

输入：
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
输出：[null,null,null,1.50000,null,2.00000]

*/


/**
 * 解体思路是使用两个堆
 * 左边一个大堆：保存较小的一半的数
 * 右边一个小堆：保存较大的一半的数
 * 
 * 堆可以使用java提供的PriorityQueue构建
 */
class MedianFinder {
    Queue<Integer> q1,q2;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.q1 = new PriorityQueue<Integer>((x,y)->y-x);  // 大堆
        this.q2 = new PriorityQueue<Integer>();  // 小堆
        // 使用lambda表达式实现 compartor
    }
    
    public void addNum(int num) {
        int q1Size = q1.size();
        int q2Size = q2.size();

        // 计划左边大堆比右边小堆size大1或者size相同。
        // size相同时，中位数就是两个堆顶元素相加除2
        // size不同时，左边大堆size要比小堆大1，中位数就是左边大堆的堆顶元素

        if(q1Size==q2Size){
            // q1和q2 大小相同，把新来的数放到左边，但是不确定新来的数是否比右边的小堆中的数小，
            // 所以先添加到右边的小堆，再poll出最小的树添加到左堆。
            q2.add(num);
            q1.add(q2.poll());
        }else{
            // q1 和q2 大小不同，也就是q1比q2多一个的时候
            // 把大堆中的最大数拿出来，放到小堆中
            q1.add(num);
            q2.add(q1.poll());
        }
    }
    
    public double findMedian() {
        if(q1.size()==q2.size()) return (float)(q1.peek()+q2.peek())/2;
        else return q1.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */