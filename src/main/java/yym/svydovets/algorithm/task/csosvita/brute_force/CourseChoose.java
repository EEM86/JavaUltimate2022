package yym.svydovets.algorithm.task.csosvita.brute_force;

import org.apache.commons.lang3.NotImplementedException;

public class CourseChoose {

    /*
     * There are N specialities and M courses in the first input row.
     * Next n rows show either the course is in the speciality:
     * - Specialities where there are courses A and B
     * - Specialities where there is a course A but no course B
     * - Specialities where there is a course B but no course A
     * - Specialities where there are no courses A and B
     *
     * You have to print the max num of courses that can be chosen but this max amount
     * should be the minimum among all variants. What courses A and B should be chosen?
     *
     * Input 0:
     * 6 4
     * 0 0 0 1
     * 0 0 1 0
     * 0 1 1 1
     * 1 1 1 1
     * 0 0 0 0
     * 1 0 0 1
     * Output 0:
     * 2
     * 1 3
     * Explanation: If you choose courses #1 and #3, you will have such variants: {4}, {6}, {2,3}, {1,5}
     * 4 - the speciality with both courses A and B
     * 6 - the speciality where there is only A and no B
     * 2, 3 - the speciality where there is only B and no A
     * 1, 5 - the speciality without A and B courses
     */
    static String course(int[][] programs) {
        throw new NotImplementedException();
    }
}
