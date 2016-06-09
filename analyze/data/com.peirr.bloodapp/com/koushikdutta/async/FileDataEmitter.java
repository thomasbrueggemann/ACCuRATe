package com.koushikdutta.async;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitterBase;
import com.koushikdutta.async.callback.DataCallback;
import java.io.File;
import java.nio.channels.FileChannel;

public class FileDataEmitter extends DataEmitterBase {
   DataCallback callback;
   FileChannel channel;
   File file;
   boolean paused;
   ByteBufferList pending = new ByteBufferList();
   Runnable pumper = new Runnable() {
      public void run() {
         // $FF: Couldn't be decompiled
      }
   };
   AsyncServer server;

   public FileDataEmitter(AsyncServer var1, File var2) {
      this.server = var1;
      this.file = var2;
      boolean var3;
      if(!var1.isAffinityThread()) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.paused = var3;
      if(!this.paused) {
         this.doResume();
      }

   }

   private void doResume() {
      this.server.post(this.pumper);
   }

   public void close() {
      try {
         this.channel.close();
      } catch (Exception var2) {
         ;
      }
   }

   public DataCallback getDataCallback() {
      return this.callback;
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

   protected void report(Exception var1) {
      try {
         this.channel.close();
      } catch (Exception var3) {
         var1 = var3;
      }

      super.report(var1);
   }

   public void resume() {
      this.paused = false;
      this.doResume();
   }

   public void setDataCallback(DataCallback var1) {
      this.callback = var1;
   }
}
