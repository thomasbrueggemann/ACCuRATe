package android.support.v4.os;

import android.os.AsyncTask;

class AsyncTaskCompatHoneycomb {
   static <Params, Progress, Result> void executeParallel(AsyncTask<Params, Progress, Result> var0, Params... var1) {
      var0.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, var1);
   }
}
