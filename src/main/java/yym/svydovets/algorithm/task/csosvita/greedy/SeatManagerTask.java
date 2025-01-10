package yym.svydovets.algorithm.task.csosvita.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SeatManagerTask {

    /*
     * Design a system that manages the reservation state of n seats
     * that are numbered from 1 to n.
     *
     * Implement the SeatManager class:
     * SeatManager(int n) Initializes a SeatManager object that will manage
     * n seats numbered from 1 to n. All seats are initially available.
     *
     * int reserve() Fetches the smallest-numbered unreserved seat, reserves it,
     * and returns its number.
     *
     * void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
     *
     * 1 <= n <= 10^5
     * 1 <= seatNumber <= n
     *
     * For each call to reserve, it is guaranteed that there will be at least one
     * unreserved seat. For each call to unreserve, it is guaranteed that seatNumber
     * will be reserved.
     */
    public static class SeatManager {
        PriorityQueue<Integer> seats;

        public SeatManager(int n) {
            seats = new PriorityQueue<>(n, Comparator.naturalOrder());
            for (int i = 1; i <= n; i++) {
                seats.add(i);
            }
        }

        public int reserve() {
            if (seats.isEmpty()) return 0;
            int seat = seats.poll();
            return seat;
        }

        public void unreserve(int seatNumber) {
            seats.add(seatNumber);
        }
    }

}
