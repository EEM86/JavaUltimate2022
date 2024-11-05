package yym.svydovets.algorithm.task.csosvita.brute_force;

import org.apache.commons.lang3.NotImplementedException;

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
        throw new NotImplementedException();
    }

    static int optimizationOn(int n) {
        throw new NotImplementedException();
    }

    static int optimizationO1(int n) {
        throw new NotImplementedException();
    }

}
