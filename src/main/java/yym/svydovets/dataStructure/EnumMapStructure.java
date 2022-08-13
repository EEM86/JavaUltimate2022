package yym.svydovets.dataStructure;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumMapStructure {

  public static void main(String[] args) {
    final int ordinalW = Seasons.WINTER.ordinal();
    final int ordinalSp = Seasons.SPRING.ordinal();
    final int ordinalS = Seasons.SUMMER.ordinal();
    final int ordinalF = Seasons.FALL.ordinal();
    System.out.println(ordinalW + " " + ordinalSp + " " + ordinalS + " " + ordinalF);
    // ordinal is used for EnumMap or EnumSet, but if the ordinal is changed, the logic will be corrupted
    // ordinal guarantees that enumMap works with O(1)
    var enumMap = new EnumMap<>(Seasons.class);
    enumMap.put(Seasons.WINTER, "cold");
    enumMap.put(Seasons.SPRING, "warm");
    enumMap.put(Seasons.SUMMER, "hot");
    enumMap.put(Seasons.FALL, "wet");
    System.out.println(enumMap.entrySet());

    //  enumSet uses longs or array of long (63 bits)
    //  if the element exists, the current bit = 1, i.e. [00100000000000], if ordinal() = 3, the element is present
    final EnumSet<Seasons> enumSet = EnumSet.allOf(Seasons.class);
    System.out.println(enumSet);
  }

  public static enum Seasons {
    WINTER, SPRING, SUMMER, FALL
  }

}
