package com.koushikdutta.async;

import android.os.Build.VERSION;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.BufferedDataEmitter;
import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.wrapper.AsyncSocketWrapper;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.SSLEngineResult.Status;

public class AsyncSSLSocketWrapper implements AsyncSocketWrapper, AsyncSSLSocket {
   static SSLContext sslContext;
   boolean clientMode;
   SSLEngine engine;
   boolean finishedHandshake;
   HostnameVerifier hostnameVerifier;
   DataCallback mDataCallback;
   BufferedDataEmitter mEmitter;
   private String mHost;
   private int mPort;
   ByteBuffer mReadTmp;
   BufferedDataSink mSink;
   AsyncSocket mSocket;
   boolean mUnwrapping;
   private boolean mWrapping;
   ByteBuffer mWriteTmp;
   WritableCallback mWriteableCallback;
   X509Certificate[] peerCertificates;
   TrustManager[] trustManagers;

   static {
      try {
         if(VERSION.SDK_INT <= 15) {
            throw new Exception();
         } else {
            sslContext = SSLContext.getInstance("Default");
         }
      } catch (Exception var4) {
         try {
            sslContext = SSLContext.getInstance("TLS");
            TrustManager[] var2 = new TrustManager[]{new X509TrustManager() {
               public void checkClientTrusted(X509Certificate[] var1, String var2) {
               }

               public void checkServerTrusted(X509Certificate[] var1, String var2) {
                  int var3 = var1.length;

                  for(int var4 = 0; var4 < var3; ++var4) {
                     X509Certificate var5 = var1[var4];
                     if(var5 != null && var5.getCriticalExtensionOIDs() != null) {
                        var5.getCriticalExtensionOIDs().remove("2.5.29.15");
                     }
                  }

               }

               public X509Certificate[] getAcceptedIssuers() {
                  return new X509Certificate[0];
               }
            }};
            sslContext.init((KeyManager[])null, var2, (SecureRandom)null);
         } catch (Exception var3) {
            var4.printStackTrace();
            var3.printStackTrace();
         }
      }
   }

   public AsyncSSLSocketWrapper(AsyncSocket var1, String var2, int var3) {
      this(var1, var2, var3, sslContext, (TrustManager[])null, (HostnameVerifier)null, true);
   }

   public AsyncSSLSocketWrapper(AsyncSocket var1, String var2, int var3, SSLContext var4, TrustManager[] var5, HostnameVerifier var6, boolean var7) {
      this.mReadTmp = ByteBufferList.obtain(8192);
      this.mUnwrapping = false;
      this.finishedHandshake = false;
      this.mWrapping = false;
      this.mWriteTmp = ByteBufferList.obtain(8192);
      this.mSocket = var1;
      this.hostnameVerifier = var6;
      this.clientMode = var7;
      this.trustManagers = var5;
      if(var4 == null) {
         var4 = sslContext;
      }

      if(var2 != null) {
         this.engine = var4.createSSLEngine(var2, var3);
      } else {
         this.engine = var4.createSSLEngine();
      }

      this.mHost = var2;
      this.mPort = var3;
      this.engine.setUseClientMode(var7);
      this.mSink = new BufferedDataSink(var1);
      this.mSink.setMaxBuffer(0);
      this.mEmitter = new BufferedDataEmitter(var1);
      final ByteBufferList var8 = new ByteBufferList();
      this.mEmitter.setDataCallback(new DataCallback() {
         public void onDataAvailable(DataEmitter param1, ByteBufferList param2) {
            // $FF: Couldn't be decompiled
         }
      });
   }

   // $FF: synthetic method
   static void access$000(AsyncSSLSocketWrapper var0, SSLEngineResult var1) {
      var0.handleResult(var1);
   }

   // $FF: synthetic method
   static void access$100(AsyncSSLSocketWrapper var0, Exception var1) {
      var0.report(var1);
   }

   private void handleResult(SSLEngineResult param1) {
      // $FF: Couldn't be decompiled
   }

   private void report(Exception var1) {
      CompletedCallback var2 = this.getEndCallback();
      if(var2 != null) {
         var2.onCompleted(var1);
      }

   }

   private void writeTmp() {
      this.mWriteTmp.limit(this.mWriteTmp.position());
      this.mWriteTmp.position(0);
      if(this.mWriteTmp.remaining() > 0) {
         this.mSink.write(this.mWriteTmp);
      }

   }

   void addToPending(ByteBufferList var1) {
      if(this.mReadTmp.position() > 0) {
         this.mReadTmp.limit(this.mReadTmp.position());
         this.mReadTmp.position(0);
         var1.add(this.mReadTmp);
         this.mReadTmp = ByteBufferList.obtain(this.mReadTmp.capacity());
      }

   }

   boolean checkWrapResult(SSLEngineResult var1) {
      if(var1.getStatus() == Status.BUFFER_OVERFLOW) {
         this.mWriteTmp = ByteBufferList.obtain(2 * this.mWriteTmp.remaining());
         return false;
      } else {
         return true;
      }
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

   public DataEmitter getDataEmitter() {
      return this.mSocket;
   }

   public CompletedCallback getEndCallback() {
      return this.mSocket.getEndCallback();
   }

   public String getHost() {
      return this.mHost;
   }

   public X509Certificate[] getPeerCertificates() {
      return this.peerCertificates;
   }

   public int getPort() {
      return this.mPort;
   }

   public AsyncServer getServer() {
      return this.mSocket.getServer();
   }

   public AsyncSocket getSocket() {
      return this.mSocket;
   }

   public WritableCallback getWriteableCallback() {
      return this.mWriteableCallback;
   }

   public boolean isChunked() {
      return this.mSocket.isChunked();
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

   public void setClosedCallback(CompletedCallback var1) {
      this.mSocket.setClosedCallback(var1);
   }

   public void setDataCallback(DataCallback var1) {
      this.mDataCallback = var1;
   }

   public void setEndCallback(CompletedCallback var1) {
      this.mSocket.setEndCallback(var1);
   }

   public void setWriteableCallback(WritableCallback var1) {
      this.mWriteableCallback = var1;
   }

   public void write(ByteBufferList param1) {
      // $FF: Couldn't be decompiled
   }

   public void write(ByteBuffer param1) {
      // $FF: Couldn't be decompiled
   }
}
