package yym.svydovets.algorithm.task.csosvita.search;

public class HowMany {

    /*
     * Sequential search and binary search represent a tradeoff
     * between search time and preprocessing time.
     * How many binary searches need be performed
     * in an 1.000.000.000 element array to buy back
     * the preprocessing time required to sort the array?
     *
     * n = 1_000_000_000
     *
     * Output Format
     * Print:
     * 1 if the number of binary searches is between 1 and 20,
     * 2 if the number of binary searches is between 21 and 40,
     * 3 if the number of binary searches is between 41 and 100.
     */
    public static int howMany() {
        int n = 1_000_000_000;
        int divisions = 0;
        while (n > 0) {
            n /= 2;
            divisions++;
        }
        if (divisions > 0 && divisions < 21) {
            return 1;
        } else if (divisions > 20 && divisions < 41) {
            return 2;
        } else {
            return 3;
        }
    }


/*
 * while (n log n * k log n >= k * n)
 *      k++
 */

}
