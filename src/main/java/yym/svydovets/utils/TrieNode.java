package yym.svydovets.utils;

public class TrieNode {

  private static final int DEFAULT_CAPACITY = 26;

  private TrieNode[] links;
  private boolean isEnd;
  private String word;

  public TrieNode() {
    this.links = new TrieNode[DEFAULT_CAPACITY];
  }

  public boolean containsKey(char ch) {
    return links[ch - 'a'] != null;
  }

  public TrieNode get(char ch) {
    return links[ch - 'a'];
  }

  public void put(char ch, TrieNode node) {
    links[ch - 'a'] = node;
  }

  public void setEnd() {
    isEnd = true;
  }

  public boolean isEnd() {
    return isEnd;
  }

  public TrieNode[] getLinks() {
    return links;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }
}
