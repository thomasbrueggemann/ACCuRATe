package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>> {
   private final DataSource<CloseableReference<T>>[] mDataSources;
   @GuardedBy("this")
   private int mFinishedDataSources;

   protected ListDataSource(DataSource<CloseableReference<T>>[] var1) {
      this.mDataSources = var1;
      this.mFinishedDataSources = 0;
   }

   public static <T> ListDataSource<T> create(DataSource... var0) {
      Preconditions.checkNotNull(var0);
      boolean var2;
      if(var0.length > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkState(var2);
      ListDataSource var3 = new ListDataSource(var0);
      int var4 = var0.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         DataSource var6 = var0[var5];
         if(var6 != null) {
            var6.subscribe(var3.new InternalDataSubscriber(), CallerThreadExecutor.getInstance());
         }
      }

      return var3;
   }

   private boolean increaseAndCheckIfLast() {
      synchronized(this){}
      boolean var6 = false;

      int var2;
      int var3;
      try {
         var6 = true;
         var2 = 1 + this.mFinishedDataSources;
         this.mFinishedDataSources = var2;
         var3 = this.mDataSources.length;
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

   private void onDataSourceCancelled() {
      this.setFailure(new CancellationException());
   }

   private void onDataSourceFailed(DataSource<CloseableReference<T>> var1) {
      this.setFailure(var1.getFailureCause());
   }

   private void onDataSourceFinished() {
      if(this.increaseAndCheckIfLast()) {
         this.setResult((Object)null, true);
      }

   }

   private void onDataSourceProgress() {
      float var1 = 0.0F;
      DataSource[] var2 = this.mDataSources;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 += var2[var4].getProgress();
      }

      this.setProgress(var1 / (float)this.mDataSources.length);
   }

   public boolean close() {
      if(!super.close()) {
         return false;
      } else {
         DataSource[] var1 = this.mDataSources;
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            var1[var3].close();
         }

         return true;
      }
   }

   @Nullable
   public List<CloseableReference<T>> getResult() {
      // $FF: Couldn't be decompiled
   }

   public boolean hasResult() {
      synchronized(this){}
      boolean var6 = false;

      boolean var2;
      label45: {
         int var3;
         int var4;
         try {
            var6 = true;
            if(this.isClosed()) {
               var6 = false;
               break label45;
            }

            var3 = this.mFinishedDataSources;
            var4 = this.mDataSources.length;
            var6 = false;
         } finally {
            if(var6) {
               ;
            }
         }

         if(var3 == var4) {
            var2 = true;
            return var2;
         }
      }

      var2 = false;
      return var2;
   }

   private class InternalDataSubscriber implements DataSubscriber<CloseableReference<T>> {
      @GuardedBy("InternalDataSubscriber.this")
      boolean mFinished;

      private InternalDataSubscriber() {
         this.mFinished = false;
      }

      // $FF: synthetic method
      InternalDataSubscriber(Object var2) {
         this();
      }

      private boolean tryFinish() {
         // $FF: Couldn't be decompiled
      }

      public void onCancellation(DataSource<CloseableReference<T>> var1) {
         ListDataSource.this.onDataSourceCancelled();
      }

      public void onFailure(DataSource<CloseableReference<T>> var1) {
         ListDataSource.this.onDataSourceFailed(var1);
      }

      public void onNewResult(DataSource<CloseableReference<T>> var1) {
         if(var1.isFinished() && this.tryFinish()) {
            ListDataSource.this.onDataSourceFinished();
         }

      }

      public void onProgressUpdate(DataSource<CloseableReference<T>> var1) {
         ListDataSource.this.onDataSourceProgress();
      }
   }
}
