package com.koushikdutta.async.callback;

import com.koushikdutta.async.AsyncSocket;

public interface ConnectCallback {
   void onConnectCompleted(Exception var1, AsyncSocket var2);
}
