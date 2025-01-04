package yym.svydovets.algorithm.task.csosvita.knapsack;

import java.util.ArrayDeque;

public class Eval {

    /*
     * Reverse Polish notation (RPN) is a postfix math notation and
     * does not need any parentheses as long as each operator has a fixed number of operands.
     * Evaluate the value of an arithmetic expression in RPN.
     * Valid operators are +, -, *, /
     * Operator / is an integer division (14/3=4).
     * 1 <= tokens.length <= 10^4
     * tokens[i] is either "+", "-", "*", "/" or an int [-200, 200]
     *
     * Sample Input 0:
     * 2 1 + 3 *
     *
     * Sample Output 0:
     * 9
     *
     * Explanation: 2 + 1 * 3
     * Example without parentheses:
     * 4 13 5 / +
     * translates to 4 + (13 / 5) = 6
     */
    public static int eval(String polishNotation) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] data = polishNotation.split(" ");
        queue.add(Integer.parseInt(data[0]));
        queue.add(Integer.parseInt(data[1]));
        for (int i = 2; i < data.length; i++) {
            String cur = data[i];
            switch (cur) {
                case "+":
                    queue.add(queue.pollLast() + queue.pollLast());
                    break;
                case "*":
                    queue.add(queue.pollLast() * queue.pollLast());
                    break;
                case "-":
                    queue.add(-queue.pollLast() + queue.pollLast());
                    break;
                case "/":
                    int first = queue.pollLast();
                    int second = queue.pollLast();
                    queue.add(second / first);
                    break;
                default:
                    queue.add(Integer.parseInt(cur));
                    break;
            }
        }
        return queue.pollLast();
    }

}
