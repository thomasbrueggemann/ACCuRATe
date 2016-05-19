package com.facebook.imagepipeline.datasource;

import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<T> {
   private ProducerToDataSourceAdapter(Producer<T> var1, SettableProducerContext var2, RequestListener var3) {
      super(var1, var2, var3);
   }

   public static <T> DataSource<T> create(Producer<T> var0, SettableProducerContext var1, RequestListener var2) {
      return new ProducerToDataSourceAdapter(var0, var1, var2);
   }
}
