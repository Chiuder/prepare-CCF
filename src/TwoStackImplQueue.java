import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-14 20:04
 */
public class TwoStackImplQueue {
    Deque<Integer> inStack = new ArrayDeque<>();
    Deque<Integer> outStack = new ArrayDeque<>();

    public TwoStackImplQueue() {

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty())
            in2out();
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty())
            in2out();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out(){
        while (!inStack.isEmpty())
            outStack.push(inStack.pop());
    }

}
