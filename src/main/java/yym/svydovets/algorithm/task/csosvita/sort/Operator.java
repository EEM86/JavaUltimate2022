package yym.svydovets.algorithm.task.csosvita.sort;

import java.util.Scanner;

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
    public int[] arr;
    public int[] blocks;
    public int countBlock;

    public Operator(int[] arr) {
        this.arr = arr;
        this.countBlock = (int) Math.sqrt(arr.length - 1) + 1;
        this.blocks = new int[countBlock];
        for (int i = 0; i < arr.length-1; i++) {
            blocks[i/countBlock] += arr[i+1];
        }
    }

    public long sum(int l, int r) {
        int lBlockNum = l / countBlock;
        int rBlockNum = r / countBlock;
        if (lBlockNum == rBlockNum) {
            long sum = 0;
            for (int i = l; i <= r; i++) {
                sum += arr[i];
            }
            return  sum;
        }
        long sum = 0;
        for (int blockNum = lBlockNum + 1; blockNum < rBlockNum; ++blockNum) {
            sum += blocks[blockNum];
        }
        for (int i = l; i <= (lBlockNum + 1) * countBlock; ++i) {
            sum += arr[i];
        }
        for (int i = r; i > rBlockNum * countBlock ; --i) {
            sum += arr[i];
        }
        return sum;
    }

    public void inc(int pos) {
        arr[pos]++;
        blocks[pos/countBlock]++;
    }

    public void decr(int pos) {
        arr[pos]--;
        blocks[pos/countBlock]--;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] clients = sc.nextLine().split(" ");
        int[] arr = new int[n+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(clients[i-1]);
        }
        String queries = sc.nextLine();
        var operator = new Operator(arr);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.startsWith("COUNT")) {
                final long res = operator.sum(
                    Integer.parseInt(line.split(" ")[1]),
                    Integer.parseInt(line.split(" ")[2])
                );
                System.out.println(res);
            } else if (line.startsWith("ENTER")) {
                operator.inc(Integer.parseInt(line.split(" ")[1]));
            } else {
                operator.decr(Integer.parseInt(line.split(" ")[1]));
            }
        }
    }

}
