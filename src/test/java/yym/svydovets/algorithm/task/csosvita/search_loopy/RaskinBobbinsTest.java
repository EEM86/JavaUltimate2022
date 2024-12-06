package yym.svydovets.algorithm.task.csosvita.search_loopy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.search_loopy.RaskinBobbins.Trips;

class RaskinBobbinsTest {

    @Test
    void raskinBobbins() {
        var firstTrip = new Trips();
        firstTrip.m = 4;
        firstTrip.n = 5;
        firstTrip.trips = new int[]{1,4,5,3,2};
        var secondTrip = new Trips();
        secondTrip.m = 4;
        secondTrip.n = 4;
        secondTrip.trips = new int[]{2,2,4,3};
        var arr = new Trips[]{firstTrip, secondTrip};

        final String result = RaskinBobbins.raskinBobbinsCountingSort(arr);
        assertEquals("1 4\n1 2", result);
    }

    @Test
    void raskinBobbins2() {
        var firstTrip = new Trips();
        firstTrip.m = 17;
        firstTrip.n = 10;
        firstTrip.trips = new int[]{5, 8, 5, 10, 10, 5, 9, 6, 2, 9};
        var secondTrip = new Trips();
        secondTrip.m = 7;
        secondTrip.n = 9;
        secondTrip.trips = new int[]{7, 5, 4, 3, 5, 8, 2, 5, 4, 7};
        var arr = new Trips[]{firstTrip, secondTrip};

        final String result = RaskinBobbins.raskinBobbinsCountingSort(arr);
        assertEquals("2 7\n2 7", result);
    }

    @Test
    void testSorting() {
        int[] arr = new int[]{1,3,4,5,2};
        final int[] result = RaskinBobbins.countingSort(arr);
        assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(result));
    }

    public static void stressTest() {
        int test = 0;
        while (true) {
            test++;
            if (test % 10 == 0) {
                System.out.println(test);
            }
            runTest();
        }
    }

//    public static void main(String[] args) {
//        stressTest();
//    }

    public static void runTest() {
        Random random = new Random();

        // Generate random array size
        int n = random.nextInt(10) + 1;  // 1 to 10

        // Create and fill array with random numbers
        Trips[] trips = new Trips[n];
        for (int i = 0; i < n; i++) {
            var trip = new Trips();
            trip.m = random.nextInt(1, 11);  // 0 to 10
            trip.n = random.nextInt(2,11);
            trip.trips = random.ints().filter(x -> (x > 0) && (x < 101)).limit(trip.n).toArray();
            trips[i] = trip;
        }

        System.out.println("Running for trips size:" + trips.length);


        // Compare results from both solutions
        if (!RaskinBobbins.raskinBobbinsCountingSort(trips).equals(RaskinBobbins.raskinBobbinsHashTable(trips))) {
            System.out.println("Result 1: " + RaskinBobbins.raskinBobbinsCountingSort(trips));
            System.out.println("Result 2: " + RaskinBobbins.raskinBobbinsHashTable(trips));
            Arrays.stream(trips).forEach(x -> System.out.println(x.m + " " + x.n + " " + Arrays.toString(x.trips)));
            throw new RuntimeException("Found a bug!");
        }
    }


}