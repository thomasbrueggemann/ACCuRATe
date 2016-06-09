package com.koushikdutta.async.callback;

import com.koushikdutta.async.AsyncServerSocket;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.callback.CompletedCallback;

public interface ListenCallback extends CompletedCallback {
   void onAccepted(AsyncSocket var1);

   void onListening(AsyncServerSocket var1);
}
