package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

public interface NetworkFetcher<FETCH_STATE extends FetchState> {
   FETCH_STATE createFetchState(Consumer<EncodedImage> var1, ProducerContext var2);

   void fetch(FETCH_STATE var1, NetworkFetcher.Callback var2);

   @Nullable
   Map<String, String> getExtraMap(FETCH_STATE var1, int var2);

   void onFetchCompletion(FETCH_STATE var1, int var2);

   boolean shouldPropagate(FETCH_STATE var1);

   public interface Callback {
      void onCancellation();

      void onFailure(Throwable var1);

      void onResponse(InputStream var1, int var2) throws IOException;
   }
}
