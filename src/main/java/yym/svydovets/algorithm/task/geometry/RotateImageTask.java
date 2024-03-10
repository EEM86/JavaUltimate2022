package yym.svydovets.algorithm.task.geometry;

public class RotateImageTask {

    /* Middle
     * https://leetcode.com/problems/rotate-image/description/
     *
     * Given an n * n 2D matrix. Rotate the image by 90 degrees (clockwise).
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
     * DO NOT allocate another 2D matrix and do the rotation.
     *
     * Example (rotated clockwise):
     * [1, 2, 3]        [7, 4, 1]
     * [4, 5, 6]   ->   [8, 5, 2]
     * [7, 8, 9]        [9, 6, 3]
     */
    public void rotate(int[][] matrix) {
        int left = 0, right = matrix.length - 1;

        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int top = left, bottom = right;

                // save the top left
                int topLeft = matrix[top][left + i];

                // move the bottom left into the top left
                matrix[top][left + i] = matrix[bottom - i][left];

                // move the bottom right into bottom left
                matrix[bottom - i][left] = matrix[bottom][right - i];

                // move top right into bottom right
                matrix[bottom][right - i] = matrix[top + i][right];

                // move top left into top right from temp
                matrix[top + i][right] = topLeft;
            }
            right--;
            left++;
        }
    }
}
