package yym.svydovets.algorithm.task.csosvita.search_loopy;

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
        throw new NotImplementedException();
    };

    /*
     * Solution using addition memory
     */
    static String raskinBobbinsHashTable(Trips[] trips) {
        throw new NotImplementedException();
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
