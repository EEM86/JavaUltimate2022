package yym.svydovets.algorithm.task.csosvita.brute_force;

public class Optimization {

    /*
     * Optimize this code:
     * 1. Implement optimization for O(n^2)
     * 2. Implement optimization for O(n)
     * 3. Implement optimization for O(1)
     *
     * 0 <= n <= 2000
     *
     * Sample Input 0: 3
     * Sample Output 0: 10
     */
    static int optimization(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k <= j; k++) {
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    static int optimizationOn2(int n) {
        int cnt = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i; j++) {
                cnt += j;
            }
        }
        return cnt;
    }

    static int optimizationOn(int n) {
        int cnt = 0;
        for (int i = 1; i <= n ; i++) {
            cnt += (i * (i + 1)) / 2;
        }
        return cnt;
    }

    static int optimizationO1(int n) {
        return n * (n+1) * (n+2) / 6;
    }

}