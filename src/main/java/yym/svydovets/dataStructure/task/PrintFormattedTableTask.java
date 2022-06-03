package yym.svydovets.dataStructure.task;


import java.util.Arrays;

public class PrintFormattedTableTask {

//  Given an array of strings of unspecified length, write a function that will print its contents in 5 columns.
//  The minimum distance between columns is 4 spaces.
//
//  Please take a look at the following example. Assume the array is called "input" and is passed into the function.
//
//  Input:
//  String[] input = new String[]{"1", "2", "3", "x", "5", "6", "a", "porosiatko", "c", "10", "11", "12", "13", "14", "15", "16"};
//
//  Output: (this should be printed to the console)
//
//  1     2     3             x     5
//  6     a     porosiatko    c     10
//  11    12    13            14    15
//  16
  public static void main(String[] args) {
      String[] input =
          new String[]{"1", "2", "3", "x", "5", "6", "a", "porosiatko", "c01", "10", "11", "12", "13", "14", "15", "16"};
      int distance = 4;
      int columns = 5;
      int[] maxColumnLength = new int[columns];
      for (int i = 0; i < input.length; i++) {
        int itemLength = input[i].length();
        int itemColumn = i % columns;
        if (maxColumnLength[itemColumn] < itemLength) {
          maxColumnLength[itemColumn] = itemLength;
        }
      }

      for (int i = 0; i < input.length; i++) {
        int itemColumn = i % columns;
        final String item = input[i];
        System.out.print(item.concat(" ".repeat(maxColumnLength[itemColumn] - item.length() + distance)));
        if (itemColumn == columns - 1) {
          System.out.print("\n");
        }
      }
  }

}
