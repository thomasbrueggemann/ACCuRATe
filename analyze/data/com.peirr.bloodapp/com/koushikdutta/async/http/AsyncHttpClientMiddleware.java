package com.koushikdutta.async.http;

import android.os.Bundle;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.libcore.ResponseHeaders;

public interface AsyncHttpClientMiddleware {
   Cancellable getSocket(AsyncHttpClientMiddleware.GetSocketData var1);

   void onBodyDecoder(AsyncHttpClientMiddleware.OnBodyData var1);

   void onHeadersReceived(AsyncHttpClientMiddleware.OnHeadersReceivedData var1);

   void onRequestComplete(AsyncHttpClientMiddleware.OnRequestCompleteData var1);

   void onSocket(AsyncHttpClientMiddleware.OnSocketData var1);

   public static class GetSocketData {
      public ConnectCallback connectCallback;
      public AsyncHttpRequest request;
      public Cancellable socketCancellable;
      public Bundle state = new Bundle();
   }

   public static class OnBodyData extends AsyncHttpClientMiddleware.OnHeadersReceivedData {
      public DataEmitter bodyEmitter;
   }

   public static class OnHeadersReceivedData extends AsyncHttpClientMiddleware.OnSocketData {
      public ResponseHeaders headers;
   }

   public static class OnRequestCompleteData extends AsyncHttpClientMiddleware.OnBodyData {
      public Exception exception;
   }

   public static class OnSocketData extends AsyncHttpClientMiddleware.GetSocketData {
      public AsyncSocket socket;
   }
}
