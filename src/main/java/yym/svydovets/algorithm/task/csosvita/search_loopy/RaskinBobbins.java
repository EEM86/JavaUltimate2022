package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RaskinBobbins {


    /*
     * See the txt file task description.
     * In two words - find 2 integers that their sum == money for each trip.
     */
    static String raskinBobbinsOptimal(Trips[] trips) {
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

    // not pass stress test
    static String raskinBobbins(Trips[] trips) {
        var sb = new StringBuilder();
        for (var trip : trips) {
            int money = trip.m;
            int[] arr = trip.trips;
            boolean isScanningFinished = false;


            for (int i = 0; i < arr.length - 1; i++) {
                if (isScanningFinished) break;
                int sumToFind = money - arr[i];
                for (int j = i+1; j < arr.length; j++) {
                    int cur = arr[j];
                    if (sumToFind == cur) {
                        if (arr[i] <= arr[j]) {
                            sb.append(i+1).append(" ").append(j+1).append("\n");
                        } else {
                            sb.append(j+1).append(" ").append(i+1).append("\n");
                        }
                        isScanningFinished = true;
                        break;
                    }
                }
            }
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
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

        final String result = raskinBobbinsOptimal(trips.toArray(Trips[]::new));
        System.out.println(result);
    }

}
