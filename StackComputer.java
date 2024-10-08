/**
 * Create a stack computer
 */
public class StackComputer {
    /**
     * Create a stack computer with a given maximum stack size
     */

    public int[] stack;
    public int top = 0;
    public int maxsize;

    public StackComputer(int maxsize) {
        stack = new int[maxsize];
        maxsize = maxsize;
    }

    /**
     * Return the array of ints that represents the stack
     */
    public int[] getStack() {
        return stack;
    }

    /**
     * Return the number of elements in the stack
     */
    public int size() {
        return top;
    }

    /**
     * Push a value on the stack. If stack full 
     * throw a StackException
     */
    public void push(int value) throws StackException {
        if (top+1 == maxsize) {
            throw new StackException("Stack is full");
        }
        else {
            stack[top] = value;
            top += 1;
        }

    }

    /**
     * Pop a value off the stack and return it. If the stack is empty
     * throw a StackException
     */
    public int pop() throws StackException {
        return 0;
    }

    /**
     * Peek at a value on the stack. Throw a StackException if the stack is
     * empty
     */
    public int peek() throws StackException {
        return 0;
    }

    /**
     * Pop two values off the stack, add them and push the result on the stack.
     * Throw a StackException if the stack is empty
     */
    public void add() throws StackException {
    }

    /**
     * Pop two values off the stack, subtract them and push the result on the
     * stack.
     * If arg1 is is below arg2 on the stack, then the result is arg1 - arg2.
     * Throw a StackException if the stack is empty.
     */
    public void sub() throws StackException {
    }

    /**
     * Pop two values off the stack, multiply them and push the result on the
     * stack.
     * Throw a StackException if the stack is empty
     */
    public void mul() throws StackException {
    }

    /**
     * Pop two values off the stack, divide them and push the result on the
     * stack.
     * If arg1 is is below arg2 on the stack, then the result is arg1 / arg2.
     * Throw a StackException if the stack is empty
     */
    public void div() throws StackException {
    }

    public static void main(String[] args) throws StackException {
        StackComputer comp = new StackComputer(5);
        comp.push(5);
        comp.push(10);
        comp.push(3);
        
        System.out.println(comp.size());     // should be 3

        comp.mul();
        System.out.println(comp.peek());     // should be 30

        comp.sub();
        System.out.println(comp.pop());      // should be -25
    }
}
