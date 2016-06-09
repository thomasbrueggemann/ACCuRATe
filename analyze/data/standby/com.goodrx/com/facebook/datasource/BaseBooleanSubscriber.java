package com.facebook.datasource;

import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;

public abstract class BaseBooleanSubscriber implements DataSubscriber<Boolean> {
   public void onCancellation(DataSource<Boolean> var1) {
   }

   public void onFailure(DataSource<Boolean> var1) {
      try {
         this.onFailureImpl(var1);
      } finally {
         var1.close();
      }

   }

   protected abstract void onFailureImpl(DataSource<Boolean> var1);

   public void onNewResult(DataSource<Boolean> var1) {
      try {
         this.onNewResultImpl(((Boolean)var1.getResult()).booleanValue());
      } finally {
         var1.close();
      }

   }

   protected abstract void onNewResultImpl(boolean var1);

   public void onProgressUpdate(DataSource<Boolean> var1) {
   }
}
