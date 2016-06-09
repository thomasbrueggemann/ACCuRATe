package com.koushikdutta.async;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.DataCallback;

public class DataEmitterReader implements DataCallback {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   ByteBufferList mPendingData = new ByteBufferList();
   DataCallback mPendingRead;
   int mPendingReadLength;

   static {
      boolean var0;
      if(!DataEmitterReader.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   private boolean handlePendingData(DataEmitter var1) {
      if(this.mPendingReadLength > this.mPendingData.remaining()) {
         return false;
      } else {
         DataCallback var2 = this.mPendingRead;
         this.mPendingRead = null;
         var2.onDataAvailable(var1, this.mPendingData);
         return true;
      }
   }

   public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
      if(!$assertionsDisabled && this.mPendingRead == null) {
         throw new AssertionError();
      } else {
         do {
            int var3 = Math.min(var2.remaining(), this.mPendingReadLength - this.mPendingData.remaining());
            var2.get(this.mPendingData, var3);
         } while(this.handlePendingData(var1) && this.mPendingRead != null);

      }
   }

   public void read(int var1, DataCallback var2) {
      if(!$assertionsDisabled && this.mPendingRead != null) {
         throw new AssertionError();
      } else {
         this.mPendingReadLength = var1;
         this.mPendingRead = var2;
         this.mPendingData = new ByteBufferList();
      }
   }
}
