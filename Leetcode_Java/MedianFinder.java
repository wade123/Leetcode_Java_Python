import java.util.*;

class MedianFinder {
    private Queue<Integer> leftHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });
    private Queue<Integer> rightHeap = new PriorityQueue<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (leftHeap.size() == rightHeap.size()) {
            if (leftHeap.isEmpty()) {
                leftHeap.offer(num);
            } else if (num <= rightHeap.peek()) {
                leftHeap.offer(num);
            } else {
                leftHeap.offer(rightHeap.poll());
                rightHeap.offer(num);
            }
        } else {
            if (num >= leftHeap.peek()) {
                rightHeap.offer(num);
            } else {
                rightHeap.offer(leftHeap.poll());
                leftHeap.offer(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int size = leftHeap.size() + rightHeap.size();
        if (size % 2 == 1) {
            return leftHeap.peek();
        } else {
            return (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
    }
}
// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();