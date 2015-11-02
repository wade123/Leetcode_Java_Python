// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Integer peekElement;
    private Iterator iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            peekElement = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peekElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int result = peekElement;
        if (iterator.hasNext()) {
            peekElement = (Integer) iterator.next();
        } else {
            peekElement = null;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return this.peekElement != null;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        PeekingIterator iter = new PeekingIterator(list.iterator());
        System.out.println(iter.peek());
        System.out.println(iter.next());
        System.out.println(iter.peek());
        System.out.println(iter.next());
        System.out.println(iter.peek());
        System.out.println(iter.next());
    }
}