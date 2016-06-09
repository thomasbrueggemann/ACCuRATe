package com.koushikdutta.async.http;

import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;

public class SimpleMiddleware implements AsyncHttpClientMiddleware {
   public Cancellable getSocket(AsyncHttpClientMiddleware.GetSocketData var1) {
      return null;
   }

   public void onBodyDecoder(AsyncHttpClientMiddleware.OnBodyData var1) {
   }

   public void onHeadersReceived(AsyncHttpClientMiddleware.OnHeadersReceivedData var1) {
   }

   public void onRequestComplete(AsyncHttpClientMiddleware.OnRequestCompleteData var1) {
   }

   public void onSocket(AsyncHttpClientMiddleware.OnSocketData var1) {
   }
}
