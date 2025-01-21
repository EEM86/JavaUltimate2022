package yym.svydovets.algorithm.task.csosvita.dymanic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBrakeTask {

    /*
     * Given a string s and a dictionary of strings wordDict, return 1
     * if s can be segmented into a space-separated sequence of one or more dictionary words.
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     *
     * Example:
     * applepenapple
     * [apple, pen]
     * Output:
     * 1 // apple pen apple
     */
    public static int isWordBrakeDp(String s, String[] dict) {
        var set = new HashSet<>(Arrays.asList(dict));

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()] ? 1 : 0;
    }

    public static int isWordBrake(String s, String[] dict) {
        final Set<String> set = Arrays.stream(dict).collect(Collectors.toSet());
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            if (set.contains(s.substring(l,r+1))) {
                r++;
                l = r;
            } else {
                r++;
            }
        }
        return l == r ? 1 : 0;
    }

}
