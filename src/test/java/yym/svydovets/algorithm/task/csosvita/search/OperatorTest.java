package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.sort.Operator;

class OperatorTest {

    @Test
     void testCountOperator() {
        int[] clients = new int[]{0,2,0,2,3,1};

        var operator = new Operator(clients);

        assertEquals(5, operator.sum(2,4));

        operator.inc(2);
        operator.decr(1);

        assertEquals(6, operator.sum(2, 4));

        operator.decr(5);

        assertEquals(3, operator.sum(4,5));
        assertEquals(2, operator.sum(1,2));

        operator.inc(2);

        assertEquals(3, operator.sum(1,2));
    }

}