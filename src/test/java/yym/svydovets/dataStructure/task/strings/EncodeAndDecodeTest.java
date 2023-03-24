package yym.svydovets.dataStructure.task.strings;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EncodeAndDecodeTest {

  @Test
  @Order(1)
  void testEncode() {
    var input = List.of("hello", "f3");
    var expected = "5#hello2#f3";

    var actual = EncodeAndDecode.encode(input);

    assertEquals(expected, actual);
  }

  @Test
  @Order(2)
  void testDecode_v1() {
    var input = "5#hello";
    var expected = List.of("hello");

    var actual = EncodeAndDecode.decode(input);

    assertEquals(1, actual.size());
    assertEquals("hello", actual.get(0));
    assertEquals(expected, actual);
  }

  @Test
  @Order(3)
  void testDecode_v2() {
    var input = "5#hello3#eye";
    var expected = List.of("hello", "eye");

    var actual = EncodeAndDecode.decode(input);

    assertEquals(2, actual.size());
    assertEquals("hello", actual.get(0));
    assertEquals("eye", actual.get(1));
    assertEquals(expected, actual);
  }

}