package yym.svydovets.algorithm.task.csosvita;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class CourseChooseTest {

    @Test
    void course() {
        int[][] courses = new int[][]{{0,0,0,1}, {0,0,1,0}, {0,1,1,1}, {1,1,1,1}, {0,0,0,0}, {1,0,0,1}};
        CourseChoose.course(courses);
    }

    @Test
    void course1() {
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
        System.out.println(Arrays.toString(arr));
    }
}