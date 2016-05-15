package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CloseableProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<CloseableReference<T>> {
   private CloseableProducerToDataSourceAdapter(Producer<CloseableReference<T>> var1, SettableProducerContext var2, RequestListener var3) {
      super(var1, var2, var3);
   }

   public static <T> DataSource<CloseableReference<T>> create(Producer<CloseableReference<T>> var0, SettableProducerContext var1, RequestListener var2) {
      return new CloseableProducerToDataSourceAdapter(var0, var1, var2);
   }

   protected void closeResult(CloseableReference<T> var1) {
      CloseableReference.closeSafely(var1);
   }

   @Nullable
   public CloseableReference<T> getResult() {
      return CloseableReference.cloneOrNull((CloseableReference)super.getResult());
   }

   protected void onNewResultImpl(CloseableReference<T> var1, boolean var2) {
      super.onNewResultImpl(CloseableReference.cloneOrNull(var1), var2);
   }
}
