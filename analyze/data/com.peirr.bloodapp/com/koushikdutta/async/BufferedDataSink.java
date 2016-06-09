package com.koushikdutta.async;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import java.nio.ByteBuffer;

public class BufferedDataSink implements DataSink {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   boolean closePending;
   boolean endPending;
   DataSink mDataSink;
   int mMaxBuffer = Integer.MAX_VALUE;
   ByteBufferList mPendingWrites;
   WritableCallback mWritable;

   static {
      boolean var0;
      if(!BufferedDataSink.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public BufferedDataSink(DataSink var1) {
      this.mDataSink = var1;
      this.mDataSink.setWriteableCallback(new WritableCallback() {
         public void onWriteable() {
            BufferedDataSink.this.writePending();
         }
      });
   }

   private void writePending() {
      if(this.mPendingWrites != null) {
         this.mDataSink.write(this.mPendingWrites);
         if(this.mPendingWrites.remaining() == 0) {
            this.mPendingWrites = null;
            if(this.endPending) {
               this.mDataSink.end();
            }

            if(this.closePending) {
               this.mDataSink.close();
            }
         }
      }

      if(this.mPendingWrites == null && this.mWritable != null) {
         this.mWritable.onWriteable();
      }

   }

   public void close() {
      if(this.mPendingWrites != null) {
         this.closePending = true;
      } else {
         this.mDataSink.close();
      }
   }

   public void end() {
      if(this.mPendingWrites != null) {
         this.endPending = true;
      } else {
         this.mDataSink.end();
      }
   }

   public CompletedCallback getClosedCallback() {
      return this.mDataSink.getClosedCallback();
   }

   public DataSink getDataSink() {
      return this.mDataSink;
   }

   public int getMaxBuffer() {
      return this.mMaxBuffer;
   }

   public AsyncServer getServer() {
      return this.mDataSink.getServer();
   }

   public WritableCallback getWriteableCallback() {
      return this.mWritable;
   }

   public boolean isBuffering() {
      return this.mPendingWrites != null;
   }

   public boolean isOpen() {
      return !this.closePending && this.mDataSink.isOpen();
   }

   public int remaining() {
      return this.mPendingWrites == null?0:this.mPendingWrites.remaining();
   }

   public void setClosedCallback(CompletedCallback var1) {
      this.mDataSink.setClosedCallback(var1);
   }

   public void setMaxBuffer(int var1) {
      if(!$assertionsDisabled && var1 < 0) {
         throw new AssertionError();
      } else {
         this.mMaxBuffer = var1;
      }
   }

   public void setWriteableCallback(WritableCallback var1) {
      this.mWritable = var1;
   }

   public void write(ByteBufferList var1) {
      this.write(var1, false);
   }

   protected void write(ByteBufferList var1, boolean var2) {
      if(this.mPendingWrites == null) {
         this.mDataSink.write(var1);
      }

      if(var1.remaining() > 0) {
         int var3 = Math.min(var1.remaining(), this.mMaxBuffer);
         if(var2) {
            var3 = var1.remaining();
         }

         if(var3 > 0) {
            if(this.mPendingWrites == null) {
               this.mPendingWrites = new ByteBufferList();
            }

            var1.get(this.mPendingWrites, var3);
         }
      }

   }

   public void write(ByteBuffer var1) {
      if(this.mPendingWrites == null) {
         this.mDataSink.write(var1);
      }

      if(var1.remaining() > 0) {
         int var2 = Math.min(var1.remaining(), this.mMaxBuffer);
         if(var2 > 0) {
            if(this.mPendingWrites == null) {
               this.mPendingWrites = new ByteBufferList();
            }

            byte[] var3 = new byte[var2];
            var1.get(var3);
            this.mPendingWrites.add(ByteBuffer.wrap(var3));
         }
      }

   }
}
