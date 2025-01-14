package org.example;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {
    MaxWordsInLine maxWordsInLine = new MaxWordsInLine();
    System.out.println(maxWordsInLine.getLine("file1.txt"));
    /////////////////////////////////////////////////////////////////
    int key = 3;
    String encryptedFile = "encrypted.txt";
    String decryptedFile = "decrypted.txt";
    String input = "Hello, word";
    try {
      try (CaesarEncryptStream out = new CaesarEncryptStream(new FileOutputStream(encryptedFile),
          key)) {
        out.write(input.getBytes());
      }

      try (CaesarDecryptStream in = new CaesarDecryptStream(new FileInputStream(encryptedFile),
          key)) {
        try (FileWriter writer = new FileWriter(decryptedFile)) {
          int b;
          while ((b = in.read()) != -1) {
            writer.write((char) b);
          }
        }
      }

      System.out.println("Decrypted Content: " + Files.readString(Paths.get(decryptedFile)));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}