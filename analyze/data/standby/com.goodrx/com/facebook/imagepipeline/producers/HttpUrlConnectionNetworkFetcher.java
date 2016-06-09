package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<FetchState> {
   private static final int NUM_NETWORK_THREADS = 3;
   private final ExecutorService mExecutorService = Executors.newFixedThreadPool(3);

   public FetchState createFetchState(Consumer<EncodedImage> var1, ProducerContext var2) {
      return new FetchState(var1, var2);
   }

   public void fetch(final FetchState var1, final NetworkFetcher.Callback var2) {
      final Future var3 = this.mExecutorService.submit(new Runnable() {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      });
      var1.getContext().addCallbacks(new BaseProducerContextCallbacks() {
         public void onCancellationRequested() {
            if(var3.cancel(false)) {
               var2.onCancellation();
            }

         }
      });
   }
}
