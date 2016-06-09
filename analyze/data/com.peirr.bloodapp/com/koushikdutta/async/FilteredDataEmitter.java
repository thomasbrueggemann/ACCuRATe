package com.koushikdutta.async;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataEmitterBase;
import com.koushikdutta.async.DataTrackingEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.wrapper.DataEmitterWrapper;

public class FilteredDataEmitter extends DataEmitterBase implements DataEmitter, DataCallback, DataEmitterWrapper, DataTrackingEmitter {
   DataEmitter mEmitter;
   int totalRead;
   DataTrackingEmitter.DataTracker tracker;

   public void close() {
      this.mEmitter.close();
   }

   public int getBytesRead() {
      return this.totalRead;
   }

   public DataEmitter getDataEmitter() {
      return this.mEmitter;
   }

   public DataTrackingEmitter.DataTracker getDataTracker() {
      return this.tracker;
   }

   public AsyncServer getServer() {
      return this.mEmitter.getServer();
   }

   public boolean isChunked() {
      return this.mEmitter.isChunked();
   }

   public boolean isPaused() {
      return this.mEmitter.isPaused();
   }

   public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
      if(var2 != null) {
         this.totalRead += var2.remaining();
      }

      Util.emitAllData(this, var2);
      if(var2 != null) {
         this.totalRead -= var2.remaining();
      }

      if(this.tracker != null && var2 != null) {
         this.tracker.onData(this.totalRead);
      }

   }

   public void pause() {
      this.mEmitter.pause();
   }

   public void resume() {
      this.mEmitter.resume();
   }

   public void setDataEmitter(DataEmitter var1) {
      if(this.mEmitter != null) {
         this.mEmitter.setDataCallback((DataCallback)null);
      }

      this.mEmitter = var1;
      this.mEmitter.setDataCallback(this);
      this.mEmitter.setEndCallback(new CompletedCallback() {
         public void onCompleted(Exception var1) {
            FilteredDataEmitter.this.report(var1);
         }
      });
   }

   public void setDataTracker(DataTrackingEmitter.DataTracker var1) {
      this.tracker = var1;
   }
}
