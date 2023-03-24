package yym.svydovets.dataStructure;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListStructure {

  public static void main(String[] args) {
    // treeMap for concurrency, 50% chance the upper level creates duplicates
    // search starts from the top and decrease the levels to the bottom ~ O (log n)
    // 2                               [ 3 ]
    // 1             [ 1 ]             [ 3 ]
    // 0lvl [ 0 ] -> [ 1 ] -> [ 2 ] -> [ 3 ] -> [ 4 ]
    var map = new ConcurrentSkipListMap<String, String>();
    map.put("1", "first");
    map.put("2", "second");
    System.out.println(map);
    final String result = map.get("2");
    System.out.println(result);
    System.out.println(map.size());

    // has failSafe approach opposite to standard failFast (ConcurrentModificationException with ArrayList example).

  }

}
