package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class BaseNetworkFetcher<FETCH_STATE extends FetchState> implements NetworkFetcher<FETCH_STATE> {
   @Nullable
   public Map<String, String> getExtraMap(FETCH_STATE var1, int var2) {
      return null;
   }

   public void onFetchCompletion(FETCH_STATE var1, int var2) {
   }

   public boolean shouldPropagate(FETCH_STATE var1) {
      return true;
   }
}
