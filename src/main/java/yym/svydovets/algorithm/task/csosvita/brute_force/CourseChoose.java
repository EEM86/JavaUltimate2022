package yym.svydovets.algorithm.task.csosvita.brute_force;

import java.util.Arrays;
import java.util.Scanner;

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
    static String course(int n, int m, int[][] programs) {

        // Initialize variables for tracking minimum maximum set size and optimal courses
        int minMaxSetSize = n + 1;
        int optimalCourseA = 0, optimalCourseB = 0;

        // Iterate through each pair of courses
        for (int a = 0; a < m; a++) {
            for (int b = a + 1; b < m; b++) {
                int sz = largestGroupSize(programs, a, b);

                // Update if a smaller maximum set size is found
                if (minMaxSetSize > sz) {
                    minMaxSetSize = sz;
                    optimalCourseA = a + 1;
                    optimalCourseB = b + 1;
                }
            }
        }
        return minMaxSetSize + "\n" + optimalCourseA + " " + optimalCourseB;
    }

        // Method to find the largest group size for a given pair of courses
        public static int largestGroupSize(int[][] programs, int a, int b) {
            int[] sets = new int[4];

            // Count each group based on the values at programs[i][a] and programs[i][b]
            for (int[] p : programs) {
                if (p[a] == 1 && p[b] == 1) {
                    sets[0]++;
                } else if (p[a] == 1 && p[b] == 0) {
                    sets[1]++;
                } else if (p[a] == 0 && p[b] == 1) {
                    sets[2]++;
                } else {
                    sets[3]++;
                }
            }

            // Return the maximum count among the four groups
            return Arrays.stream(sets).max().getAsInt();
        }

    static void courseNotPass(int[][] arr) {
        int maxMin = arr.length + 1;
        int[] courses = new int[2];
        int res1 = 0;
        int res2 = 0;
        int res3 = 0;
        int res4 = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {

                int l = 0, r = j;
                int x = 0;
                while (x < arr.length) {
                    if (arr[x][l] == 1 && arr[x][r] == 1) {
                        res1++;
                    }
                    if (arr[x][l] == 0 && arr[x][r] == 1) {
                        res2++;
                    }
                    if (arr[x][l] == 1 && arr[x][r] == 0) {
                        res3++;
                    }
                    if (arr[x][l] == 0 && arr[x][r] == 0) {
                        res4++;
                    }
                    x++;
                }
                int a = Math.max(res1, res2);
                int b = Math.max(res3, res4);
                int res = Math.max(a, b);
                if (res < maxMin) {
                    maxMin = res;
                    courses[0] = i;
                    courses[1] = r;
                }
                res1 = 0;
                res2 = 0;
                res3 = 0;
                res4 = 0;
            }

        }
        System.out.println(maxMin);
        System.out.println(courses[0] + 1 + " " + courses[1] + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];

        int row = 0;
        while(sc.hasNext()) {
            for (int col = 0; col < cols; col++) {
                int num = sc.nextInt();
                arr[row][col] = num;
            }
            row++;
        }
        course(rows, cols, arr);

    }

}
