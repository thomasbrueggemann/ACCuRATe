package com.koushikdutta.ion.loader;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FileDataEmitter;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Loader;
import java.io.File;

public class FileLoader implements Loader {
   public Future<DataEmitter> load(final Ion var1, final AsyncHttpRequest var2, final FutureCallback<Loader.LoaderEmitter> var3) {
      if(!var2.getUri().getScheme().startsWith("file")) {
         return null;
      } else {
         final FileLoader.FileFuture var4 = new FileLoader.FileFuture(null);
         var1.getHttpClient().getServer().post(new Runnable() {
            public void run() {
               File var1x = new File(var2.getUri());
               FileDataEmitter var2x = new FileDataEmitter(var1.getHttpClient().getServer(), var1x);
               var4.setComplete(var2x);
               var3.onCompleted((Exception)null, new Loader.LoaderEmitter(var2x, (int)var1x.length(), 1, (RawHeaders)null, (AsyncHttpRequest)null));
            }
         });
         return var4;
      }
   }

   private static final class FileFuture extends SimpleFuture<DataEmitter> {
      private FileFuture() {
      }

      // $FF: synthetic method
      FileFuture(Object var1) {
         this();
      }
   }
}
