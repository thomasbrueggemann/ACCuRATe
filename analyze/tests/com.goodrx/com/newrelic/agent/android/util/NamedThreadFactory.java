package com.newrelic.agent.android.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {
   final ThreadGroup group;
   final String namePrefix;
   final AtomicInteger threadNumber = new AtomicInteger(1);

   public NamedThreadFactory(String var1) {
      SecurityManager var2 = System.getSecurityManager();
      ThreadGroup var3;
      if(var2 != null) {
         var3 = var2.getThreadGroup();
      } else {
         var3 = Thread.currentThread().getThreadGroup();
      }

      this.group = var3;
      this.namePrefix = "NR_" + var1 + "-";
   }

   public Thread newThread(Runnable var1) {
      Thread var2 = new Thread(this.group, var1, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
      if(var2.isDaemon()) {
         var2.setDaemon(false);
      }

      if(var2.getPriority() != 5) {
         var2.setPriority(5);
      }

      return var2;
   }
}
