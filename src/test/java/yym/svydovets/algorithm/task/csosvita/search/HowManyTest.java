package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.sort.HowMany;

class HowManyTest {

    @Test
    void howMany() {

        final int result = HowMany.howMany();
        assertEquals(2, result);
    }
}