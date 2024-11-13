package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Scanner;

public class Pidryadok {

    /*
     * You have a row, choose the sub row that contains not more than k equal symbols.
     * Input has n symbols in the row and k in first line.
     * The second line is a string with low english letters.
     * Print the maximum length of sub row and the first symbol (first index is 1).
     * If there are several solutions, print the most left symbol.
     * 1 <= n <= 100_000
     * 1 <= k <= n
     *
     * Sample Input 0:
     * 3 1
     * abb
     * Sample Output 0:
     * 2 1
     */
    public static String pidryadok(String s, int k) {
        int[] letters = new int[26];
        int maxLength = 0;
        int mostLeft = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);
            letters[cur - 'a']++;

            while (letters[cur - 'a'] > k) {
                letters[s.charAt(l) - 'a']--;
                l++;
            }
            if (maxLength < r - l + 1) {
                maxLength =  r - l + 1;
                mostLeft = l+1;
            }
        }
        return maxLength + " " + mostLeft;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        final String result = pidryadok(s, k);
        System.out.println(result);
    }

}
