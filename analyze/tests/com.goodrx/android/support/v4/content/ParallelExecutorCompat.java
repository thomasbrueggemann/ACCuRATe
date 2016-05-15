package android.support.v4.content;

import android.os.Build.VERSION;
import android.support.v4.content.ExecutorCompatHoneycomb;
import android.support.v4.content.ModernAsyncTask;
import java.util.concurrent.Executor;

public final class ParallelExecutorCompat {
   public static Executor getParallelExecutor() {
      return VERSION.SDK_INT >= 11?ExecutorCompatHoneycomb.getParallelExecutor():ModernAsyncTask.THREAD_POOL_EXECUTOR;
   }
}
