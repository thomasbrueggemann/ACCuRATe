package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.AbstractHttpInputStream;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;

final class UnknownLengthHttpInputStream extends AbstractHttpInputStream {
   private boolean inputExhausted;

   UnknownLengthHttpInputStream(InputStream var1, CacheRequest var2, HttpEngine var3) throws IOException {
      super(var1, var3, var2);
   }

   public int available() throws IOException {
      this.checkNotClosed();
      return this.in == null?0:this.in.available();
   }

   public void close() throws IOException {
      if(!this.closed) {
         this.closed = true;
         if(!this.inputExhausted) {
            this.unexpectedEndOfInput();
            return;
         }
      }

   }

   public int read(byte[] var1, int var2, int var3) throws IOException {
      Util.checkOffsetAndCount(var1.length, var2, var3);
      this.checkNotClosed();
      if(this.in != null && !this.inputExhausted) {
         int var4 = this.in.read(var1, var2, var3);
         if(var4 == -1) {
            this.inputExhausted = true;
            this.endOfInput();
            return -1;
         } else {
            this.cacheWrite(var1, var2, var4);
            return var4;
         }
      } else {
         return -1;
      }
   }
}
