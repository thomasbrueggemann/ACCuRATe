package com.koushikdutta.async;

import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import java.nio.ByteBuffer;

public class FilteredDataSink extends BufferedDataSink {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;

   static {
      boolean var0;
      if(!FilteredDataSink.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public FilteredDataSink(DataSink var1) {
      super(var1);
      this.setMaxBuffer(0);
   }

   public ByteBufferList filter(ByteBufferList var1) {
      return var1;
   }

   public final void write(ByteBufferList var1) {
      if(!this.isBuffering() || this.getMaxBuffer() == Integer.MAX_VALUE) {
         ByteBufferList var2 = this.filter(var1);
         if(!$assertionsDisabled && var1 != null && var2 != var1 && !var1.isEmpty()) {
            throw new AssertionError();
         }

         super.write(var2, true);
         if(var1 != null) {
            var1.recycle();
            return;
         }
      }

   }

   public final void write(ByteBuffer var1) {
      if(!this.isBuffering() || this.getMaxBuffer() == Integer.MAX_VALUE) {
         ByteBufferList var2 = new ByteBufferList();
         byte[] var3 = new byte[var1.remaining()];
         var1.get(var3);
         if(!$assertionsDisabled && var1.remaining() != 0) {
            throw new AssertionError();
         } else {
            var2.add(ByteBuffer.wrap(var3));
            super.write(this.filter(var2), true);
         }
      }
   }
}
