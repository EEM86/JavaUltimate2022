package yym.svydovets.algorithm.task.csosvita.brute_force;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import yym.svydovets.algorithm.task.csosvita.brute_force.Vykreslennia;

class VykreslenniaTest {

    @Test
    void cutOutOptimal() {
        String input = "1111";

        final int result = Vykreslennia.cutOutOptimal(input);
        assertEquals(1, result);
    }

    @Test
    void cutOut2() {
        String input = "0";

        final int result = Vykreslennia.cutOutOptimal(input);
        assertEquals(0, result);
    }

    @Test
    void cutOut3() {
        String input = "123";

        final int result = Vykreslennia.cutOutOptimal(input);
        assertEquals(1, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "101010", "111111111110011111111"})
    void cutOut4(String input) {
        final int result = Vykreslennia.cutOutOptimal(input);
        assertEquals(4, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "13579", "333222111"})
    void cutOut5(String input) {
        final int result = Vykreslennia.cutOutOptimal(input);
        assertEquals(10, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "987654321"})
    void cutOut6(String input) {
        final int result = Vykreslennia.cutOutOptimal(input);
        assertEquals(84, result);
    }

    @Test
    void cutOut7() {
        String input = "123456789";

        final int result = Vykreslennia.cutOutOptimal(input);
        assertEquals(84, result);
    }

}