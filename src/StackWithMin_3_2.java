import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by david on 1/6/2017.
 */
public class StackWithMin_3_2 extends Stack<Integer> {
    static Stack<Integer> minStack;
    static HashMap<Integer, Integer> minCopies;

    public static void main(String[] args) {
        StackWithMin_3_2 test = new StackWithMin_3_2();

    }

    public StackWithMin_3_2() {
        minStack = new Stack<>();
        minCopies = new HashMap<>();
    }

    public void push(int num) {
        super.push(num);
        
        if (minStack.empty()) {
            minStack.push(num);
            minCopies.put(num, 1);
        } else if (num < minStack.peek()) {
            minStack.push(num);
            minCopies.put(num, 1);

        //only update the count of minCopies if num is currently the min
        } else if (num == minStack.peek()) {
            int numCopies = minCopies.get(num);
            minCopies.replace(num, numCopies++);
        }
    }

    public Integer pop() {
        int popVal = 0;
        try {
            popVal = super.pop();
            int numCopies = minCopies.get(popVal);
            
            //checks if only one copy of current min value left
            //if so, pop it from minStack as well
            if (popVal == minStack.peek()) {
                minCopies.replace(popVal, --numCopies);
            }

            if (minCopies.get(popVal) == 0) {
                minCopies.remove(popVal);
                minStack.pop();
            }
        } catch (EmptyStackException es) {
            System.out.println("Trying to pop from a empty stack");
        }

        return popVal;
    }

    public int getMin() {
        return minStack.peek();
    }
}
