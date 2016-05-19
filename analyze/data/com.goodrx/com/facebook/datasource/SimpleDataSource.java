package com.facebook.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;

public class SimpleDataSource<T> extends AbstractDataSource<T> {
   public static <T> SimpleDataSource<T> create() {
      return new SimpleDataSource();
   }

   public boolean setFailure(Throwable var1) {
      return super.setFailure((Throwable)Preconditions.checkNotNull(var1));
   }

   public boolean setProgress(float var1) {
      return super.setProgress(var1);
   }

   public boolean setResult(T var1) {
      return super.setResult(Preconditions.checkNotNull(var1), true);
   }

   public boolean setResult(T var1, boolean var2) {
      return super.setResult(Preconditions.checkNotNull(var1), var2);
   }
}
