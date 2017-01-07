import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;


/**
 * Created by david on 1/3/2017.
 */
public class LLNode<T> implements Iterable {
    T data;
    LLNode next;

    @Override
    public Iterator iterator() {
        return new LLNiterator();
    }

    public LLNode() {
        next = null;
    }

    public LLNode(T data) {
        this.data = data;
        next = null;
    }

    public LLNode(Collection<T> c) {
        next = null;
        LLNode start = this;
        for (T obj: c) {
            start.data = obj;
            start.next = new LLNode();
            start = start.next;
        }

        start = null;

    }

    @Override
    public String toString() {
//        Iterator<LLNode> LLNiterator = new Iterator<LLNode>();
        StringBuffer toString = new StringBuffer();
        toString.append("[");
//        for (Object node: this) {
//
//            toString.append(((LLNode) node).data);
//            toString.append(", ");
//        }
        LLNode startLLN = this;
        while (startLLN != null) {
            toString.append(startLLN.data.toString());
            toString.append(", ");
            startLLN = startLLN.next;
        }

        toString.append("]");
        return toString.toString();
    }

    public class LLNiterator implements Iterator {
        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public LLNode next() {
            return next;
        }
    }

}
