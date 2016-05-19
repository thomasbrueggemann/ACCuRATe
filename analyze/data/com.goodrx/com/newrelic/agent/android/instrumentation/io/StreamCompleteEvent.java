package com.newrelic.agent.android.instrumentation.io;

import java.util.EventObject;

public final class StreamCompleteEvent extends EventObject {
   private static final long serialVersionUID = 1L;
   private final long bytes;
   private final Exception exception;

   public StreamCompleteEvent(Object var1, long var2) {
      this(var1, var2, (Exception)null);
   }

   public StreamCompleteEvent(Object var1, long var2, Exception var4) {
      super(var1);
      this.bytes = var2;
      this.exception = var4;
   }

   public long getBytes() {
      return this.bytes;
   }

   public Exception getException() {
      return this.exception;
   }

   public boolean isError() {
      return this.exception != null;
   }
}
