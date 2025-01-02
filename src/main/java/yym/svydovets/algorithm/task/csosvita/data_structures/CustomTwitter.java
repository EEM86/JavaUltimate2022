package yym.svydovets.algorithm.task.csosvita.data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomTwitter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Twitter twitter = new Twitter();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine()
                .split(" ");
            String command = input[0];
            switch (command) {
                case "postTweet" -> twitter.postTweet(Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]));
                case "getNewsFeed" -> twitter.printNewsFeed(Integer.parseInt(input[1]));
                case "follow" -> twitter.follow(Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]));
                case "unfollow" -> twitter.unfollow(Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]));
            }
        }
        scanner.close();
    }


    public static class Twitter {

        private Map<Integer, List<Tweet>> tweets;
        private Map<Integer, Set<Integer>> following;
        private int timestamp;

        public Twitter() {
            this.tweets = new HashMap<>();
            this.following = new HashMap<>();
            this.timestamp = 0;
        }

        public void postTweet(int userId, int tweetId) {
            tweets.putIfAbsent(userId, new ArrayList<>());
            tweets.get(userId).add(new Tweet(timestamp++,tweetId));
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.timestamp));

            if (tweets.containsKey(userId)) {
                for (Tweet tweet : tweets.get(userId)) {
                    minHeap.offer(tweet);
                    if (minHeap.size() > 10) {
                        minHeap.poll();
                    }
                }
            }

            if (following.containsKey(userId)) {
                for (int followeeId : following.get(userId)) {
                    if (tweets.containsKey(followeeId)) {
                        for (Tweet tweet : tweets.get(followeeId)) {
                            minHeap.offer(tweet);
                            if (minHeap.size() > 10) {
                                minHeap.poll();
                            }
                        }
                    }
                }
            }

            List<Integer> result = new ArrayList<>();
            while (!minHeap.isEmpty()) {
                result.add(minHeap.poll().tweetId);
            }
            Collections.reverse(result);
            return result;
        }

        public void printNewsFeed(int userId) {
            List<Integer> feeds = getNewsFeed(userId);
            final String result = feeds
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
            System.out.println(result);
        }

        public void follow(int followerId, int followeeId) {
            if (followerId != followeeId) {
                following.putIfAbsent(followerId,new HashSet<>());
                following.get(followerId).add(followeeId);
            }
        }

        public void unfollow(int followerId, int followeeId) {
            if (following.containsKey(followerId)) {
                following.get(followerId).remove(followeeId);
            }
        }
    }

    public static class Tweet {

        int timestamp;
        int tweetId;

        public Tweet(int timestamp,
            int tweetId) {
            this.timestamp = timestamp;
            this.tweetId = tweetId;
        }

    }

}
