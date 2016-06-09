package com.koushikdutta.async.http.socketio;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.socketio.Acknowledge;
import com.koushikdutta.async.http.socketio.ConnectCallback;
import com.koushikdutta.async.http.socketio.DisconnectCallback;
import com.koushikdutta.async.http.socketio.ErrorCallback;
import com.koushikdutta.async.http.socketio.EventEmitter;
import com.koushikdutta.async.http.socketio.JSONCallback;
import com.koushikdutta.async.http.socketio.ReconnectCallback;
import com.koushikdutta.async.http.socketio.SocketIOConnection;
import com.koushikdutta.async.http.socketio.SocketIORequest;
import com.koushikdutta.async.http.socketio.StringCallback;
import org.json.JSONArray;
import org.json.JSONObject;

public class SocketIOClient extends EventEmitter {
   ConnectCallback connectCallback;
   boolean connected;
   SocketIOConnection connection;
   DisconnectCallback disconnectCallback;
   boolean disconnected;
   String endpoint;
   ErrorCallback errorCallback;
   JSONCallback jsonCallback;
   ReconnectCallback reconnectCallback;
   StringCallback stringCallback;

   private SocketIOClient(SocketIOConnection var1, String var2, ConnectCallback var3) {
      this.endpoint = var2;
      this.connection = var1;
      this.connectCallback = var3;
   }

   public static Future<SocketIOClient> connect(AsyncHttpClient var0, final SocketIORequest var1, final ConnectCallback var2) {
      Handler var3;
      if(Looper.myLooper() == null) {
         var3 = null;
      } else {
         var3 = var1.getHandler();
      }

      final SimpleFuture var4 = new SimpleFuture();
      final SocketIOConnection var5 = new SocketIOConnection(var3, var0, var1);
      ConnectCallback var6 = new ConnectCallback() {
         public void onConnectCompleted(Exception var1x, SocketIOClient var2x) {
            if(var1x == null && !TextUtils.isEmpty(var1.getEndpoint())) {
               var5.clients.remove(var2x);
               var2x.method_5(var1.getEndpoint(), new ConnectCallback() {
                  public void onConnectCompleted(Exception var1x, SocketIOClient var2x) {
                     if(var2 != null) {
                        var2.onConnectCompleted(var1x, var2x);
                     }

                     var4.setComplete(var1x, var2x);
                  }
               });
            } else {
               if(var2 != null) {
                  var2.onConnectCompleted(var1x, var2x);
               }

               var4.setComplete(var1x, var2x);
            }
         }
      };
      var5.clients.add(new SocketIOClient(var5, "", var6));
      var5.reconnect(var4);
      return var4;
   }

   public static Future<SocketIOClient> connect(AsyncHttpClient var0, String var1, ConnectCallback var2) {
      return connect(var0, new SocketIORequest(var1), var2);
   }

   private void emitRaw(int var1, String var2, Acknowledge var3) {
      this.connection.emitRaw(var1, this, var2, var3);
   }

   private static void reportError(SimpleFuture<SocketIOClient> var0, Handler var1, final ConnectCallback var2, final Exception var3) {
      if(var0.setComplete(var3)) {
         if(var1 != null) {
            AsyncServer.post(var1, new Runnable() {
               public void run() {
                  var2.onConnectCompleted(var3, (SocketIOClient)null);
               }
            });
         } else {
            var2.onConnectCompleted(var3, (SocketIOClient)null);
         }
      }
   }

   public void disconnect() {
      this.connection.disconnect(this);
      DisconnectCallback var1 = this.disconnectCallback;
      if(var1 != null) {
         var1.onDisconnect((Exception)null);
      }

   }

   public void emit(String var1) {
      this.emit(var1, (Acknowledge)null);
   }

   public void emit(String var1, Acknowledge var2) {
      this.emitRaw(3, var1, var2);
   }

   public void emit(String var1, JSONArray var2) {
      this.emit(var1, var2, (Acknowledge)null);
   }

   public void emit(String var1, JSONArray var2, Acknowledge var3) {
      JSONObject var4 = new JSONObject();

      try {
         var4.put("name", var1);
         var4.put("args", var2);
         this.emitRaw(5, var4.toString(), var3);
      } catch (Exception var6) {
         ;
      }
   }

   public void emit(JSONObject var1) {
      this.emit((JSONObject)var1, (Acknowledge)null);
   }

   public void emit(JSONObject var1, Acknowledge var2) {
      this.emitRaw(4, var1.toString(), var2);
   }

   public DisconnectCallback getDisconnectCallback() {
      return this.disconnectCallback;
   }

   public ErrorCallback getErrorCallback() {
      return this.errorCallback;
   }

   public JSONCallback getJSONCallback() {
      return this.jsonCallback;
   }

   public ReconnectCallback getReconnectCallback() {
      return this.reconnectCallback;
   }

   public StringCallback getStringCallback() {
      return this.stringCallback;
   }

   public WebSocket getWebSocket() {
      return this.connection.webSocket;
   }

   public boolean isConnected() {
      return this.connected && !this.disconnected && this.connection.isConnected();
   }

   // $FF: renamed from: of (java.lang.String, com.koushikdutta.async.http.socketio.ConnectCallback) void
   public void method_5(String var1, ConnectCallback var2) {
      this.connection.connect(new SocketIOClient(this.connection, var1, var2));
   }

   public void setDisconnectCallback(DisconnectCallback var1) {
      this.disconnectCallback = var1;
   }

   public void setErrorCallback(ErrorCallback var1) {
      this.errorCallback = var1;
   }

   public void setJSONCallback(JSONCallback var1) {
      this.jsonCallback = var1;
   }

   public void setReconnectCallback(ReconnectCallback var1) {
      this.reconnectCallback = var1;
   }

   public void setStringCallback(StringCallback var1) {
      this.stringCallback = var1;
   }
}
