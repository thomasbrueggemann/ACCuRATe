package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class FirstAvailableDataSourceSupplier<T> implements Supplier<DataSource<T>> {
   private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

   private FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> var1) {
      boolean var2;
      if(!var1.isEmpty()) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2, "List of suppliers is empty!");
      this.mDataSourceSuppliers = var1;
   }

   public static <T> FirstAvailableDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> var0) {
      return new FirstAvailableDataSourceSupplier(var0);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof FirstAvailableDataSourceSupplier)) {
         return false;
      } else {
         FirstAvailableDataSourceSupplier var2 = (FirstAvailableDataSourceSupplier)var1;
         return Objects.equal(this.mDataSourceSuppliers, var2.mDataSourceSuppliers);
      }
   }

   public DataSource<T> get() {
      return new FirstAvailableDataSourceSupplier.FirstAvailableDataSource();
   }

   public int hashCode() {
      return this.mDataSourceSuppliers.hashCode();
   }

   public String toString() {
      return Objects.toStringHelper((Object)this).add("list", this.mDataSourceSuppliers).toString();
   }

   @ThreadSafe
   private class FirstAvailableDataSource extends AbstractDataSource<T> {
      private DataSource<T> mCurrentDataSource = null;
      private DataSource<T> mDataSourceWithResult = null;
      private int mIndex = 0;

      public FirstAvailableDataSource() {
         if(!this.startNextDataSource()) {
            this.setFailure(new RuntimeException("No data source supplier or supplier returned null."));
         }

      }

      private boolean clearCurrentDataSource(DataSource<T> param1) {
         // $FF: Couldn't be decompiled
      }

      private void closeSafely(DataSource<T> var1) {
         if(var1 != null) {
            var1.close();
         }

      }

      @Nullable
      private DataSource<T> getDataSourceWithResult() {
         synchronized(this){}

         DataSource var2;
         try {
            var2 = this.mDataSourceWithResult;
         } finally {
            ;
         }

         return var2;
      }

      @Nullable
      private Supplier<DataSource<T>> getNextSupplier() {
         synchronized(this){}
         boolean var6 = false;

         Supplier var2;
         try {
            var6 = true;
            if(!this.isClosed()) {
               if(this.mIndex < FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers.size()) {
                  List var3 = FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers;
                  int var4 = this.mIndex;
                  this.mIndex = var4 + 1;
                  var2 = (Supplier)var3.get(var4);
                  var6 = false;
                  return var2;
               }

               var6 = false;
            } else {
               var6 = false;
            }
         } finally {
            if(var6) {
               ;
            }
         }

         var2 = null;
         return var2;
      }

      private void maybeSetDataSourceWithResult(DataSource<T> param1, boolean param2) {
         // $FF: Couldn't be decompiled
      }

      private void onDataSourceFailed(DataSource<T> var1) {
         if(this.clearCurrentDataSource(var1)) {
            if(var1 != this.getDataSourceWithResult()) {
               this.closeSafely(var1);
            }

            if(!this.startNextDataSource()) {
               this.setFailure(var1.getFailureCause());
               return;
            }
         }

      }

      private void onDataSourceNewResult(DataSource<T> var1) {
         this.maybeSetDataSourceWithResult(var1, var1.isFinished());
         if(var1 == this.getDataSourceWithResult()) {
            this.setResult((Object)null, var1.isFinished());
         }

      }

      private boolean setCurrentDataSource(DataSource<T> param1) {
         // $FF: Couldn't be decompiled
      }

      private boolean startNextDataSource() {
         Supplier var1 = this.getNextSupplier();
         DataSource var2;
         if(var1 != null) {
            var2 = (DataSource)var1.get();
         } else {
            var2 = null;
         }

         if(this.setCurrentDataSource(var2) && var2 != null) {
            var2.subscribe(new FirstAvailableDataSourceSupplier.InternalDataSubscriber(), CallerThreadExecutor.getInstance());
            return true;
         } else {
            this.closeSafely(var2);
            return false;
         }
      }

      public boolean close() {
         // $FF: Couldn't be decompiled
      }

      @Nullable
      public T getResult() {
         // $FF: Couldn't be decompiled
      }

      public boolean hasResult() {
         // $FF: Couldn't be decompiled
      }
   }

   private class InternalDataSubscriber implements DataSubscriber<T> {
      private InternalDataSubscriber() {
      }

      // $FF: synthetic method
      InternalDataSubscriber(Object var2) {
         this();
      }

      public void onCancellation(DataSource<T> var1) {
      }

      public void onFailure(DataSource<T> var1) {
         FirstAvailableDataSourceSupplier.super.onDataSourceFailed(var1);
      }

      public void onNewResult(DataSource<T> var1) {
         if(var1.hasResult()) {
            FirstAvailableDataSourceSupplier.super.onDataSourceNewResult(var1);
         } else if(var1.isFinished()) {
            FirstAvailableDataSourceSupplier.super.onDataSourceFailed(var1);
            return;
         }

      }

      public void onProgressUpdate(DataSource<T> var1) {
         float var2 = FirstAvailableDataSourceSupplier.this.getProgress();
         FirstAvailableDataSourceSupplier.this.setProgress(Math.max(var2, var1.getProgress()));
      }
   }
}
