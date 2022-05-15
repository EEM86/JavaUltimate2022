package yym.svydovets.dataStructure;

import yym.svydovets.utils.Accounts;

import java.time.LocalDate;

public class DemoHashTable {

  public static void main(String[] args) {
    var accounts = Accounts.generateAccountList(10);
    var emailToBirthdayTable = new HashTable<String, LocalDate>();

    accounts.forEach(a -> emailToBirthdayTable.put(a.getEmail(), a.getBirthday()));
    emailToBirthdayTable.printTable();
  }

}
