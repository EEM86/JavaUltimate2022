package yym.svydovets.algorithm.task.csosvita.dymanic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.Test;

class WordBrakeTaskTest {

    @Test
    void isWordBrake1() {
        String s = "csosvita";
        String[] dict = new String[2];
        dict[0] = "cs";
        dict[1] = "osvita";

        final int result = WordBrakeTask.isWordBrake(s, dict);
        assertEquals(1, result);
    }

    @Test
    void isWordBrake2() {
        String s = "applepenapple";
        String[] dict = new String[2];
        dict[0] = "apple";
        dict[1] = "pen";

        final int result = WordBrakeTask.isWordBrake(s, dict);
        assertEquals(1, result);
    }

    @Test
    void isWordBrake3() {
        String s = "applepen";
        String[] dict = new String[2];
        dict[0] = "apple";
        dict[1] = "pec";

        final int result = WordBrakeTask.isWordBrake(s, dict);
        assertEquals(0, result);
    }

    @Test
    void isWordBrake4() {
        String s = "applepen";
        String[] dict = new String[2];
        dict[0] = "apple";
        dict[1] = "pencil";

        final int result = WordBrakeTask.isWordBrake(s, dict);
        assertEquals(0, result);
    }

    @Test
    void isWordBrake5() {
        String s = "applepencil";
        String[] dict = new String[2];
        dict[0] = "apple";
        dict[1] = "pen";

        final int result = WordBrakeTask.isWordBrake(s, dict);
        assertEquals(0, result);
    }

    @Test
    void isWordBrake6() {
        String s = "apppen";
        String[] dict = new String[2];
        dict[0] = "apple";
        dict[1] = "pen";

        final int result = WordBrakeTask.isWordBrake(s, dict);
        assertEquals(0, result);
    }

    @Test
    void isWordBrake7() {
        String s = "catsandog";
        String[] dict = new String[] {
            "cats",
            "dog",
            "sand",
            "and",
            "cat"
        };

        final int result = WordBrakeTask.isWordBrake(s, dict);
        assertEquals(0, result);
    }

}