package com.facebook.common.internal;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CountingOutputStream extends FilterOutputStream {
   private long mCount = 0L;

   public CountingOutputStream(OutputStream var1) {
      super(var1);
   }

   public void close() throws IOException {
      this.out.close();
   }

   public long getCount() {
      return this.mCount;
   }

   public void write(int var1) throws IOException {
      this.out.write(var1);
      ++this.mCount;
   }

   public void write(byte[] var1, int var2, int var3) throws IOException {
      this.out.write(var1, var2, var3);
      this.mCount += (long)var3;
   }
}
