package org.example;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CaesarDecryptStream extends FilterInputStream {
  private final int shiftKey;

  public CaesarDecryptStream(InputStream in, int shiftKey) {
    super(in);
    this.shiftKey = shiftKey;
  }

  @Override
  public int read() throws IOException {
    int b = super.read();
    return (b == -1) ? b : (b - shiftKey);
  }
}
