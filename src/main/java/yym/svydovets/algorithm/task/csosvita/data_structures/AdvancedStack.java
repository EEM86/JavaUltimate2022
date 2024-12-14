package yym.svydovets.algorithm.task.csosvita.data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
 * Implement AdvancedStack class with the following methods:
 * void push(int val) pushes the element val onto the stack
 * void pop() removes the element on the top of the stack
 * int getMax() retrieves the maximum element in the stack
 *
 * You must implement a solution with O(1) time complexity for each function.
 * 1 <= n <= 10^5
 * 1 <= x <= 10^9
 *
 * Sample Input 0:
 * var stack = new AdvancedStack();
 * stack.push(97);
 * stack.pop();
 * stack.push(20);
 * stack.pop();
 * stack.push(26);
 * stack.push(20);
 * stack.pop();
 * stack.getMax();
 * stack.push(91);
 * stack.getMax();
 *
 * Sample Output 0:
 * 26
 * 91
 */
public class AdvancedStack {

    private List<Integer> stack = new ArrayList<>();
    private List<Pair> minMax = new ArrayList<>();
    private int size = 0;

    public void push(int val) {
        stack.add(size, val);
        if (size == 0) {
            minMax.add(size, new Pair(val, val));
        } else {
            int lastMin = Math.min(val, minMax.get(size - 1).min);
            int lastMax = Math.max(val, minMax.get(size - 1).max);
            minMax.add(size, new Pair(lastMin, lastMax));
        }
        size++;
    }

    public void pop() {
        stack.remove(size - 1);
        minMax.remove(size - 1);
        size--;
    }

    public int getMax() {
        return minMax.get(size - 1).max;
    }

    public int getSize() {
        return size;
    }

    record Pair(int min, int max){};

    public static void main(String[]args){
        AdvancedStack stack = new AdvancedStack();
        var sb = new StringBuilder();
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            String line = sc.nextLine();
            if (line.startsWith("1")) {
                stack.push(Integer.parseInt(line.split(" ")[1]));
            } else if (line.startsWith("2")) {
                stack.pop();
            } else if (line.startsWith("3")) {
                sb.append(stack.getMax()).append("\n");
            }
        }

        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
    }
}
