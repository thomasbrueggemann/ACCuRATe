package bolts;

import bolts.AndroidExecutors;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class BoltsExecutors {
   private static final BoltsExecutors INSTANCE = new BoltsExecutors();
   private final ExecutorService background;
   private final Executor immediate;
   private final ScheduledExecutorService scheduled;

   private BoltsExecutors() {
      ExecutorService var1;
      if(!isAndroidRuntime()) {
         var1 = Executors.newCachedThreadPool();
      } else {
         var1 = AndroidExecutors.newCachedThreadPool();
      }

      this.background = var1;
      this.scheduled = Executors.newSingleThreadScheduledExecutor();
      this.immediate = new BoltsExecutors.ImmediateExecutor();
   }

   public static ExecutorService background() {
      return INSTANCE.background;
   }

   static Executor immediate() {
      return INSTANCE.immediate;
   }

   private static boolean isAndroidRuntime() {
      String var0 = System.getProperty("java.runtime.name");
      return var0 == null?false:var0.toLowerCase(Locale.US).contains("android");
   }

   private static class ImmediateExecutor implements Executor {
      private ThreadLocal<Integer> executionDepth;

      private ImmediateExecutor() {
         this.executionDepth = new ThreadLocal();
      }

      // $FF: synthetic method
      ImmediateExecutor(Object var1) {
         this();
      }

      private int decrementDepth() {
         Integer var1 = (Integer)this.executionDepth.get();
         if(var1 == null) {
            var1 = Integer.valueOf(0);
         }

         int var2 = -1 + var1.intValue();
         if(var2 == 0) {
            this.executionDepth.remove();
            return var2;
         } else {
            this.executionDepth.set(Integer.valueOf(var2));
            return var2;
         }
      }

      private int incrementDepth() {
         Integer var1 = (Integer)this.executionDepth.get();
         if(var1 == null) {
            var1 = Integer.valueOf(0);
         }

         int var2 = 1 + var1.intValue();
         this.executionDepth.set(Integer.valueOf(var2));
         return var2;
      }

      public void execute(Runnable param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
