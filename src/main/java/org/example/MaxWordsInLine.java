package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MaxWordsInLine {

  public String getLine(String fileName) {
    try {
      String maxWordsLine = null;
      int maxWordCount = 0;

      for (String line : Files.readAllLines(Paths.get(fileName))) {
        int wordCount = line.split("\\s+").length;
        if (wordCount > maxWordCount) {
          maxWordCount = wordCount;
          maxWordsLine = line;
        }
      }

      return maxWordsLine;
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return "";
  }

}
