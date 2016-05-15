package bolts;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class AndroidExecutors {
   static final int CORE_POOL_SIZE;
   private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
   private static final AndroidExecutors INSTANCE = new AndroidExecutors();
   static final int MAX_POOL_SIZE;
   private final Executor uiThread = new AndroidExecutors.UIThreadExecutor();

   static {
      CORE_POOL_SIZE = 1 + CPU_COUNT;
      MAX_POOL_SIZE = 1 + 2 * CPU_COUNT;
   }

   @SuppressLint({"NewApi"})
   public static void allowCoreThreadTimeout(ThreadPoolExecutor var0, boolean var1) {
      if(VERSION.SDK_INT >= 9) {
         var0.allowCoreThreadTimeOut(var1);
      }

   }

   public static ExecutorService newCachedThreadPool() {
      ThreadPoolExecutor var0 = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
      allowCoreThreadTimeout(var0, true);
      return var0;
   }

   public static Executor uiThread() {
      return INSTANCE.uiThread;
   }

   private static class UIThreadExecutor implements Executor {
      private UIThreadExecutor() {
      }

      // $FF: synthetic method
      UIThreadExecutor(Object var1) {
         this();
      }

      public void execute(Runnable var1) {
         (new Handler(Looper.getMainLooper())).post(var1);
      }
   }
}
