package yym.svydovets.algorithm.task.csosvita.brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import org.checkerframework.checker.units.qual.A;

public class Presents {

    /*
     * You have presents: Javelin with X weight, Patriot with Y weight and F16 with - Z kg
     * How many presents of the weight of W you can receive.
     *
     * 1 <= X, Y, Z <= 100
     * 1 <= W <= 1000
     *
     * Sample Input 0: 10 25 15 40
     * Sample Output 0: 3
     */
    public static int presentsOsvita(int[] arr) {
        int x = arr[0];
        int y = arr[1];
        int z = arr[2];
        int w = arr[3];
        int cnt = 0;
        for (int i = 0; i * x <= w; i++) {
            for (int j = 0; j * y <= w ; j++) {
                int diff = w - j * y - i * x;
                if (diff >= 0 && diff % z == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int presents(int[] arr) {
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int target = arr[3];
        var resSet = new HashSet<List<Integer>>();

        int sol = 0;

        int[] presents = new int[]{a,b,c};
        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int i = 0; i < presents.length; i++) {
            for (int j = presents[i]; j <= target; j++) {
                dp[j] += dp[j - presents[i]];
            }
        }
        return dp[target];
    }

    static int presentsIncorrect(int[] arr) { // 123 - 6
        var resSet = new HashSet<List<Integer>>();
        int n = arr.length;
        int target = arr[n - 1];
        if (target <= arr[0] || target <= arr[1] || target <= arr[2]) {
            return target;
        }

        for (int i = n - 1; i >= 0; i--) { // i = 3 = 3
            for (int j = i; j >= 0; j--) { // j = 3 = 3
                for (int k = j; k >= 0; k--) { // k = 2 = 2
                    var list = new ArrayList<Integer>(); // []
                    final int firstNum = arr[i];
                    final int secondNum = arr[j];
                    final int thirdNum = arr[k];
                    int sum = firstNum + secondNum + thirdNum; // 9
                    while (sum < target) {
                        sum += thirdNum; // 3 + 1 = 6
                        list.add(thirdNum);
                    }
                    if (sum == target) {
                        list.add(firstNum);
                        list.add(secondNum);
                        list.add(thirdNum);
                        resSet.add(list);
                    }
                    if (k == 0 && firstNum + secondNum == target) {
                        resSet.add(List.of(firstNum, secondNum));
                    }
                }
            }
        }
        return resSet.size();
    }

    static int presents22(int[] arr) {
        var resSet = new HashSet<List<Integer>>();
        int target = arr[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            int firstNum = arr[i];
            for (int j = 0; j < arr.length; j++) {
                final int secondNum = arr[j];
                var list = new ArrayList<Integer>();
                list.add(firstNum);
                int sum = target - firstNum;
                for (int k = 0; k < arr.length; k++) {
                    final int thirdNum = arr[k];
                    if (sum - secondNum < 0) {
                        while (sum - thirdNum >= 0) {
                            list.add(thirdNum);
                            sum = sum - thirdNum;
                        }
                    } else {
                        while (sum - secondNum >= 0) {
                            list.add(secondNum);
                            sum = sum - secondNum;
                        }
                    }
                }
                if (isCandidate(list, target)) {
                    Collections.sort(list);
                    resSet.add(list);
                }
            }
        }
        return resSet.size();
    }

    private static boolean isCandidate(ArrayList<Integer> list, int targetSum) {
        if (list.size() <= 1) return false;
        int curSum = 0;
        for (var el : list) {
            curSum += el;
        }
        return curSum == targetSum;
    }

    static int presents3(int a, int b, int c, int d) {
        var res = new ArrayList<List<Integer>>();
        dfs(res, new int[]{a,b,c}, d, new ArrayList<Integer>(), 0);
        return res.size();
    }

    private static void dfs(List<List<Integer>> res, int[] presents, int totalSum, ArrayList<Integer> tempList, int idx) {
        if (totalSum == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = idx; i < presents.length; i++) {
            int cur = presents[i];
            if (totalSum - cur >= 0) {
                tempList.add(cur);
                dfs(res, presents, totalSum - cur, tempList, i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(presents(new int[]{a,b,c,d}));
    }
}
