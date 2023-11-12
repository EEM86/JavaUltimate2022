package yym.svydovets.algorithm.task.strings;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AnagramTest {

  @Test
  @Order(1)
  void testIsAnagram_v1() {
    var first = "anagram";
    var second = "nagaram";

    var actual = Anagram.isAnagram(first, second);

    assertTrue(actual);
  }

  @Test
  @Order(2)
  void testIsAnagram_v2() {
    var first = "rat";
    var second = "car";

    var actual = Anagram.isAnagram(first, second);

    assertFalse(actual);
  }

  @Test
  @Order(3)
  void testGroupAnagram_v1() {
    var input = new String[]{"eat","tea","tan","ate","nat","bat"};
    var expected = fillModifiableArray();

    var actual = Anagram.groupAnagrams(input);

    Stream.of(actual).flatMap(List::stream).forEach(System.out::println);

    for (var list : expected) {
      Collections.sort(list);
    }

    for (var list : actual) {
      Collections.sort(list);
    }

    assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
  }

  @Test
  @Order(4)
  void testGroupAnagram_v2() {
    var input = new String[]{""};
    List<List<String>> expected = List.of(List.of());

    var actual = Anagram.groupAnagrams(input);

    assertEquals(expected.size(), actual.size());
    assertEquals(1, actual.size());
    assertTrue(actual.get(0).get(0).isEmpty());
  }

  @Test
  @Order(5)
  void testGroupAnagram_v3() {
    var input = new String[]{"a"};
    List<List<String>> expected = List.of(List.of("a"));

    var actual = Anagram.groupAnagrams(input);

    assertEquals(expected.size(), actual.size());
    assertEquals(1, actual.size());
    assertEquals("a", actual.get(0).get(0));
  }

  private List<List<String>> fillModifiableArray() {
    var list = new ArrayList<List<String>>();
    var firstEl = new ArrayList<String>();
    firstEl.add("bat");
    var secondEl = new ArrayList<String>();
    secondEl.add("nat");
    secondEl.add("tan");
    var thirdEl = new ArrayList<String>();
    thirdEl.add("ate");
    thirdEl.add("eat");
    thirdEl.add("tea");

    list.add(firstEl);
    list.add(secondEl);
    list.add(thirdEl);

    return list;
  }


}