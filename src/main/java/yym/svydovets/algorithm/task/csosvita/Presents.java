package yym.svydovets.algorithm.task.csosvita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Presents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(presents(a, b, c, d));
    }

    static int presents(int a, int b, int c, int d) {
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
