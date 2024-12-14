package yym.svydovets.algorithm.task.csosvita.data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdvancedStackTest {

    @Test
    void testStack1() {
        final AdvancedStack stack = new AdvancedStack();
        var sb = new StringBuilder();
        stack.push(97);
        stack.pop();
        stack.push(20);
        stack.pop();
        stack.push(26);
        stack.push(20);
        stack.pop();
        sb.append(stack.getMax()).append("\n");
        stack.push(91);
        sb.append(stack.getMax()).append("\n");
        assertEquals("26\n91\n", sb.toString());
    }

    @Test
    void testStack2() {
        final AdvancedStack stack = new AdvancedStack();
        stack.push((int) Math.pow(10, 9));
        stack.push(2);
        stack.push(1_999_999);
        assertEquals(1000000000, stack.getMax());
    }

}