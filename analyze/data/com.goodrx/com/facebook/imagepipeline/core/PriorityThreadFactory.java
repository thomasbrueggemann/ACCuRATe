package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {
   private final int mThreadPriority;

   public PriorityThreadFactory(int var1) {
      this.mThreadPriority = var1;
   }

   public Thread newThread(final Runnable var1) {
      return new Thread(new Runnable() {
         public void run() {
            try {
               Process.setThreadPriority(PriorityThreadFactory.this.mThreadPriority);
            } catch (Throwable var2) {
               ;
            }

            var1.run();
         }
      });
   }
}
