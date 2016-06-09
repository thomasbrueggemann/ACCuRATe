package com.koushikdutta.async.stream;

import com.koushikdutta.async.ByteBufferList;
import java.io.IOException;
import java.io.InputStream;

public class ByteBufferListInputStream extends InputStream {
   // $FF: renamed from: bb com.koushikdutta.async.ByteBufferList
   ByteBufferList field_15;

   public ByteBufferListInputStream(ByteBufferList var1) {
      this.field_15 = var1;
   }

   public int read() throws IOException {
      return this.field_15.remaining() <= 0?-1:this.field_15.get();
   }

   public int read(byte[] var1) throws IOException {
      return this.read(var1, 0, var1.length);
   }

   public int read(byte[] var1, int var2, int var3) throws IOException {
      if(this.field_15.remaining() <= 0) {
         return -1;
      } else {
         int var4 = Math.min(var3, this.field_15.remaining());
         this.field_15.get(var1, var2, var4);
         return var4;
      }
   }
}
