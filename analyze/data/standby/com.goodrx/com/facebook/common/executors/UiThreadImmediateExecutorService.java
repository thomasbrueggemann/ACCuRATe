package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.executors.HandlerExecutorServiceImpl;

public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {
   private static UiThreadImmediateExecutorService sInstance = null;

   private UiThreadImmediateExecutorService() {
      super(new Handler(Looper.getMainLooper()));
   }

   public static UiThreadImmediateExecutorService getInstance() {
      if(sInstance == null) {
         sInstance = new UiThreadImmediateExecutorService();
      }

      return sInstance;
   }

   public void execute(Runnable var1) {
      if(this.isHandlerThread()) {
         var1.run();
      } else {
         super.execute(var1);
      }
   }
}
