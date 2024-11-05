package yym.svydovets.algorithm.task.csosvita.brute_force;

public class Room {

    /*
     * The room is a triangle ABC. There are N chairs. You have numbers of chairs
     * that must stand at the walls: Nab, Nbc, Nac.
     * You can place chairs only in the corners and along the walls. You are not
     * permitted to place the chair in the center of the room. Each corner can contain
     * a lot of chairs.
     * Print YES and 6 positive integers: kA, kAB, kB, kBC, kC, kAC - number of chairs
     * in the corners and at the walls.
     *
     * 0 <= N, Nab, Nbc, Nac <= 1000
     *
     * Sample Input 0: 3 2 2 2
     * Sample Output 0: YES \n 1 0 1 0 1 0
     */
    public static String room(int n, int nAB, int nBC, int nAC) {
        for (int a = 0; a < 1001; a++) {
            for (int b = 0; b < 1001; b++) {
                int c = nAB + nBC + nAC - n - a - b;
                int ab = nAB - a - b;
                int bc = nBC - b - c;
                int ac = nAC - a - c;
                if (c == 0 && ab == 0 && bc == 0 && ac == 0) {
                    return "NO";
                }
                if (c >= 0 && ab >= 0 && bc >= 0 && ac >= 0) {
                    return String.format("YES\n%d %d %d %d %d %d", a, ab, b, bc, c, ac);
                }
            }
        }
        return "NO";
    }

    public static String roomNotPass(int n, int nAB, int nBC, int nAC) {
        if (n == 0 || nAB > n || nBC > n || nAC > n) {
            return "NO";
        }

        if (nAB != 0 && nBC != 0 && nAC != 0) {
            int A = nAB + nAC - n ;
            int B = nAB - A;
            int C = nAC - A;
            return String.format("YES\n%d 0 %d 0 %d 0", A, B, C);
        }

        int A = 0, B = 0, C = 0, AB = 0, BC = 0, AC = 0;
        if (nAB != 0) {
            A = nAB + nAC - n;
            if (A < 0) {
                A = 0;
            } else {
                AB = nAB - A;
            }
        }
        if (nBC != 0) {
            B = nBC + nAB - n;
            if (B < 0) {
                B = 0;
            } else {
                BC = nBC - B;
            }
        }
        if (nAC != 0) {
            C = nAC + nBC - n;
            if (C < 0) {
                C = 0;
            } else {
                AC = nAC - C;
            }
        }


        return String.format("YES\n%d %d %d %d %d %d", A, AB, B, BC, C, AC);
    }

    public static int room2(int a, int b, int c, int d) {
        if (a == 0) {
            return 0;
        }
        if (b > a || c > a || d > a) {
            return -1;
        }

        int rows = 0;
        int cols = 0;
        var sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j <= i; j++) {
                cols++;
                sb.append(j);
            }
            sb.append("\n");
            rows++;
        }
        System.out.println(sb.toString());
        System.out.println(rows);
        System.out.println(cols);
        return 0;
    }

}
