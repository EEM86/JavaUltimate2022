package yym.svydovets.algorithm.task.csosvita;

public class UniformNum {

    /*
     * The positive number N is uniform if his digits are equal.
     * Example: 222 is uniform, 223 -is not.
     * You have two numbers A and B. Find all uniform nums between them.
     *
     * Example: input: 75 300, output: 5 (77, 88, 99, 111, 222)
     */
    public static long getUniformNum(long a, long b) {
        int res = 0;

        // Iterate over the possible number of digits (1 to 12)
        for (int i = 1; i <= 12; i++) {
            // Generate the base number consisting of all 1's with the current length (1, 11, 111)
            long base = 0;
            for (int j = 0; j < i; j++) {
                base = base * 10 + 1; // Create numbers like 1, 11, 111, etc.
            }

            for (int j = 0; j <= 9; j++) {
                long uniformNum = base * j; // get the uniform nums: 22, 33, 444, 5555, etc
                if (uniformNum >= a && uniformNum <= b) {
                    res++;
                }
                if (uniformNum > b) {
                    break;
                }
            }
        }

        return res;
    }

    /*
     * This solution works correctly but very slow
     */
    public static long getUniformNum2(long a, long b) {
        long res = 0;

        for (long i = a; i <= b; i++) {
            if (isUniform(i)) {
                res++;
            }
        }

        return res;
    }

    public static boolean isUniform(long n) {
        if (n < 10) {
            return true;
        }
        if (n < 100) {
            long lastDigit = n % 10;
            n = n / 10;
            long firstDigit = n % 100;
            return lastDigit == firstDigit;
        }
        if (n < 1000) {
            long a = n % 10;
            n = n / 10;
            long b = n % 10;
            n = n / 10;
            long c = n % 10;
            return a == c && a == b;
        }
        long lastDigit = n % 10;
        n = n / 10;
        while (n > 0) {
            long cur = n % 10;
            if (lastDigit != cur) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }

    public static boolean isUniform2(long n) {
        String digits = String.valueOf(n);
        long len = digits.length();
        long l = 0;
        long r = l+1;

        while (r < len) {
            if (digits.charAt((int) l) != digits.charAt((int) r)) {
                return false;
            }
            r++;
        }
        return true;
    }

    public static boolean isUniform3(long n) {
        long lastNum = n % 10;
        n = n / 10;
        while (n > 0) {
            long cur = n % 10;
            if (lastNum != cur ) {
                return false;
            }
            n = n / 10;
        }

        return true;
    }

}
