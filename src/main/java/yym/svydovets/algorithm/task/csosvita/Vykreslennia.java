package yym.svydovets.algorithm.task.csosvita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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

        int l = 0, r = l+3;

        for (;r <= input.length();) {
            String window = input.substring(l, r);
            if (!window.startsWith("0") && !resultSet.contains(window)) {
                if (window.charAt(0) == window.charAt(1) && window.charAt(1) == window.charAt(2)) {
                    resultSet.add(window);
                } else {
                    permute(window, new ArrayList<Character>(), new boolean[input.length()]);
                }
            }
            l++;
            r++;
        }
        return resultSet.size();
    }

    private static void permute(String input, List<Character> permutations, boolean[] isUsed) {
        if (permutations.size() == 3) {
            StringBuilder sb = new StringBuilder();
            for (Character permutation : permutations) {
                String s = String.valueOf(permutation);
                sb.append(s);
            }
            final String result = sb.toString();
            if (!result.startsWith("0")) {
                resultSet.add(result);
            }
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            if (isUsed[i]) continue;
            char cur = input.charAt(i);
            permutations.add(cur);
            isUsed[i] = true;
            permute(input, permutations, isUsed);
            permutations.remove(permutations.size() - 1);
            isUsed[i] = false;
        }
    }

}
