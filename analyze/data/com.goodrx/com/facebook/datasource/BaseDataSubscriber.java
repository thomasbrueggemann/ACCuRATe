package com.facebook.datasource;

import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;

public abstract class BaseDataSubscriber<T> implements DataSubscriber<T> {
   public void onCancellation(DataSource<T> var1) {
   }

   public void onFailure(DataSource<T> var1) {
      try {
         this.onFailureImpl(var1);
      } finally {
         var1.close();
      }

   }

   protected abstract void onFailureImpl(DataSource<T> var1);

   public void onNewResult(DataSource<T> var1) {
      boolean var2 = var1.isFinished();

      try {
         this.onNewResultImpl(var1);
      } finally {
         if(var2) {
            var1.close();
         }

      }

   }

   protected abstract void onNewResultImpl(DataSource<T> var1);

   public void onProgressUpdate(DataSource<T> var1) {
   }
}
