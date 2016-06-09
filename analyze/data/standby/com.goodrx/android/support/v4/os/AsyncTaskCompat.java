package android.support.v4.os;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.v4.os.AsyncTaskCompatHoneycomb;

public final class AsyncTaskCompat {
   public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> executeParallel(AsyncTask<Params, Progress, Result> var0, Params... var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("task can not be null");
      } else if(VERSION.SDK_INT >= 11) {
         AsyncTaskCompatHoneycomb.executeParallel(var0, var1);
         return var0;
      } else {
         var0.execute(var1);
         return var0;
      }
   }
}
