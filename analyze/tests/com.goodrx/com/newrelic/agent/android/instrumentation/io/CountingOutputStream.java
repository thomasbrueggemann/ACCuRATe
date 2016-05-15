package com.newrelic.agent.android.instrumentation.io;

import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListenerManager;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListenerSource;
import java.io.IOException;
import java.io.OutputStream;

public final class CountingOutputStream extends OutputStream implements StreamCompleteListenerSource {
   private long count = 0L;
   private final OutputStream impl;
   private final StreamCompleteListenerManager listenerManager = new StreamCompleteListenerManager();

   public CountingOutputStream(OutputStream var1) {
      this.impl = var1;
   }

   private void notifyStreamComplete() {
      if(!this.listenerManager.isComplete()) {
         this.listenerManager.notifyStreamComplete(new StreamCompleteEvent(this, this.count));
      }

   }

   private void notifyStreamError(Exception var1) {
      if(!this.listenerManager.isComplete()) {
         this.listenerManager.notifyStreamError(new StreamCompleteEvent(this, this.count, var1));
      }

   }

   public void addStreamCompleteListener(StreamCompleteListener var1) {
      this.listenerManager.addStreamCompleteListener(var1);
   }

   public void close() throws IOException {
      try {
         this.impl.close();
         this.notifyStreamComplete();
      } catch (IOException var2) {
         this.notifyStreamError(var2);
         throw var2;
      }
   }

   public void flush() throws IOException {
      try {
         this.impl.flush();
      } catch (IOException var2) {
         this.notifyStreamError(var2);
         throw var2;
      }
   }

   public long getCount() {
      return this.count;
   }

   public void removeStreamCompleteListener(StreamCompleteListener var1) {
      this.listenerManager.removeStreamCompleteListener(var1);
   }

   public void write(int var1) throws IOException {
      try {
         this.impl.write(var1);
         ++this.count;
      } catch (IOException var3) {
         this.notifyStreamError(var3);
         throw var3;
      }
   }

   public void write(byte[] var1) throws IOException {
      try {
         this.impl.write(var1);
         this.count += (long)var1.length;
      } catch (IOException var3) {
         this.notifyStreamError(var3);
         throw var3;
      }
   }

   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         this.impl.write(var1, var2, var3);
         this.count += (long)var3;
      } catch (IOException var5) {
         this.notifyStreamError(var5);
         throw var5;
      }
   }
}
