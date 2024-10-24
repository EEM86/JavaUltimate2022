package yym.svydovets.algorithm.task.csosvita;

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
    static Set<String> resultSet = new HashSet<String>();

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
