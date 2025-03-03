package yym.svydovets.algorithm.task.csosvita.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HourDiff {

    /*
     * Every day the n trains arrive to the station.
     * Find the min distance between trains in their schedules.
     * Print one integer - the min time in minutes between two trains arrival.
     * Input format - the first row has a number n - the amount of trains.
     * The second row - n moments in time in format HH:MM space separated.
     * 2 <= n <= 2 * 10^4
     * 0 <= HH <= 23
     * 0 <= MM <= 59
     *
     * Sample Input 0:
     * 2
     * 23:59 00:00
     * Sample Output 0:
     * 1
     */
    public static int hoursDiff(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int r = 1; r < arr.length; r++) {
            min = Math.min(min, arr[r] - arr[r-1]);
        }
        int midnightDiff = (24*60) - (arr[arr.length - 1] - arr[0]);
        min = Math.min(min, midnightDiff);
        return min;
    }

    public static int[] parsing(String s) {
        List<Integer> numbers = new ArrayList<>();
        final String[] timeArr = s.split(" ");
        for (var el : timeArr) {
            String hour = el.substring(0, el.indexOf(':'));
            String minute = el.substring(el.indexOf(':') + 1);
            int h = Integer.parseInt(hour);
            int min = Integer.parseInt(minute);
            numbers.add(h * 60 + min);
        }
        return numbers.stream().mapToInt(x -> (int) x).toArray();
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        final int n = sc.nextInt();
        var sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(sc.next()).append(" ");
        }
        final String s = sb.toString();
        final int[] arr = parsing(s);
        final int result = hoursDiff(arr);
        System.out.println(result);
    }

}
