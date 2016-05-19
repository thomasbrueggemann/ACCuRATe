package com.newrelic.agent.android.instrumentation.io;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListenerManager;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListenerSource;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class CountingInputStream extends InputStream implements StreamCompleteListenerSource {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private final ByteBuffer buffer;
   private long count = 0L;
   private boolean enableBuffering = false;
   private final InputStream impl;
   private final StreamCompleteListenerManager listenerManager = new StreamCompleteListenerManager();

   public CountingInputStream(InputStream var1) {
      this.impl = var1;
      if(this.enableBuffering) {
         this.buffer = ByteBuffer.allocate(Agent.getResponseBodyLimit());
         this.fillBuffer();
      } else {
         this.buffer = null;
      }
   }

   public CountingInputStream(InputStream var1, boolean var2) {
      this.impl = var1;
      this.enableBuffering = var2;
      if(var2) {
         this.buffer = ByteBuffer.allocate(Agent.getResponseBodyLimit());
         this.fillBuffer();
      } else {
         this.buffer = null;
      }
   }

   private boolean bufferEmpty() {
      return !this.buffer.hasRemaining();
   }

   private boolean bufferHasBytes(long var1) {
      return (long)this.buffer.remaining() >= var1;
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

   private int readBuffer() {
      return this.bufferEmpty()?-1:this.buffer.get();
   }

   private int readBufferBytes(byte[] var1) {
      return this.readBufferBytes(var1, 0, var1.length);
   }

   private int readBufferBytes(byte[] var1, int var2, int var3) {
      if(this.bufferEmpty()) {
         return -1;
      } else {
         int var4 = this.buffer.remaining();
         this.buffer.get(var1, var2, var3);
         return var4 - this.buffer.remaining();
      }
   }

   public void addStreamCompleteListener(StreamCompleteListener var1) {
      this.listenerManager.addStreamCompleteListener(var1);
   }

   public int available() throws IOException {
      boolean var1 = this.enableBuffering;
      int var2 = 0;
      if(var1) {
         var2 = this.buffer.remaining();
      }

      int var4;
      try {
         var4 = this.impl.available();
      } catch (IOException var5) {
         this.notifyStreamError(var5);
         throw var5;
      }

      return var4 + var2;
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

   public void fillBuffer() {
      // $FF: Couldn't be decompiled
   }

   public String getBufferAsString() {
      // $FF: Couldn't be decompiled
   }

   public void mark(int var1) {
      if(this.markSupported()) {
         this.impl.mark(var1);
      }
   }

   public boolean markSupported() {
      return this.impl.markSupported();
   }

   public int read() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public int read(byte[] param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public int read(byte[] param1, int param2, int param3) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void removeStreamCompleteListener(StreamCompleteListener var1) {
      this.listenerManager.removeStreamCompleteListener(var1);
   }

   public void reset() throws IOException {
      if(this.markSupported()) {
         try {
            this.impl.reset();
         } catch (IOException var2) {
            this.notifyStreamError(var2);
            throw var2;
         }
      }
   }

   public void setBufferingEnabled(boolean var1) {
      this.enableBuffering = var1;
   }

   public long skip(long param1) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
