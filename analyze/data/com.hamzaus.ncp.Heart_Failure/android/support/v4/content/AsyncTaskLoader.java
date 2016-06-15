package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.Loader;
import android.support.v4.content.ModernAsyncTask;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
   static final boolean DEBUG = false;
   static final String TAG = "AsyncTaskLoader";
   volatile AsyncTaskLoader<D>.LoadTask mCancellingTask;
   Handler mHandler;
   long mLastLoadCompleteTime = -10000L;
   volatile AsyncTaskLoader<D>.LoadTask mTask;
   long mUpdateThrottle;

   public AsyncTaskLoader(Context var1) {
      super(var1);
   }

   public boolean cancelLoad() {
      if(this.mTask != null) {
         if(this.mCancellingTask == null) {
            if(this.mTask.waiting) {
               this.mTask.waiting = false;
               this.mHandler.removeCallbacks(this.mTask);
               this.mTask = null;
               return false;
            }

            boolean var1 = this.mTask.cancel(false);
            if(var1) {
               this.mCancellingTask = this.mTask;
            }

            this.mTask = null;
            return var1;
         }

         if(this.mTask.waiting) {
            this.mTask.waiting = false;
            this.mHandler.removeCallbacks(this.mTask);
         }

         this.mTask = null;
      }

      return false;
   }

   void dispatchOnCancelled(AsyncTaskLoader<D>.LoadTask var1, D var2) {
      this.onCanceled(var2);
      if(this.mCancellingTask == var1) {
         this.rollbackContentChanged();
         this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
         this.mCancellingTask = null;
         this.executePendingTask();
      }

   }

   void dispatchOnLoadComplete(AsyncTaskLoader<D>.LoadTask var1, D var2) {
      if(this.mTask != var1) {
         this.dispatchOnCancelled(var1, var2);
      } else if(this.isAbandoned()) {
         this.onCanceled(var2);
      } else {
         this.commitContentChanged();
         this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
         this.mTask = null;
         this.deliverResult(var2);
      }
   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      super.dump(var1, var2, var3, var4);
      if(this.mTask != null) {
         var3.print(var1);
         var3.print("mTask=");
         var3.print(this.mTask);
         var3.print(" waiting=");
         var3.println(this.mTask.waiting);
      }

      if(this.mCancellingTask != null) {
         var3.print(var1);
         var3.print("mCancellingTask=");
         var3.print(this.mCancellingTask);
         var3.print(" waiting=");
         var3.println(this.mCancellingTask.waiting);
      }

      if(this.mUpdateThrottle != 0L) {
         var3.print(var1);
         var3.print("mUpdateThrottle=");
         TimeUtils.formatDuration(this.mUpdateThrottle, var3);
         var3.print(" mLastLoadCompleteTime=");
         TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), var3);
         var3.println();
      }

   }

   void executePendingTask() {
      if(this.mCancellingTask == null && this.mTask != null) {
         if(this.mTask.waiting) {
            this.mTask.waiting = false;
            this.mHandler.removeCallbacks(this.mTask);
         }

         if(this.mUpdateThrottle <= 0L || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
            this.mTask.executeOnExecutor(ModernAsyncTask.THREAD_POOL_EXECUTOR, (Void[])null);
            return;
         }

         this.mTask.waiting = true;
         this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
      }

   }

   public abstract D loadInBackground();

   public void onCanceled(D var1) {
   }

   protected void onForceLoad() {
      super.onForceLoad();
      this.cancelLoad();
      this.mTask = new AsyncTaskLoader.LoadTask();
      this.executePendingTask();
   }

   protected D onLoadInBackground() {
      return this.loadInBackground();
   }

   public void setUpdateThrottle(long var1) {
      this.mUpdateThrottle = var1;
      if(var1 != 0L) {
         this.mHandler = new Handler();
      }

   }

   public void waitForLoader() {
      AsyncTaskLoader.LoadTask var1 = this.mTask;
      if(var1 != null) {
         try {
            var1.done.await();
         } catch (InterruptedException var3) {
            return;
         }
      }

   }

   final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
      private CountDownLatch done = new CountDownLatch(1);
      D result;
      boolean waiting;

      protected D doInBackground(Void... var1) {
         this.result = AsyncTaskLoader.this.onLoadInBackground();
         return this.result;
      }

      protected void onCancelled() {
         try {
            AsyncTaskLoader.this.dispatchOnCancelled(this, this.result);
         } finally {
            this.done.countDown();
         }

      }

      protected void onPostExecute(D var1) {
         try {
            AsyncTaskLoader.this.dispatchOnLoadComplete(this, var1);
         } finally {
            this.done.countDown();
         }

      }

      public void run() {
         this.waiting = false;
         AsyncTaskLoader.this.executePendingTask();
      }
   }
}
