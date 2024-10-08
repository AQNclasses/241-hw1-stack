import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;


public class StackComputerTest {
    private StackComputer comp;
    private int DEFAULTSIZE = 5;

    @Before
    public void setup() {
        comp = new StackComputer(DEFAULTSIZE);
    }

    @Test
    public void testCreate() {
        assertTrue(comp != null);
        assertEquals(0, comp.size());
        int[] stack = comp.getStack();
        assertEquals(DEFAULTSIZE, stack.length);
        for (int i = 0; i < DEFAULTSIZE; i++) {
            assertEquals(0, stack[i]);
        }
    }

    @Test
    public void testPush() throws StackException {
        comp.push(42);
        int[] stack = comp.getStack();
        assertEquals(42, stack[0]);
        assertEquals(1, comp.size());
    }

    @Test
    public void testPop() throws StackException {
        comp.push(13);
        comp.push(42);
        assertEquals(42, comp.peek());
        assertEquals(42, comp.pop());
        assertEquals(1, comp.size());
    }

    @Test
    public void testAdd() throws StackException {
        comp.push(1);
        comp.push(42);
        comp.push(35);
        comp.add();
        assertEquals(2, comp.size());
        assertEquals(42 + 35, comp.peek());
    }

    @Test
    public void testSub() throws StackException {
        comp.push(1);
        comp.push(42);
        comp.push(35);
        comp.sub();
        assertEquals(2, comp.size());
        assertEquals(42 - 35, comp.peek());
    }

    @Test
    public void testMul() throws StackException {
        comp.push(13);
        comp.push(44);
        comp.mul();
        assertEquals(1, comp.size());
        assertEquals(13 * 44, comp.peek());
    }

    @Test
    public void testDiv() throws StackException {
        comp.push(44);
        comp.push(13);
        comp.div();
        assertEquals(1, comp.size());
        assertEquals(44 / 13, comp.peek());
    }

    @Test
    public void testGeneral() throws StackException {
        comp.push(2);
        comp.push(44);
        comp.push(13);
        comp.push(6);
        comp.div();

        int[] stack = comp.getStack();
        assertEquals(3, comp.size());
        assertEquals(2, stack[0]);
        assertEquals(44, stack[1]);
        assertEquals(13 / 6, stack[2]);

        comp.add();
        assertEquals(2, comp.size());
        assertEquals(13 / 6 + 44, comp.peek());
    }

    @Test
    public void testEmpty() {
        try {
            comp.peek();
            fail();
        } catch (StackException e) {
            // ok
        }

        try {
            comp.push(1);
            comp.div();
            fail();
        } catch (StackException e) {
            // ok
        }
    }
}
