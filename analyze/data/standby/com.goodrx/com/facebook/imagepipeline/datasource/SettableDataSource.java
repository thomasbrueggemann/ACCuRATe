package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class SettableDataSource<T> extends AbstractDataSource<CloseableReference<T>> {
   public static <V> SettableDataSource<V> create() {
      return new SettableDataSource();
   }

   protected void closeResult(@Nullable CloseableReference<T> var1) {
      CloseableReference.closeSafely(var1);
   }

   @Nullable
   public CloseableReference<T> getResult() {
      return CloseableReference.cloneOrNull((CloseableReference)super.getResult());
   }

   public boolean set(@Nullable CloseableReference<T> var1) {
      return super.setResult(CloseableReference.cloneOrNull(var1), true);
   }

   public boolean setException(Throwable var1) {
      return super.setFailure(var1);
   }

   public boolean setProgress(float var1) {
      return super.setProgress(var1);
   }
}
