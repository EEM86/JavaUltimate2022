package yym.svydovets.algorithm.task.csosvita.data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DesignTwitter {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        Twitter twitter = new Twitter();

        for (String c : arr) {
            if (c.startsWith("postTweet")) {
                final String[] params = c.split(" ");
                int firstArg = Integer.parseInt(params[1]);
                int secondArg = Integer.parseInt(params[2]);
                twitter.postTweet(firstArg, secondArg);
            }
            if (c.startsWith("getNewsFeed")) {
                final String[] params = c.split(" ");
                int firstArg = Integer.parseInt(params[1]);
                final String result = twitter.getNewsFeed(firstArg)
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
                System.out.println(result);
            }
            if (c.startsWith("follow")) {
                final String[] params = c.split(" ");
                int firstArg = Integer.parseInt(params[1]);
                int secondArg = Integer.parseInt(params[2]);
                twitter.follow(firstArg, secondArg);
            }
            if (c.startsWith("unfollow")) {
                final String[] params = c.split(" ");
                int firstArg = Integer.parseInt(params[1]);
                int secondArg = Integer.parseInt(params[2]);
                twitter.unfollow(firstArg, secondArg);
            }
        }
    }

    public static class Twitter {
        Map<Integer, Node> userMap = new HashMap<>();

        public Twitter() {};

        void postTweet(int userId, int tweetId) {
            createUserIfNeeded(userId, new Node(tweetId));
        }

        List<Integer> getNewsFeed(int userId) {
            if (!userMap.containsKey(userId)) {
                return List.of();
            }
            List<Integer> result = new ArrayList<>();
            Node curTweet = userMap.get(userId);
            while (curTweet != null) {
                result.add(curTweet.val);
                curTweet = curTweet.next;
            }
            Collections.reverse(result);
            return result;
        }

        void follow(int followerId, int followeeId) {
            if ((!userMap.containsKey(followerId)) || (followerId == followeeId)) return;
            if (!userMap.containsKey(followeeId)) {
                createUserIfNeeded(followeeId, new Node());
            }
            Node firstUser = userMap.get(followerId);
            if (firstUser.next != userMap.get(followeeId)) {
                firstUser.next = userMap.get(followeeId);
            }
        }

        void unfollow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;
            if (followerId == followeeId) return;
            final Node followee = userMap.get(followeeId);
            final Node node = userMap.get(followerId);
            var prev = node;
            var cur = node.next;
            while (cur != null) {
                if (cur == followee) {
                    prev.next = cur.next;
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
        }

        private void createUserIfNeeded(int userId, Node node) {
            if (userMap.containsKey(userId)) {
                final Node user = userMap.get(userId);
                user.val = node.val;
                user.next = node.next;
                return;
            }
            userMap.put(userId, node);
        }
    }

    public static class Node {
        Integer val;
        Node next;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}
