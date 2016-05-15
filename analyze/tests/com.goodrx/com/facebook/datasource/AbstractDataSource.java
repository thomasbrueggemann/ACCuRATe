package com.facebook.datasource;

import android.util.Pair;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public abstract class AbstractDataSource<T> implements DataSource<T> {
   @GuardedBy("this")
   private AbstractDataSource.DataSourceStatus mDataSourceStatus;
   @GuardedBy("this")
   private Throwable mFailureThrowable = null;
   @GuardedBy("this")
   private boolean mIsClosed = false;
   @GuardedBy("this")
   private float mProgress = 0.0F;
   @Nullable
   @GuardedBy("this")
   private T mResult = null;
   private final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> mSubscribers;

   protected AbstractDataSource() {
      this.mDataSourceStatus = AbstractDataSource.DataSourceStatus.IN_PROGRESS;
      this.mSubscribers = new ConcurrentLinkedQueue();
   }

   private void notifyDataSubscriber(final DataSubscriber<T> var1, Executor var2, final boolean var3, final boolean var4) {
      var2.execute(new Runnable() {
         public void run() {
            if(var3) {
               var1.onFailure(AbstractDataSource.this);
            } else if(var4) {
               var1.onCancellation(AbstractDataSource.this);
            } else {
               var1.onNewResult(AbstractDataSource.this);
            }
         }
      });
   }

   private void notifyDataSubscribers() {
      boolean var1 = this.hasFailed();
      boolean var2 = this.wasCancelled();
      Iterator var3 = this.mSubscribers.iterator();

      while(var3.hasNext()) {
         Pair var4 = (Pair)var3.next();
         this.notifyDataSubscriber((DataSubscriber)var4.first, (Executor)var4.second, var1, var2);
      }

   }

   private boolean setFailureInternal(Throwable param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean setProgressInternal(float param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean setResultInternal(@Nullable T param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean wasCancelled() {
      synchronized(this){}
      boolean var5 = false;

      boolean var2;
      label45: {
         boolean var3;
         try {
            var5 = true;
            if(!this.isClosed()) {
               var5 = false;
               break label45;
            }

            var3 = this.isFinished();
            var5 = false;
         } finally {
            if(var5) {
               ;
            }
         }

         if(!var3) {
            var2 = true;
            return var2;
         }
      }

      var2 = false;
      return var2;
   }

   public boolean close() {
      // $FF: Couldn't be decompiled
   }

   protected void closeResult(@Nullable T var1) {
   }

   @Nullable
   public Throwable getFailureCause() {
      synchronized(this){}

      Throwable var2;
      try {
         var2 = this.mFailureThrowable;
      } finally {
         ;
      }

      return var2;
   }

   public float getProgress() {
      synchronized(this){}

      float var2;
      try {
         var2 = this.mProgress;
      } finally {
         ;
      }

      return var2;
   }

   @Nullable
   public T getResult() {
      synchronized(this){}

      Object var2;
      try {
         var2 = this.mResult;
      } finally {
         ;
      }

      return var2;
   }

   public boolean hasFailed() {
      synchronized(this){}
      boolean var6 = false;

      AbstractDataSource.DataSourceStatus var2;
      AbstractDataSource.DataSourceStatus var3;
      try {
         var6 = true;
         var2 = this.mDataSourceStatus;
         var3 = AbstractDataSource.DataSourceStatus.FAILURE;
         var6 = false;
      } finally {
         if(var6) {
            ;
         }
      }

      boolean var4;
      if(var2 == var3) {
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   public boolean hasResult() {
      synchronized(this){}
      boolean var5 = false;

      Object var2;
      try {
         var5 = true;
         var2 = this.mResult;
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      boolean var3;
      if(var2 != null) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public boolean isClosed() {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.mIsClosed;
      } finally {
         ;
      }

      return var2;
   }

   public boolean isFinished() {
      synchronized(this){}
      boolean var6 = false;

      AbstractDataSource.DataSourceStatus var2;
      AbstractDataSource.DataSourceStatus var3;
      try {
         var6 = true;
         var2 = this.mDataSourceStatus;
         var3 = AbstractDataSource.DataSourceStatus.IN_PROGRESS;
         var6 = false;
      } finally {
         if(var6) {
            ;
         }
      }

      boolean var4;
      if(var2 != var3) {
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   protected void notifyProgressUpdate() {
      Iterator var1 = this.mSubscribers.iterator();

      while(var1.hasNext()) {
         Pair var2 = (Pair)var1.next();
         final DataSubscriber var3 = (DataSubscriber)var2.first;
         ((Executor)var2.second).execute(new Runnable() {
            public void run() {
               var3.onProgressUpdate(AbstractDataSource.this);
            }
         });
      }

   }

   protected boolean setFailure(Throwable var1) {
      boolean var2 = this.setFailureInternal(var1);
      if(var2) {
         this.notifyDataSubscribers();
      }

      return var2;
   }

   protected boolean setProgress(float var1) {
      boolean var2 = this.setProgressInternal(var1);
      if(var2) {
         this.notifyProgressUpdate();
      }

      return var2;
   }

   protected boolean setResult(@Nullable T var1, boolean var2) {
      boolean var3 = this.setResultInternal(var1, var2);
      if(var3) {
         this.notifyDataSubscribers();
      }

      return var3;
   }

   public void subscribe(DataSubscriber<T> param1, Executor param2) {
      // $FF: Couldn't be decompiled
   }

   private static enum DataSourceStatus {
      FAILURE,
      IN_PROGRESS,
      SUCCESS;

      static {
         AbstractDataSource.DataSourceStatus[] var0 = new AbstractDataSource.DataSourceStatus[]{IN_PROGRESS, SUCCESS, FAILURE};
      }
   }
}
