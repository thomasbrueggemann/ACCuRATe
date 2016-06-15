package com.squareup.okhttp.internal;

import java.io.IOException;
import java.io.OutputStream;

public abstract class AbstractOutputStream extends OutputStream {
   protected boolean closed;

   protected final void checkNotClosed() throws IOException {
      if(this.closed) {
         throw new IOException("stream closed");
      }
   }

   public boolean isClosed() {
      return this.closed;
   }

   public final void write(int var1) throws IOException {
      byte[] var2 = new byte[]{(byte)var1};
      this.write(var2);
   }
}
