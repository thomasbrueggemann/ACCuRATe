package com.koushikdutta.ion.loader;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Loader;

public class ContentLoader implements Loader {
   public Future<DataEmitter> load(final Ion var1, final AsyncHttpRequest var2, final FutureCallback<Loader.LoaderEmitter> var3) {
      if(!var2.getUri().getScheme().startsWith("content")) {
         return null;
      } else {
         final ContentLoader.InputStreamDataEmitterFuture var4 = new ContentLoader.InputStreamDataEmitterFuture(null);
         var1.getHttpClient().getServer().post(new Runnable() {
            public void run() {
               // $FF: Couldn't be decompiled
            }
         });
         return var4;
      }
   }

   private static final class InputStreamDataEmitterFuture extends SimpleFuture<DataEmitter> {
      private InputStreamDataEmitterFuture() {
      }

      // $FF: synthetic method
      InputStreamDataEmitterFuture(Object var1) {
         this();
      }
   }
}
