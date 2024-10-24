package yym.svydovets.algorithm.task.csosvita;

public class Room {

    public static String room(int n, int nAB, int nBC, int nAC) {
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
