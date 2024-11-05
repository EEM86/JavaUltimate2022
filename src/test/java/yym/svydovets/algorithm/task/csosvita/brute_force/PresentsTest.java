package yym.svydovets.algorithm.task.csosvita.brute_force;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import yym.svydovets.algorithm.task.csosvita.brute_force.Presents;

class PresentsTest {

    @ParameterizedTest
    @MethodSource("arrayProvider7")
    void presents7(int[] input) {
        final int presentsOsvita = Presents.presentsOsvita(input);
        assertEquals(7, presentsOsvita);
    }

    @ParameterizedTest
    @MethodSource("arrayProvider3")
    void presents3(int[] input) {
        final int presentsOsvita = Presents.presentsOsvita(input);
        assertEquals(3, presentsOsvita);
    }

    static Stream<int[]> arrayProvider7() {
        int[] second = new int[]{1,2,3,6};
        return Stream.of(
            second);
    }

    static Stream<int[]> arrayProvider3() {
        int[] first = new int[]{2,5,10,12};
        int[] second = new int[]{5,7,10,25};
        int[] third = new int[]{1,1,1,1};
        return Stream.of(first, second, third);
    }

    @Test
    void presents2() {
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;

        final int presentsOsvita = Presents.presentsOsvita(new int[]{a, b, c, d});
        assertEquals(4, presentsOsvita);
    }

    @Test
    void presents3() {
        int a = 1;
        int b = 4;
        int c = 5;
        int d = 10;

        final int presentsOsvita = Presents.presentsOsvita(new int[]{a, b, c, d});
        assertEquals(6, presentsOsvita);
    }



    @Test
    void presents6() {
        int a = 50;
        int b = 30;
        int c = 20;
        int d = 100;

        final int presentsOsvita = Presents.presentsOsvita(new int[]{a, b, c, d});
        assertEquals(4, presentsOsvita);
    }

    @Test
    void presents7() {
        int a = 1;
        int b = 5;
        int c = 7;
        int d = 10;

        final int presentsOsvita = Presents.presentsOsvita(new int[]{a, b, c, d});
        assertEquals(4, presentsOsvita);
    }

    @Test
    void presents4() {
        int a = 2;
        int b = 3;
        int c = 7;
        int d = 12;

        final int presentsOsvita = Presents.presentsOsvita(new int[]{a, b, c, d});
        assertEquals(4, presentsOsvita);
    }

    @Test
    void presents5() {
        int a = 1;
        int b = 1;
        int c = 1;
        int d = 1000;

        final int presentsOsvita = Presents.presentsOsvita(new int[]{a, b, c, d});
        assertEquals(501501, presentsOsvita);
    }

    @Test
    void presents8() {
        int a = 100;
        int b = 100;
        int c = 100;
        int d = 1000;

        final int presentsOsvita = Presents.presentsOsvita(new int[]{a, b, c, d});
        assertEquals(66, presentsOsvita);
    }
}
