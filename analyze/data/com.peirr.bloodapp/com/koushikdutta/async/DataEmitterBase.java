package com.koushikdutta.async;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;

public abstract class DataEmitterBase implements DataEmitter {
   CompletedCallback endCallback;
   private boolean ended;
   DataCallback mDataCallback;

   public DataCallback getDataCallback() {
      return this.mDataCallback;
   }

   public final CompletedCallback getEndCallback() {
      return this.endCallback;
   }

   protected void report(Exception var1) {
      if(!this.ended) {
         this.ended = true;
         if(this.getEndCallback() != null) {
            this.getEndCallback().onCompleted(var1);
            return;
         }
      }

   }

   protected void resetEnded() {
      this.ended = false;
   }

   public void setDataCallback(DataCallback var1) {
      this.mDataCallback = var1;
   }

   public final void setEndCallback(CompletedCallback var1) {
      this.endCallback = var1;
   }
}
