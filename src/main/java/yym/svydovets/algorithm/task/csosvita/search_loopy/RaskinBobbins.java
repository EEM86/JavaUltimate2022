package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.lang3.NotImplementedException;

public class RaskinBobbins {


    /*
     * See the txt file task description.
     * In two words - find 2 integers that their sum == money for each trip.
     *
     * Sample Input 0
     * 2
     * 4
     * 5
     * 1 4 5 3 2
     * 4
     * 4
     * 2 2 4 3
     *
     * Sample Output 0
     * 1 4
     * 1 2
     */
    static String raskinBobbinsCountingSort(Trips[] trips) {
        var sb = new StringBuilder();

        for (var trip : trips) {
            int[] arr = countingSort(trip.trips);
            int money = trip.m;
            int l = 0, r = arr.length - 1;

            while (l < r) {
                int curSum = arr[l] + arr[r];
                if (curSum == money) {
                    int[] pair = findPair(arr[l], trip.trips, arr[r]);
                    sb.append(pair[0] + 1)
                        .append(" ")
                        .append(pair[1] + 1).append("\n");
                    break;
                } else if (curSum < money) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    };

    public static int[] findPair(int left, int[ ] arr, int right) {
        int indexLeftResult = -1;
        int indexRightResult = -1;
        int[] result = new int[2];
        for (int k = 0; k < arr.length; k++) {
            if (indexLeftResult != -1 && indexRightResult != -1) {
                break;
            }
            if (arr[k] == left && indexLeftResult == -1) {
                indexLeftResult = k;
            } else if (arr[k] == right && indexRightResult == -1) {
                indexRightResult = k;
            }
        }
        result[0] = Math.min(indexLeftResult, indexRightResult);
        result[1] = Math.max(indexLeftResult, indexRightResult);
        return result;
    }

    public static int[] countingSort(int[] arr) {
        final int max = Arrays.stream(arr).max().orElse(0);
        int[] countArr = computeCountArr(arr, max);
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int cur = arr[i];
            final int idx = countArr[cur];
            output[idx - 1] = cur;
            countArr[cur]--;
        }
        return output;
    }

    private static int[] computeCountArr(int[] arr, int n) {
        int[] c = new int[n+1];
        for (int j : arr) {
            c[j]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i-1] + c[i];
        }
        return c;
    }

    static String raskinBobbinsHashTable(Trips[] trips) {
        var sb = new StringBuilder();

        for (var trip : trips) {
            int money = trip.m;
            int[] arr = trip.trips;
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                int needed = money - arr[i];
                if (map.containsKey(needed)) {
                    int firstIndex = map.get(needed) + 1;
                    int secondIndex = i + 1;
                    sb.append(Math.min(firstIndex, secondIndex)).append(" ")
                        .append(Math.max(firstIndex, secondIndex)).append("\n");
                    break;
                }
                map.put(arr[i], i);
            }
        }

        if (!sb.isEmpty()) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var trips = new ArrayList<Trips>();
        int nTrips = sc.nextInt();
        for (int i = 0; i < nTrips; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            trips.add(new Trips(n,arr,m));
        }

        final String result = raskinBobbinsCountingSort(trips.toArray(Trips[]::new));
        System.out.println(result);
    }

    public static class Trips {
        public int m;
        public int n;
        public int[] trips;

        public Trips() {};

        public Trips(int n, int[] array, int m) {
            this.n = n;
            this.m = m;
            this.trips = array;
        }
    }

}
