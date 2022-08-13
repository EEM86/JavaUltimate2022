package yym.svydovets.dataStructure;

import java.util.BitSet;
import java.util.EnumMap;
import java.util.EnumSet;

public class BitSetStructure {

  public static void main(String[] args) {
    // bitSet uses longs or long array as EnumSet
    // if you create more 65 elements, it creates array of two long - i.e. 128 size
    final BitSet bitSet = new BitSet(65);
    bitSet.set(2, 6);
    System.out.println(bitSet);
    System.out.println(4 == bitSet.cardinality());
    System.out.println(128 == bitSet.size());

  }

}
