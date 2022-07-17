package com.example.enablestringtrimming.service;

import com.example.enablestringtrimming.annotation.Trimmed;
import org.springframework.stereotype.Service;

@Service
@Trimmed
public class DemoService {

//  @Trimmed
  public void printTrimmedWord(String word) {
    System.out.println(word);
  }
}
