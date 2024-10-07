/**
 * Create a stack computer
 */
// note for self: having issues with "make run"
// instead test program by inputting: java -cp . StackComputer in WSL terminal  

	
public class StackComputer {
    /**
     * Create a stack computer with a given maximum stack size
     */

    public int[] stack;
    public int top = 0;
    public int maxsize;

    public StackComputer(int maxsize) {
        stack = new int[maxsize];
        this.maxsize = maxsize;
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
        if (top <= 0) {
            throw new StackException("Stack is empty");

        }

        top--;
        return stack[top];
    }

    /**
     * Peek at a value on the stack. Throw a StackException if the stack is
     * empty
     */
    public int peek() throws StackException {
        if (top <= 0) {
            throw new StackException("stack is empty");

        }
        return stack[top-1];
    }

    /**
     * Pop two values off the stack, add them and push the result on the stack.
     * Throw a StackException if the stack is empty
     */
    public void add() throws StackException {
        if (top < 1) {
            throw new StackException("Not enough in stack");
        }
        int value1 = pop();
        int value2 = pop();
        push(value1 + value2);
    }

    /**
     * Pop two values off the stack, subtract them and push the result on the
     * stack.
     * If arg1 is is below arg2 on the stack, then the result is arg1 - arg2.
     * Throw a StackException if the stack is empty.
     */
    public void sub() throws StackException {
        if (top < 1) {
            throw new StackException("Nopt enough in stack");
        }
        int value1 =  pop();
        int value2 = pop();
        int result = value2 - value1;
        push(result);

    }

    /**
     * Pop two values off the stack, multiply them and push the result on the
     * stack.
     * Throw a StackException if the stack is empty
     */
    public void mul() throws StackException {
        if (top < 1) {
            throw new StackException("Not enough in stack");
        }
        int value1 =  pop();
        int value2 = pop();
        int result = value1 * value2;
        push(result);
    }

    /**
     * Pop two values off the stack, divide them and push the result on the
     * stack.
     * If arg1 is is below arg2 on the stack, then the result is arg1 / arg2.
     * Throw a StackException if the stack is empty
     */
    public void div() throws StackException {
        if (top < 2) {
            throw new StackException("Not enough in stack");
        }
        int value1 =  pop();
        int value2 = pop();
        if (value1 == 0) {
            throw new ArithmeticException("Can't divide by zero");
        }
        int result = value2 / value1;
        push(result);
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
        //testing and committing to main
    }
}
