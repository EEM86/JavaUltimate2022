package yym.svydovets.algorithm.task.csosvita.data_structures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class DesignTwitterTest {

    @Test
    void testTwitter() {
        var twitter = new CustomTwitter.Twitter();
        var sb = new StringBuilder();

        twitter.postTweet(1, 5);
        final String firstResult = twitter.getNewsFeed(1)
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" "));
        sb.append(firstResult).append("\n");

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        final String secondResult = twitter.getNewsFeed(1)
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" "));
        sb.append(secondResult).append("\n");

        twitter.unfollow(1, 2);
        final String thirdResult = twitter.getNewsFeed(1)
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" "));
        sb.append(thirdResult).append("\n");

        twitter.postTweet(3, 9);
        twitter.follow(1, 3);
        final String fourthResult = twitter.getNewsFeed(1)
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" "));
        sb.append(fourthResult).append("\n");

        String expected = "5\n6 5\n5\n9 5\n";
        assertEquals(expected, sb.toString());
    }

    @Test
    void testTwitter2() {
        String[] arr = new String[]{
            "postTweet 1 5",
            "getNewsFeed 1",
            "follow 1 2",
            "postTweet 2 6",
            "getNewsFeed 1",
            "unfollow 1 2",
            "getNewsFeed 1"
        };

        var twitter = new CustomTwitter.Twitter();
        var sb = new StringBuilder();

        for (String c : arr) {
            if (c.startsWith("postTweet")) {
                final String[] args = c.split(" ");
                int firstArg = Integer.parseInt(args[1]);
                int secondArg = Integer.parseInt(args[2]);
                twitter.postTweet(firstArg, secondArg);
            }
            if (c.startsWith("getNewsFeed")) {
                final String[] args = c.split(" ");
                int firstArg = Integer.parseInt(args[1]);
                final String result = twitter.getNewsFeed(firstArg)
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
                sb.append(result).append("\n");
            }
            if (c.startsWith("follow")) {
                final String[] args = c.split(" ");
                int firstArg = Integer.parseInt(args[1]);
                int secondArg = Integer.parseInt(args[2]);
                twitter.follow(firstArg, secondArg);
            }
            if (c.startsWith("unfollow")) {
                final String[] args = c.split(" ");
                int firstArg = Integer.parseInt(args[1]);
                int secondArg = Integer.parseInt(args[2]);
                twitter.unfollow(firstArg, secondArg);
            }
        }
        String expected = "5\n6 5\n5\n";
        assertEquals(expected, sb.toString());
    }

    @Test
    void testTwitter3() {
        String[] arr = new String[]{
            "postTweet 1 5",
            "getNewsFeed 1",
            "follow 1 2",
            "postTweet 2 6",
            "follow 2 3",
            "postTweet 3 9",
            "getNewsFeed 1"
        };

        var twitter = new CustomTwitter.Twitter();
        var sb = new StringBuilder();

        for (String c : arr) {
            if (c.startsWith("postTweet")) {
                final String[] args = c.split(" ");
                int firstArg = Integer.parseInt(args[1]);
                int secondArg = Integer.parseInt(args[2]);
                twitter.postTweet(firstArg, secondArg);
            }
            if (c.startsWith("getNewsFeed")) {
                final String[] args = c.split(" ");
                int firstArg = Integer.parseInt(args[1]);
                final String result = twitter.getNewsFeed(firstArg)
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
                sb.append(result).append("\n");
            }
            if (c.startsWith("follow")) {
                final String[] args = c.split(" ");
                int firstArg = Integer.parseInt(args[1]);
                int secondArg = Integer.parseInt(args[2]);
                twitter.follow(firstArg, secondArg);
            }
            if (c.startsWith("unfollow")) {
                final String[] args = c.split(" ");
                int firstArg = Integer.parseInt(args[1]);
                int secondArg = Integer.parseInt(args[2]);
                twitter.unfollow(firstArg, secondArg);
            }
        }

        String expected = "5\n6 5\n";
        assertEquals(expected, sb.toString());
    }

}