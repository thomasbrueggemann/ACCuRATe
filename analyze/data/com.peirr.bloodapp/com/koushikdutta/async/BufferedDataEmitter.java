package com.koushikdutta.async;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;

public class BufferedDataEmitter implements DataEmitter, DataCallback {
   ByteBufferList mBuffers = new ByteBufferList();
   DataCallback mDataCallback;
   DataEmitter mEmitter;
   CompletedCallback mEndCallback;
   Exception mEndException;
   boolean mEnded = false;
   private boolean mPaused;

   public BufferedDataEmitter(DataEmitter var1) {
      this.mEmitter = var1;
      this.mEmitter.setDataCallback(this);
      this.mEmitter.setEndCallback(new CompletedCallback() {
         public void onCompleted(Exception var1) {
            BufferedDataEmitter.this.mEnded = true;
            BufferedDataEmitter.this.mEndException = var1;
            if(BufferedDataEmitter.this.mBuffers.remaining() == 0 && BufferedDataEmitter.this.mEndCallback != null) {
               BufferedDataEmitter.this.mEndCallback.onCompleted(var1);
            }

         }
      });
   }

   public void close() {
      this.mEmitter.close();
   }

   public DataCallback getDataCallback() {
      return this.mDataCallback;
   }

   public CompletedCallback getEndCallback() {
      return this.mEndCallback;
   }

   public AsyncServer getServer() {
      return this.mEmitter.getServer();
   }

   public boolean isChunked() {
      return false;
   }

   public boolean isPaused() {
      return this.mPaused;
   }

   public void onDataAvailable() {
      if(this.mDataCallback != null && !this.mPaused && this.mBuffers.remaining() > 0) {
         this.mDataCallback.onDataAvailable(this, this.mBuffers);
      }

      if(this.mEnded && this.mBuffers.remaining() == 0) {
         this.mEndCallback.onCompleted(this.mEndException);
      }

   }

   public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
      var2.get(this.mBuffers);
      this.onDataAvailable();
   }

   public void pause() {
      this.mPaused = true;
   }

   public void resume() {
      if(this.mPaused) {
         this.mPaused = false;
         this.onDataAvailable();
      }
   }

   public void setDataCallback(DataCallback var1) {
      this.mDataCallback = var1;
   }

   public void setEndCallback(CompletedCallback var1) {
      this.mEndCallback = var1;
   }
}
