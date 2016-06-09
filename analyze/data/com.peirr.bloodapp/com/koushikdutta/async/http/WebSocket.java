package com.koushikdutta.async.http;

import com.koushikdutta.async.AsyncSocket;

public interface WebSocket extends AsyncSocket {
   AsyncSocket getSocket();

   WebSocket.StringCallback getStringCallback();

   boolean isBuffering();

   void send(String var1);

   void send(byte[] var1);

   void setStringCallback(WebSocket.StringCallback var1);

   public interface StringCallback {
      void onStringAvailable(String var1);
   }
}
