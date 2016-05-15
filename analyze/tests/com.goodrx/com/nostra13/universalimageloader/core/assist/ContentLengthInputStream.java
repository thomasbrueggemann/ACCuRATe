package com.nostra13.universalimageloader.core.assist;

import java.io.IOException;
import java.io.InputStream;

public class ContentLengthInputStream extends InputStream {
   private final int length;
   private final InputStream stream;

   public ContentLengthInputStream(InputStream var1, int var2) {
      this.stream = var1;
      this.length = var2;
   }

   public int available() {
      return this.length;
   }

   public void close() throws IOException {
      this.stream.close();
   }

   public void mark(int var1) {
      this.stream.mark(var1);
   }

   public boolean markSupported() {
      return this.stream.markSupported();
   }

   public int read() throws IOException {
      return this.stream.read();
   }

   public int read(byte[] var1) throws IOException {
      return this.stream.read(var1);
   }

   public int read(byte[] var1, int var2, int var3) throws IOException {
      return this.stream.read(var1, var2, var3);
   }

   public void reset() throws IOException {
      this.stream.reset();
   }

   public long skip(long var1) throws IOException {
      return this.stream.skip(var1);
   }
}
