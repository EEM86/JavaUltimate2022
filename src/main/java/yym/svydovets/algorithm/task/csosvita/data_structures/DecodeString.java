package yym.svydovets.algorithm.task.csosvita.data_structures;

import java.util.Scanner;
import java.util.Stack;

public class DecodeString {

    /*
     * Decode the string. The encoding rule is k[encoded_string].
     * The encoded_string inside the square brackets is being repeated exactly k times.
     * All brackets are well-formed, k is a positive integer, all inputs are correct.
     *
     * 1 <= s.length <= 30
     * 1 <= integers <= 300
     *
     * Sample Input 0:
     * 3[a]2[bc]
     * Sample Output 0:
     * aaabcbc
     */
    public static String decode(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int repeated = 0;

        for (char cur : s.toCharArray()) {
            if (Character.isDigit(cur)) {
                repeated = repeated * 10 + (cur - '0');
            } else if (cur == '[') {
                numStack.push(repeated);
                stringStack.push(result);
                result = new StringBuilder();
                repeated = 0;
            } else if (cur == ']') {
                int repeatCount = numStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    decoded.append(result);
                }
                result = decoded;
            } else {
                result.append(cur);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        String line = sc.nextLine();
        final String decoded = decode(line);
        System.out.println(decoded);
    }
}
