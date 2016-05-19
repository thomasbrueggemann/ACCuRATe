package com.facebook.common.executors;

import com.facebook.common.executors.ConstrainedExecutorService;
import com.facebook.common.executors.SerialExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class DefaultSerialExecutorService extends ConstrainedExecutorService implements SerialExecutorService {
   public DefaultSerialExecutorService(Executor var1) {
      super("SerialExecutor", 1, var1, new LinkedBlockingQueue());
   }

   public void execute(Runnable var1) {
      synchronized(this){}

      try {
         super.execute(var1);
      } finally {
         ;
      }

   }
}
