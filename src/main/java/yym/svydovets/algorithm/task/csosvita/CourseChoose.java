package yym.svydovets.algorithm.task.csosvita;

import java.util.Arrays;
import java.util.Scanner;

public class CourseChoose {

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
        course(arr);

    }

    static void course(int[][] arr) {
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

}
