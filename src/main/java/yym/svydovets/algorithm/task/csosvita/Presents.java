package yym.svydovets.algorithm.task.csosvita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import org.checkerframework.checker.units.qual.A;

public class Presents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(presents(new int[]{a, b, c, d}));
    }

    static int presents(int[] arr) { // 123 - 6
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

    static int presentsV2(int a, int b, int c, int d) {
        int[] arr = new int[]{a,b,c};
        Arrays.sort(arr);
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= d; i++) {
            List<List<Integer>> newList = new ArrayList();
            for (int j = 0; j < arr.length && arr[j] <= i; j++) {
                if (i == arr[j]) {
                    newList.add(Arrays.asList(arr[j]));
                }else {
                    for (List<Integer> l : dp.get(i-arr[j]-1)) {
                        if (arr[j] <= l.get(0)) {
                            List cl = new ArrayList<>();
                            cl.add(arr[j]); cl.addAll(l);
                            newList.add(cl);
                        }
                    }
                }
            }
            dp.add(newList);
        }
        final int size = dp.get(d - 1).size();
        return size;
    }
}
