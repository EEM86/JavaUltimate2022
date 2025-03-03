package yym.svydovets.algorithm.task.csosvita.sort;

import java.util.Scanner;
import org.apache.commons.lang3.NotImplementedException;

/*
 * Mobile operator Lvivstar works only along Lviv-Kyiv road.
 * There are N base stations, numbered from 1 to N.
 * Each station has the network area it covers.
 * The client can be under the coverage of multiple stations simultaneously.
 * The station registers ENTER event when the client is in and LEAVE when the client is out.
 * That means the station adds or remove the total amount of clients under the coverage by 1.
 * It is important to count max load of clients.
 *
 * Create a system that can find max stations load on different road distances.
 * It is a task for a SQRT idea
 *
 * 1 <= N <= 200_000 stations
 * 0 <= Ci <= 1000_000 clients
 * 0 <= Q <= 200_000 requests amount
 * 1 <= id <= N "ENTER id" "LEAVE id"
 * 1 <= L <= R <= N "Count L R" - the sum of clients for the stations from L to R inclusive
 *
 * Sample Input 0:
 * 5
 * 2 0 2 3 1
 * 9
 * COUNT 2 4
 * ENTER 2
 * LEAVE 1
 * COUNT 2 4
 * LEAVE 5
 * COUNT 4 5
 * COUNT 1 2
 * ENTER 2
 * COUNT 1 2
 *
 * Sample Output 0:
 * 5
 * 6
 * 3
 * 2
 * 3
 */
public class Operator {
    int[] arr;

    public Operator(int[] arr) {
        throw new NotImplementedException();
    }

    public long sum(int l, int r) {
        throw new NotImplementedException();
    }

    public void inc(int pos) {
        throw new NotImplementedException();
    }

    public void decr(int pos) {
        throw new NotImplementedException();
    }

}
