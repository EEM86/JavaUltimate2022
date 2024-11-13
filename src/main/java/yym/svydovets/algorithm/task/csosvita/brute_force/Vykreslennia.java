package yym.svydovets.algorithm.task.csosvita.brute_force;

import java.util.HashSet;
import java.util.Set;

public class Vykreslennia {

    /*
     * There is a natural number N. Find the unique combinations of 3 digits that
     * can be made by cutting out any of digits from N. You can cut any of digits from N.
     *
     * Example: input = "12", output = 0;
     * input = "111111111110011111111", output = 4 (111, 110, 101, 100)
     */
    static int cutOutOptimal(String input) {
        int cnt = 0;
        for (int i = 100; i < 1000; i++) {
            if (has3Digits(String.valueOf(i), input)) {
                cnt++;
            }
        }
        return cnt;
    };

    private static boolean has3Digits(String number, String n) {
        int ptr = 0;
        for (var el : n.toCharArray()) {
            if (number.charAt(ptr) == el) {
                ptr++;
            }
            if (ptr == 3) {
                return true;
            }
        }
        return false;
    }

    static int cutOut(String input) {
        var set = new HashSet<String>();
        int n = input.length();

        if (n < 3) {
            return 0;
        }

        for (int i = 0; i < n - 2; i++) {
            if (input.charAt(i) == '0') continue;
            for (int j = i+1; j < n - 1; j++) {
                for (int k = j+1; k < n; k++) {
                    char[] arr = new char[3];
                    arr[0] = input.charAt(i);
                    arr[1] = input.charAt(j);
                    arr[2] = input.charAt(k);
                    String res = String.valueOf(arr);
                    if (!set.contains(res)) {
                        System.out.println(res);
                        set.add(res);
                    }
                }
            }
        }
        return set.size();
    }
}