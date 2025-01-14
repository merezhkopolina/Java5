package org.example;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CaesarEncryptStream extends FilterOutputStream {

  private final int shiftKey;

  public CaesarEncryptStream(OutputStream out, int shiftKey) {
    super(out);
    this.shiftKey = shiftKey;
  }

  @Override
  public void write(int b) throws IOException {
    super.write(b + shiftKey);
  }
}
