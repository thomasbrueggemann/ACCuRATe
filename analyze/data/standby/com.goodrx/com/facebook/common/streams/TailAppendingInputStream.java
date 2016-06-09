package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TailAppendingInputStream extends FilterInputStream {
   private int mMarkedTailOffset;
   private final byte[] mTail;
   private int mTailOffset;

   public TailAppendingInputStream(InputStream var1, byte[] var2) {
      super(var1);
      if(var1 == null) {
         throw new NullPointerException();
      } else if(var2 == null) {
         throw new NullPointerException();
      } else {
         this.mTail = var2;
      }
   }

   private int readNextTailByte() {
      if(this.mTailOffset >= this.mTail.length) {
         return -1;
      } else {
         byte[] var1 = this.mTail;
         int var2 = this.mTailOffset;
         this.mTailOffset = var2 + 1;
         return 255 & var1[var2];
      }
   }

   public void mark(int var1) {
      if(this.in.markSupported()) {
         super.mark(var1);
         this.mMarkedTailOffset = this.mTailOffset;
      }

   }

   public int read() throws IOException {
      int var1 = this.in.read();
      return var1 != -1?var1:this.readNextTailByte();
   }

   public int read(byte[] var1) throws IOException {
      return this.read(var1, 0, var1.length);
   }

   public int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.in.read(var1, var2, var3);
      if(var4 != -1) {
         return var4;
      } else if(var3 == 0) {
         return 0;
      } else {
         int var5;
         for(var5 = 0; var5 < var3; ++var5) {
            int var6 = this.readNextTailByte();
            if(var6 == -1) {
               break;
            }

            var1[var2 + var5] = (byte)var6;
         }

         if(var5 <= 0) {
            var5 = -1;
         }

         return var5;
      }
   }

   public void reset() throws IOException {
      if(this.in.markSupported()) {
         this.in.reset();
         this.mTailOffset = this.mMarkedTailOffset;
      } else {
         throw new IOException("mark is not supported");
      }
   }
}
