package com.koushikdutta.async.http.socketio;

import com.koushikdutta.async.http.socketio.SocketIOClient;

public interface ConnectCallback {
   void onConnectCompleted(Exception var1, SocketIOClient var2);
}
