package yym.svydovets.algorithm.task.csosvita.knapsack;

public class MatrixSearchTask {

    /*
     * There is a matrix with two properties:
     * 1. Each row is sorted in non-decreasing order.
     * 2. The first int of each row is greater than the last int of the previous row.
     * Given a target. Return 1 if target is in matrix or 0 otherwise.
     * You must write a solution in O(log(m * n)) time complexity.
     *
     * Sample Input 0:
     * 1  3  5  7
     * 10 11 16 20
     * 23 30 34 60
     *
     * Sample Output 0:
     * 1
     */
    public static int findTarget(int[][] matrix, int target) {
        int row = biSearchRow(matrix, target);
        if (row == -1) return 0;
        return binSearchCol(row, matrix, target);
    }

    private static int binSearchCol(int row, int[][] matrix, int target) {
        int bad = -1;
        int good = matrix[0].length;

        while (good - bad > 1) {
            int cand = (good + bad) / 2;
            if (isGoodCand(cand, row, matrix, target)) {
                good = cand;
            } else {
                bad = cand;
            }
        }
        return (good == matrix[0].length || matrix[row][good] != target) ? 0 : 1;
    }

    private static boolean isGoodCand(int cand, int row, int[][] matrix, int target) {
        return matrix[row][cand] >= target;
    }

    private static int biSearchRow(int[][] matrix, int target) {
        int lessTarget = -1;
        int greaterTarget = matrix.length;

        while (greaterTarget - lessTarget > 1) {
            int candidate = (greaterTarget + lessTarget) / 2;
            if (isLessTargetRow(candidate, matrix, target)) {
                lessTarget = candidate;
            } else {
                greaterTarget = candidate;
            }
        }
        return lessTarget;
    }

    private static boolean isLessTargetRow(int cand, int[][] matrix, int target) {
        return matrix[cand][0] <= target;
    }

}
