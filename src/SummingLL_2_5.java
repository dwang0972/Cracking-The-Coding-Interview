import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by david on 1/3/2017.
 */
public class SummingLL_2_5 {
    public static void main(String[] args) {
//        LinkedList<Integer> num1 = new LinkedList<>(Arrays.asList(1, 2, 1));
//        LinkedList<Integer> num2 = new LinkedList<>(Arrays.asList(1, 1, 1));
//        System.out.println(num1.getFirst());
//        num1 = num1.

        LLNode<Integer> num1 = new LLNode<>(Arrays.asList(1));
        LLNode<Integer> num2 = new LLNode<>(Arrays.asList(9, 9, 9));
        sumLL(num1, num2);

    }

//    public static LinkedList<Integer> sumLL(LinkedList<Integer> num1, LinkedList<Integer> num2) {
//        num1.
//    }
    public static LLNode sumLL(LLNode<Integer> num1, LLNode<Integer> num2) {
        int carry = 0;
        int value = 0;
        LLNode<Integer> sum = new LLNode<>();
//        sum.next = new LLNode<Integer>();

        while (num1.next != null || num2.next != null) {
            if (num1.next == null) {
                System.out.println("num1 is null");
                System.out.println(carry);
                value = num2.data + carry;
                sum.data = (value) % 10;
                num2 = num2.next;
            } else if (num2.next == null) {
                value = num1.data + carry;
                sum.data = (value) % 10;
                num1 = num1.next;
            } else {
                System.out.println("running");
                value = num1.data + num2.data + carry;
                sum.data = (value) % 10;
                num1 = num1.next;
                num2 = num2.next;
            }

            carry = (value >= 10) ? 1 : 0;
            LLNode sumPointer = sum;
            sum = new LLNode<Integer>();
            sum.next = sumPointer;
        }

        if (carry == 1) {
            sum.data = 1;
        } else {
            sum = sum.next;
        }


        System.out.println(sum.toString());
        return sum;
    }
}
