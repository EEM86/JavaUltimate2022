package yym.svydovets.algorithm.task.csosvita.heapify;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GoogleCalendar {

    private static Map<String, Integer> dayOffset = new HashMap<>();

    static {
        dayOffset.put("Monday", 0);
        dayOffset.put("Tuesday", 1);
        dayOffset.put("Wednesday", 2);
        dayOffset.put("Thursday", 3);
        dayOffset.put("Friday", 4);
        dayOffset.put("Saturday", 5);
        dayOffset.put("Sunday", 6);
    }

    /*
     * To render a calendar in your project, it was decided to separate
     * the formatting functionality into a standalone module.
     *
     * The module parameters (formally for a function that can be imported from the module)
     * will be the number of days in the month and the name of the day of the week
     * on which the first day of the month falls.
     *
     * Display all the days of the month by weeks, padding the first week with empty values if required.
     * 28 <= nDays <= 31
     *
     * Output k lines (4 <= k <= 6), where the i-th line contains the dates that fall on the i-th week of the month.
     * Follow these rules when outputting:
     * All lines, except the last one, should have exactly 7 elements (the last line may also have 7 elements);
     * When outputting days numbered from 1 to 9, add a period (.) before the digit;
     * When outputting days for the first week, use two periods (..) before the first number.
     *
     * Sample Input 0:
     * 30 Saturday
     * Sample Output 0:
     * .. .. .. .. .. .1 .2
     * .3 .4 .5 .6 .7 .8 .9
     * 10 11 12 13 14 15 16
     * 17 18 19 20 21 22 23
     * 24 25 26 27 28 29 30
     */
    public static String formatCalendar(int lastDay, String day) {
        final Integer offset = dayOffset.get(day);
        var sb = new StringBuilder();
        for (int i = 0; i < offset; i++) {
            sb.append("..").append(" ");
        }
        int week = 7;
        int daysSubmitted = offset;
        for (int i = 1; i <= lastDay; i++) {
            if (i < 10) {
                sb.append(".").append(i).append(" ");
            } else {
                sb.append(i).append(" ");
            }
            daysSubmitted++;
            if (daysSubmitted % week == 0) {
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
            }
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int lastDay = sc.nextInt();
        final String dayName = sc.next();
        final String result = formatCalendar(lastDay, dayName);
        System.out.println(result);
    }

}
