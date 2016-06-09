package com.koushikdutta.async.http;

import android.util.Base64;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.HybiParser;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.UUID;

public class WebSocketImpl implements WebSocket {
   static final String MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
   private DataCallback mDataCallback;
   CompletedCallback mExceptionCallback;
   HybiParser mParser;
   BufferedDataSink mSink;
   private AsyncSocket mSocket;
   private WebSocket.StringCallback mStringCallback;
   private LinkedList<ByteBufferList> pending;

   public WebSocketImpl(AsyncSocket var1) {
      this.mSocket = var1;
      this.mSink = new BufferedDataSink(this.mSocket);
   }

   public WebSocketImpl(AsyncHttpServerRequest var1, AsyncHttpServerResponse var2) {
      this(var1.getSocket());
      String var3 = var1.getHeaders().getHeaders().get("Sec-WebSocket-Key");
      String var4 = SHA1(var3 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
      var1.getHeaders().getHeaders().get("Origin");
      var2.responseCode(101);
      var2.getHeaders().getHeaders().set("Upgrade", "WebSocket");
      var2.getHeaders().getHeaders().set("Connection", "Upgrade");
      var2.getHeaders().getHeaders().set("Sec-WebSocket-Accept", var4);
      var2.writeHead();
      this.setupParser(false);
   }

   private static String SHA1(String var0) {
      try {
         MessageDigest var2 = MessageDigest.getInstance("SHA-1");
         var2.update(var0.getBytes("iso-8859-1"), 0, var0.length());
         String var3 = Base64.encodeToString(var2.digest(), 0);
         return var3;
      } catch (Exception var4) {
         return null;
      }
   }

   private void addAndEmit(ByteBufferList var1) {
      if(this.pending == null) {
         Util.emitAllData(this, var1);
         if(var1.remaining() > 0) {
            this.pending = new LinkedList();
            this.pending.add(var1);
         }
      } else {
         while(true) {
            if(this.isPaused()) {
               if(this.pending.size() == 0) {
                  this.pending = null;
                  return;
               }
               break;
            }

            ByteBufferList var2 = (ByteBufferList)this.pending.remove();
            Util.emitAllData(this, var2);
            if(var2.remaining() > 0) {
               this.pending.add(0, var2);
            }
         }
      }

   }

   public static void addWebSocketUpgradeHeaders(AsyncHttpRequest var0, String var1) {
      RawHeaders var2 = var0.getHeaders().getHeaders();
      String var3 = Base64.encodeToString(toByteArray(UUID.randomUUID()), 2);
      var2.set("Sec-WebSocket-Version", "13");
      var2.set("Sec-WebSocket-Key", var3);
      var2.set("Connection", "Upgrade");
      var2.set("Upgrade", "websocket");
      if(var1 != null) {
         var2.set("Sec-WebSocket-Protocol", var1);
      }

      var2.set("Pragma", "no-cache");
      var2.set("Cache-Control", "no-cache");
      var0.getHeaders().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.15 Safari/537.36");
   }

   public static WebSocket finishHandshake(RawHeaders var0, AsyncHttpResponse var1) {
      if(var1 != null && var1.getHeaders().getHeaders().getResponseCode() == 101 && "websocket".equalsIgnoreCase(var1.getHeaders().getHeaders().get("Upgrade"))) {
         String var2 = var1.getHeaders().getHeaders().get("Sec-WebSocket-Accept");
         if(var2 != null) {
            String var3 = var0.get("Sec-WebSocket-Key");
            if(var3 != null && var2.equalsIgnoreCase(SHA1(var3 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").trim())) {
               WebSocketImpl var4 = new WebSocketImpl(var1.detachSocket());
               var4.setupParser(true);
               return var4;
            }
         }
      }

      return null;
   }

   private void setupParser(boolean var1) {
      this.mParser = new HybiParser(this.mSocket) {
         protected void onDisconnect(int var1, String var2) {
            WebSocketImpl.this.mSocket.close();
         }

         protected void onMessage(String var1) {
            if(WebSocketImpl.this.mStringCallback != null) {
               WebSocketImpl.this.mStringCallback.onStringAvailable(var1);
            }

         }

         protected void onMessage(byte[] var1) {
            WebSocketImpl.this.addAndEmit(new ByteBufferList(var1));
         }

         protected void report(Exception var1) {
            if(WebSocketImpl.this.mExceptionCallback != null) {
               WebSocketImpl.this.mExceptionCallback.onCompleted(var1);
            }

         }

         protected void sendFrame(byte[] var1) {
            WebSocketImpl.this.mSink.write(ByteBuffer.wrap(var1));
         }
      };
      this.mParser.setMasking(var1);
      if(this.mSocket.isPaused()) {
         this.mSocket.resume();
      }

   }

   private static byte[] toByteArray(UUID var0) {
      byte[] var1 = new byte[16];
      LongBuffer var2 = ByteBuffer.wrap(var1).asLongBuffer();
      long[] var3 = new long[]{var0.getMostSignificantBits(), var0.getLeastSignificantBits()};
      var2.put(var3);
      return var1;
   }

   public void close() {
      this.mSocket.close();
   }

   public void end() {
      this.mSocket.end();
   }

   public CompletedCallback getClosedCallback() {
      return this.mSocket.getClosedCallback();
   }

   public DataCallback getDataCallback() {
      return this.mDataCallback;
   }

   public CompletedCallback getEndCallback() {
      return this.mExceptionCallback;
   }

   public AsyncServer getServer() {
      return this.mSocket.getServer();
   }

   public AsyncSocket getSocket() {
      return this.mSocket;
   }

   public WebSocket.StringCallback getStringCallback() {
      return this.mStringCallback;
   }

   public WritableCallback getWriteableCallback() {
      return this.mSink.getWriteableCallback();
   }

   public boolean isBuffering() {
      return this.mSink.remaining() > 0;
   }

   public boolean isChunked() {
      return false;
   }

   public boolean isOpen() {
      return this.mSocket.isOpen();
   }

   public boolean isPaused() {
      return this.mSocket.isPaused();
   }

   public void pause() {
      this.mSocket.pause();
   }

   public void resume() {
      this.mSocket.resume();
   }

   public void send(String var1) {
      this.mSink.write(ByteBuffer.wrap(this.mParser.frame(var1)));
   }

   public void send(byte[] var1) {
      this.mSink.write(ByteBuffer.wrap(this.mParser.frame(var1)));
   }

   public void setClosedCallback(CompletedCallback var1) {
      this.mSocket.setClosedCallback(var1);
   }

   public void setDataCallback(DataCallback var1) {
      this.mDataCallback = var1;
   }

   public void setEndCallback(CompletedCallback var1) {
      this.mExceptionCallback = var1;
   }

   public void setStringCallback(WebSocket.StringCallback var1) {
      this.mStringCallback = var1;
   }

   public void setWriteableCallback(WritableCallback var1) {
      this.mSink.setWriteableCallback(var1);
   }

   public void write(ByteBufferList var1) {
      this.send(var1.getAllByteArray());
   }

   public void write(ByteBuffer var1) {
      byte[] var2 = new byte[var1.remaining()];
      var1.get(var2);
      var1.position(0);
      var1.limit(0);
      this.send(var2);
   }
}
