package yym.svydovets.algorithm.task.csosvita.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * Given startWord, finalWord and dictionary. Find the shortest length of startWord transformation
 * to the finalWord. Every adjacent pair of words differs by a single letter.
 * All words contain of lowercase English letters.
 *
 * 1 <= startWord.length <= 10
 * finalWord.length == startWord.length
 * 1 <= dictionary.length <= 5000
 * dictionary[i].length == startWord.length
 *
 * Sample Input 0:
 * hit,cog,[hot,dot,dog,lot,log,cog]
 * Sample Output 0:
 * 5
 * Explanation 0: hit -> hot -> dot -> dog -> cog
 */
public class WordTransformationTask {

    private String startWord;
    private String finalWord;
    private Set<String> dictionary;
    public WordTransformationTask(String startWord, Set<String> dict, String finalWorld) {
        this.startWord = startWord;
        this.dictionary = dict;
        this.finalWord = finalWorld;
    }

    public int findShortestTransformations() {
        if (!dictionary.contains(finalWord)) {
            return 0;
        }
        var queue = new LinkedList<String>();
        var visited = new HashMap<String, Integer>();
        queue.add(startWord);
        visited.put(startWord, 1);

        while (!queue.isEmpty()) {
            final String cur = queue.poll();
            int depth = visited.get(cur);

            for (String n : generateNeighbors(cur)) {
                if (n.equals(finalWord)) {
                    return depth + 1;
                }
                if (!visited.containsKey(n)) {
                    visited.put(n, depth + 1);
                    queue.add(n);
                }
            }
        }
        return 0;
    }

    private List<String> generateNeighbors(String word) {
        var neighbors = new ArrayList<String>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char cur = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (cur != ch) {
                    chars[i] = ch;
                    final String candidate = String.valueOf(chars);
                    if (dictionary.contains(candidate)) {
                        neighbors.add(candidate);
                    }
                }
            }
            chars[i] = cur;
        }
        return neighbors;
    }
}
