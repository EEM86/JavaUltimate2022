package yym.svydovets.algorithm.task.csosvita;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VykreslenniaTest {

    @Test
    void cutOut() {
        String input = "111111111110011111111";

        final int result = Vykreslennia.cutOut(input);
        assertEquals(4, result);
    }

    @Test
    void is5th() {
        int n = 999000;
        System.out.println(Vykreslennia.is5N(n));
    }

    @Test
    void hasDublicates() {
        int n = 123456789;
        System.out.println(Vykreslennia.hasDublicates(n));
    }

    @Test
    void numbers() {
        int n = 61;
        System.out.println(Vykreslennia.numbers(n));
    }


    @Test
    void numbers2() {
        int n = 3;
        System.out.println(Vykreslennia.numbers(n));
    }

    @Test
    void from0ToHero() {
        int first = 17469;
        int second = 5823;
        System.out.println(Vykreslennia.from0ToHero(first, second));
    }
}