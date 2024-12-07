package yym.svydovets.algorithm.task.csosvita.search_loopy;

import org.apache.commons.lang3.NotImplementedException;

public class Garland {

    /*
     * The New Year garland consists of N lamps attached to a common wire that hangs
     * down on the ends to which outermost lamps are affixed.
     * The wire sags under the weight of lamp in a particular way:
     * each lamp is hanging at the height that is 1 millimeter lower than the average height
     * of the two adjacent lamps.
     *
     * The leftmost lamp is hanging at the height of A millimeters above the ground.
     * You have to determine the lowest height B of the rightmost lamp so that no lamp
     * in the garland lies on the ground though some of them may touch the ground.
     *
     * You shall neglect the lamp's size in this problem.
     * By numbering the lamps with integers from 1 to N and denoting i-th lamp height
     * in millimeters as H-i we derive the following equations:
     * H_1 = A
     * H_1 = (H_{i-1} + H_{i-1}) / 2 - 1, for all 1 < i < N
     * H_n = B
     * H_i >= 0, for all 1 <= i <= N
     * The sample garland with 8 lamps that is shown on the picture has A = 15 and B = 9,75.
     *
     * |15     o A
     * |14      \
     * |13       \
     * |12        \
     * |11         |
     * |10         |
     * |9          |                 o B
     * |8          o                /
     * |7          \               /
     * |6           \             /
     * |5            \           /
     * |4             \         /
     * |3              o       /
     * |2               \     /
     * |1                \   /
     * |0_________________\o/______________________________________
     *
     * 3<= N <= 1000
     * 10 <= A <= 1000
     *
     * The input contains of int N and real number A, space separated.
     * Output - the single number B the lowest possible height of the rightmost lamp.
     * Your answer must be within 0.005 absolute error of the actual result.
     *
     * Sample Input 0:
     * 8 15
     * Sample Output 0:
     * 9.75
     */
    public static double binarySearchLampHeight(int n, double a) {
        throw new NotImplementedException();
    }
}
