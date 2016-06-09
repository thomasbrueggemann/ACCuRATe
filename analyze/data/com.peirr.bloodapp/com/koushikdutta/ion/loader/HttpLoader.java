package com.koushikdutta.ion.loader;

import android.text.TextUtils;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.callback.HttpConnectCallback;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Loader;

public class HttpLoader implements Loader {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;

   static {
      boolean var0;
      if(!HttpLoader.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public Future<DataEmitter> load(Ion var1, AsyncHttpRequest var2, final FutureCallback<Loader.LoaderEmitter> var3) {
      if(!var2.getUri().getScheme().startsWith("http")) {
         return null;
      } else if(!$assertionsDisabled && var2.getHandler() != null) {
         throw new AssertionError();
      } else {
         return var1.getHttpClient().execute(var2, new HttpConnectCallback() {
            public void onConnectCompleted(Exception var1, AsyncHttpResponse var2) {
               int var3x = -1;
               byte var4 = 3;
               RawHeaders var5 = null;
               AsyncHttpRequest var6 = null;
               if(var2 != null) {
                  var6 = var2.getRequest();
                  var5 = var2.getHeaders().getHeaders();
                  var3x = var2.getHeaders().getContentLength();
                  String var7 = var2.getHeaders().getHeaders().get("X-Served-From");
                  if(TextUtils.equals(var7, "cache")) {
                     var4 = 1;
                  } else if(TextUtils.equals(var7, "conditional-cache")) {
                     var4 = 2;
                  }
               }

               var3.onCompleted(var1, new Loader.LoaderEmitter(var2, var3x, var4, var5, var6));
            }
         });
      }
   }
}
