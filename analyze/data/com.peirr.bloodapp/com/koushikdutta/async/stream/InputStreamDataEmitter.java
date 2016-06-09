package com.koushikdutta.async.stream;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import java.io.InputStream;

public class InputStreamDataEmitter implements DataEmitter {
   DataCallback callback;
   CompletedCallback endCallback;
   InputStream inputStream;
   boolean paused;
   ByteBufferList pending = new ByteBufferList();
   Runnable pumper = new Runnable() {
      public void run() {
         // $FF: Couldn't be decompiled
      }
   };
   AsyncServer server;

   public InputStreamDataEmitter(AsyncServer var1, InputStream var2) {
      this.server = var1;
      this.inputStream = var2;
      this.doResume();
   }

   // $FF: synthetic method
   static void access$000(InputStreamDataEmitter var0, Exception var1) {
      var0.report(var1);
   }

   private void doResume() {
      this.server.post(this.pumper);
   }

   private void report(Exception var1) {
      try {
         this.inputStream.close();
      } catch (Exception var3) {
         var1 = var3;
      }

      if(this.endCallback != null) {
         this.endCallback.onCompleted(var1);
      }

   }

   public void close() {
      this.report((Exception)null);

      try {
         this.inputStream.close();
      } catch (Exception var2) {
         ;
      }
   }

   public DataCallback getDataCallback() {
      return this.callback;
   }

   public CompletedCallback getEndCallback() {
      return this.endCallback;
   }

   public AsyncServer getServer() {
      return this.server;
   }

   public boolean isChunked() {
      return false;
   }

   public boolean isPaused() {
      return this.paused;
   }

   public void pause() {
      this.paused = true;
   }

   public void resume() {
      this.paused = false;
   }

   public void setDataCallback(DataCallback var1) {
      this.callback = var1;
   }

   public void setEndCallback(CompletedCallback var1) {
      this.endCallback = var1;
   }
}
