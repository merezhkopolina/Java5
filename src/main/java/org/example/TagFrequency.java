package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagFrequency {

  public String getTags() {
    String urlString = "https://www.kpi.ua/";
    try {
      StringBuilder html = new StringBuilder();
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(urlString).openStream()))) {
        String line;
        while ((line = reader.readLine()) != null) {
          html.append(line).append("\n");
        }
      }

      Pattern tagPattern = Pattern.compile("<\\s*(\\w+)(\\s|>)"); // Matches HTML tags
      Matcher matcher = tagPattern.matcher(html.toString());
      Map<String, Integer> tagCount = new HashMap<>();

      while (matcher.find()) {
        String tag = matcher.group(1).toLowerCase(); // Extract tag name
        tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1);
      }

      System.out.println("Tags in Lexicographical Order:");
      tagCount.entrySet().stream()
          .sorted(Map.Entry.comparingByKey())
          .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

      // Sort and display tags by frequency
      System.out.println("\nTags by Frequency:");
      tagCount.entrySet().stream()
          .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
          .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return "";
  }
}
