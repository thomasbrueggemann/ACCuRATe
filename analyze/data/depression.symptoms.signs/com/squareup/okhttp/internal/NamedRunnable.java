package com.squareup.okhttp.internal;

public abstract class NamedRunnable implements Runnable {
   private final String name;

   public NamedRunnable(String var1, Object... var2) {
      this.name = String.format(var1, var2);
   }

   protected abstract void execute();

   public final void run() {
      String var1 = Thread.currentThread().getName();
      Thread.currentThread().setName(this.name);

      try {
         this.execute();
      } finally {
         Thread.currentThread().setName(var1);
      }

   }
}
