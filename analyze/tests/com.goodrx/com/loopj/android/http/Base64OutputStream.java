package com.loopj.android.http;

import com.loopj.android.http.Base64;
import com.loopj.android.http.Base64DataException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64OutputStream extends FilterOutputStream {
   private static final byte[] EMPTY = new byte[0];
   private int bpos;
   private byte[] buffer;
   private final Base64.Coder coder;
   private final int flags;

   public Base64OutputStream(OutputStream var1, int var2) {
      this(var1, var2, true);
   }

   public Base64OutputStream(OutputStream var1, int var2, boolean var3) {
      super(var1);
      this.buffer = null;
      this.bpos = 0;
      this.flags = var2;
      if(var3) {
         this.coder = new Base64.Encoder(var2, (byte[])null);
      } else {
         this.coder = new Base64.Decoder(var2, (byte[])null);
      }
   }

   private byte[] embiggen(byte[] var1, int var2) {
      if(var1 == null || var1.length < var2) {
         var1 = new byte[var2];
      }

      return var1;
   }

   private void flushBuffer() throws IOException {
      if(this.bpos > 0) {
         this.internalWrite(this.buffer, 0, this.bpos, false);
         this.bpos = 0;
      }

   }

   private void internalWrite(byte[] var1, int var2, int var3, boolean var4) throws IOException {
      this.coder.output = this.embiggen(this.coder.output, this.coder.maxOutputSize(var3));
      if(!this.coder.process(var1, var2, var3, var4)) {
         throw new Base64DataException("bad base-64");
      } else {
         this.out.write(this.coder.output, 0, this.coder.field_114);
      }
   }

   public void close() throws IOException {
      IOException var1 = null;

      try {
         this.flushBuffer();
         this.internalWrite(EMPTY, 0, 0, true);
      } catch (IOException var4) {
         var1 = var4;
      }

      try {
         if((16 & this.flags) == 0) {
            this.out.close();
         } else {
            this.out.flush();
         }
      } catch (IOException var5) {
         if(var1 != null) {
            var1 = var5;
         }
      }

      if(var1 != null) {
         throw var1;
      }
   }

   public void write(int var1) throws IOException {
      if(this.buffer == null) {
         this.buffer = new byte[1024];
      }

      if(this.bpos >= this.buffer.length) {
         this.internalWrite(this.buffer, 0, this.bpos, false);
         this.bpos = 0;
      }

      byte[] var2 = this.buffer;
      int var3 = this.bpos;
      this.bpos = var3 + 1;
      var2[var3] = (byte)var1;
   }

   public void write(byte[] var1, int var2, int var3) throws IOException {
      if(var3 > 0) {
         this.flushBuffer();
         this.internalWrite(var1, var2, var3, false);
      }
   }
}
