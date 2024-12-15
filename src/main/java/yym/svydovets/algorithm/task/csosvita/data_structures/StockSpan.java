package yym.svydovets.algorithm.task.csosvita.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class StockSpan {

    /*
     * Return the span of stock's price for the current day.
     * The span is the max number of consecutive days
     * starting from the current day and going backward,
     * for which the stock price was lass or equal to the price of that day.
     *
     * Example: [7,2,1,2] and today the price is 3. The span of today is 4.
     *
     * n <= 10^5
     * 1 <= price <= 10^6
     *
     * Sample input 0:
     * 100 80 60 70 60 75 85
     * Sample output 0:
     * 1 1 1 2 1 4 6
     */
    public static int[] getSpans(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i);

        }
        return res;
    }


    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        final int[] spans = getSpans(arr);
        String result = Arrays.stream(spans)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));
        System.out.println(result);
    }

}
