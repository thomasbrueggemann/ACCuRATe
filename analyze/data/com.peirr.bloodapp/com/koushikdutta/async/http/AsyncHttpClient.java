package com.koushikdutta.async.http;

import android.os.Handler;
import com.koushikdutta.async.AsyncSSLException;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.NullDataCallback;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.AsyncHttpGet;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.AsyncHttpResponseImpl;
import com.koushikdutta.async.http.AsyncSSLSocketMiddleware;
import com.koushikdutta.async.http.AsyncSocketMiddleware;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.WebSocketImpl;
import com.koushikdutta.async.http.callback.HttpConnectCallback;
import com.koushikdutta.async.http.callback.RequestCallback;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.async.parser.JSONObjectParser;
import com.koushikdutta.async.parser.StringParser;
import com.koushikdutta.async.stream.OutputStreamDataCallback;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

public class AsyncHttpClient {
   // $FF: synthetic field
   static final boolean $assertionsDisabled = false;
   private static final String LOGTAG = "AsyncHttp";
   private static AsyncHttpClient mDefaultInstance;
   ArrayList<AsyncHttpClientMiddleware> mMiddleware = new ArrayList();
   AsyncServer mServer;
   AsyncSocketMiddleware socketMiddleware;
   AsyncSSLSocketMiddleware sslSocketMiddleware;

   static {
      boolean var0;
      if(!AsyncHttpClient.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public AsyncHttpClient(AsyncServer var1) {
      this.mServer = var1;
      AsyncSocketMiddleware var2 = new AsyncSocketMiddleware(this);
      this.socketMiddleware = var2;
      this.insertMiddleware(var2);
      AsyncSSLSocketMiddleware var3 = new AsyncSSLSocketMiddleware(this);
      this.sslSocketMiddleware = var3;
      this.insertMiddleware(var3);
   }

   private <T> SimpleFuture<T> execute(AsyncHttpRequest var1, final AsyncParser<T> var2, final RequestCallback<T> var3) {
      AsyncHttpClient.FutureAsyncHttpResponse var4 = new AsyncHttpClient.FutureAsyncHttpResponse(null);
      final SimpleFuture var5 = new SimpleFuture();
      this.execute(var1, 0, var4, new HttpConnectCallback() {
         // $FF: synthetic field
         final Handler val$handler;

         {
            this.val$handler = var2x;
         }

         public void onConnectCompleted(Exception var1, final AsyncHttpResponse var2x) {
            if(var1 != null) {
               AsyncHttpClient.this.invoke(this.val$handler, var3, var5, var2x, var1, (Object)null);
            } else {
               AsyncHttpClient.this.invokeConnect(var3, var2x);
               var2x.getHeaders().getContentLength();
               Future var4 = var2.parse(var2x).setCallback(new FutureCallback() {
                  public void onCompleted(Exception var1, T var2xx) {
                     AsyncHttpClient.this.invoke(val$handler, var3, var5, var2x, var1, var2xx);
                  }
               });
               var5.setParent(var4);
            }
         }
      });
      var5.setParent(var4);
      return var5;
   }

   private void execute(final AsyncHttpRequest var1, final int var2, final AsyncHttpClient.FutureAsyncHttpResponse var3, final HttpConnectCallback var4) {
      if(this.mServer.isAffinityThread()) {
         this.executeAffinity(var1, var2, var3, var4);
      } else {
         this.mServer.post(new Runnable() {
            public void run() {
               AsyncHttpClient.this.executeAffinity(var1, var2, var3, var4);
            }
         });
      }
   }

   private void executeAffinity(final AsyncHttpRequest var1, final int var2, final AsyncHttpClient.FutureAsyncHttpResponse var3, final HttpConnectCallback var4) {
      if(!$assertionsDisabled && !this.mServer.isAffinityThread()) {
         throw new AssertionError();
      } else {
         if(var2 > 5) {
            this.reportConnectedCompleted(var3, new Exception("too many redirects"), (AsyncHttpResponseImpl)null, var1, var4);
         } else {
            final URI var5 = var1.getUri();
            final AsyncHttpClientMiddleware.OnRequestCompleteData var6 = new AsyncHttpClientMiddleware.OnRequestCompleteData();
            var1.executionTime = System.currentTimeMillis();
            var6.request = var1;
            var1.logd("Executing request.");
            if(var1.getTimeout() > 0) {
               var3.timeoutRunnable = new Runnable() {
                  public void run() {
                     if(var6.socketCancellable != null) {
                        var6.socketCancellable.cancel();
                        if(var6.socket != null) {
                           var6.socket.close();
                        }
                     }

                     AsyncHttpClient.this.reportConnectedCompleted(var3, new TimeoutException(), (AsyncHttpResponseImpl)null, var1, var4);
                  }
               };
               var3.scheduled = this.mServer.postDelayed(var3.timeoutRunnable, getTimeoutRemaining(var1));
            }

            var6.connectCallback = new ConnectCallback() {
               public void onConnectCompleted(Exception var1x, AsyncSocket var2x) {
                  if(var3.isCancelled()) {
                     if(var2x != null) {
                        var2x.close();
                     }

                  } else {
                     if(var3.timeoutRunnable != null) {
                        AsyncHttpClient.this.mServer.removeAllCallbacks(var3.scheduled);
                     }

                     var6.socket = var2x;
                     Iterator var3x = AsyncHttpClient.this.mMiddleware.iterator();

                     while(var3x.hasNext()) {
                        ((AsyncHttpClientMiddleware)var3x.next()).onSocket(var6);
                     }

                     var3.socket = var2x;
                     if(var1x != null) {
                        AsyncHttpClient.this.reportConnectedCompleted(var3, var1x, (AsyncHttpResponseImpl)null, var1, var4);
                     } else {
                        (new AsyncHttpResponseImpl(var1) {
                           public AsyncSocket detachSocket() {
                              var1.logd("Detaching socket");
                              AsyncSocket var1x = this.getSocket();
                              if(var1x == null) {
                                 return null;
                              } else {
                                 var1x.setWriteableCallback((WritableCallback)null);
                                 var1x.setClosedCallback((CompletedCallback)null);
                                 var1x.setEndCallback((CompletedCallback)null);
                                 var1x.setDataCallback((DataCallback)null);
                                 this.setSocket((AsyncSocket)null);
                                 return var1x;
                              }
                           }

                           protected void onHeadersReceived() {
                              // $FF: Couldn't be decompiled
                           }

                           protected void onRequestCompleted(Exception var1x) {
                              if(!var3.isCancelled() && var3.timeoutRunnable != null && var6.headers == null) {
                                 AsyncHttpClient.this.mServer.removeAllCallbacks(var3.scheduled);
                                 var3.scheduled = AsyncHttpClient.this.mServer.postDelayed(var3.timeoutRunnable, AsyncHttpClient.getTimeoutRemaining(var1));
                              }
                           }

                           protected void report(Exception var1x) {
                              if(!var3.isCancelled()) {
                                 if(var1x instanceof AsyncSSLException) {
                                    var1.loge("SSL Exception", var1x);
                                    AsyncSSLException var4x = (AsyncSSLException)var1x;
                                    var1.onHandshakeException(var4x);
                                    if(var4x.getIgnore()) {
                                       return;
                                    }
                                 }

                                 AsyncSocket var2x = this.getSocket();
                                 if(var2x != null) {
                                    super.report(var1x);
                                    if((!var2x.isOpen() || var1x != null) && this.getHeaders() == null && var1x != null) {
                                       AsyncHttpClient.this.reportConnectedCompleted(var3, var1x, (AsyncHttpResponseImpl)null, var1, var4);
                                    }

                                    var6.exception = var1x;
                                    Iterator var3x = AsyncHttpClient.this.mMiddleware.iterator();

                                    while(var3x.hasNext()) {
                                       ((AsyncHttpClientMiddleware)var3x.next()).onRequestComplete(var6);
                                    }
                                 }
                              }

                           }

                           public void setDataEmitter(DataEmitter var1x) {
                              var6.bodyEmitter = var1x;
                              Iterator var2x = AsyncHttpClient.this.mMiddleware.iterator();

                              while(var2x.hasNext()) {
                                 ((AsyncHttpClientMiddleware)var2x.next()).onBodyDecoder(var6);
                              }

                              this.mHeaders = var6.headers;
                              super.setDataEmitter(var6.bodyEmitter);
                              RawHeaders var3x = this.mHeaders.getHeaders();
                              if((var3x.getResponseCode() == 301 || var3x.getResponseCode() == 302) && var1.getFollowRedirect()) {
                                 URI var4x = URI.create(var3x.get("Location"));
                                 if(var4x == null || var4x.getScheme() == null) {
                                    var4x = URI.create(var5.toString().substring(0, var5.toString().length() - var5.getPath().length()) + var3x.get("Location"));
                                 }

                                 AsyncHttpRequest var5x = new AsyncHttpRequest(var4x, var1.getMethod());
                                 var5x.executionTime = var1.executionTime;
                                 var5x.logLevel = var1.logLevel;
                                 var5x.LOGTAG = var1.LOGTAG;
                                 var1.logi("Redirecting");
                                 var5x.logi("Redirected");
                                 AsyncHttpClient.this.execute(var5x, 1 + var2, var3, var4);
                                 this.setDataCallback(new NullDataCallback());
                              } else {
                                 var1.logv("Final (post cache response) headers: " + this.mHeaders.getHeaders().toHeaderString());
                                 AsyncHttpClient.this.reportConnectedCompleted(var3, (Exception)null, this, var1, var4);
                              }
                           }
                        }).setSocket(var2x);
                     }
                  }
               }
            };
            Iterator var7 = this.mMiddleware.iterator();

            while(var7.hasNext()) {
               Cancellable var8 = ((AsyncHttpClientMiddleware)var7.next()).getSocket(var6);
               if(var8 != null) {
                  var6.socketCancellable = var8;
                  var3.setParent(var8);
                  return;
               }
            }

            if(!$assertionsDisabled) {
               throw new AssertionError();
            }
         }

      }
   }

   public static AsyncHttpClient getDefaultInstance() {
      if(mDefaultInstance == null) {
         mDefaultInstance = new AsyncHttpClient(AsyncServer.getDefault());
      }

      return mDefaultInstance;
   }

   private static long getTimeoutRemaining(AsyncHttpRequest var0) {
      return (long)var0.getTimeout();
   }

   private <T> void invoke(Handler var1, final RequestCallback<T> var2, final SimpleFuture<T> var3, final AsyncHttpResponse var4, final Exception var5, final T var6) {
      Runnable var7 = new Runnable() {
         public void run() {
            AsyncHttpClient.this.invokeWithAffinity(var2, var3, var4, var5, var6);
         }
      };
      if(var1 == null) {
         this.mServer.post(var7);
      } else {
         AsyncServer.post(var1, var7);
      }
   }

   private void invokeConnect(RequestCallback var1, AsyncHttpResponse var2) {
      if(var1 != null) {
         var1.onConnect(var2);
      }

   }

   private void invokeProgress(RequestCallback var1, AsyncHttpResponse var2, int var3, int var4) {
      if(var1 != null) {
         var1.onProgress(var2, var3, var4);
      }

   }

   private <T> void invokeWithAffinity(RequestCallback<T> var1, SimpleFuture<T> var2, AsyncHttpResponse var3, Exception var4, T var5) {
      boolean var6;
      if(var4 != null) {
         var6 = var2.setComplete(var4);
      } else {
         var6 = var2.setComplete(var5);
      }

      if(var6 && var1 != null) {
         var1.onCompleted(var4, var3, var5);
      }
   }

   private void reportConnectedCompleted(AsyncHttpClient.FutureAsyncHttpResponse var1, Exception var2, AsyncHttpResponseImpl var3, AsyncHttpRequest var4, HttpConnectCallback var5) {
      if(!$assertionsDisabled && var5 == null) {
         throw new AssertionError();
      } else {
         boolean var6;
         if(var2 != null) {
            var4.loge("Connection error", var2);
            var6 = var1.setComplete(var2);
         } else {
            var4.logd("Connection successful");
            var6 = var1.setComplete(var3);
         }

         if(var6) {
            var5.onConnectCompleted(var2, var3);
            if(!$assertionsDisabled && var2 == null && var3.getSocket() != null && var3.getDataCallback() == null) {
               throw new AssertionError();
            }
         } else if(var3 != null) {
            var3.setDataCallback(new NullDataCallback());
            var3.close();
         }

      }
   }

   @Deprecated
   public Future<JSONObject> execute(AsyncHttpRequest var1, AsyncHttpClient.JSONObjectCallback var2) {
      return this.executeJSONObject(var1, var2);
   }

   @Deprecated
   public Future<String> execute(AsyncHttpRequest var1, AsyncHttpClient.StringCallback var2) {
      return this.executeString(var1, var2);
   }

   public Future<AsyncHttpResponse> execute(AsyncHttpRequest var1, HttpConnectCallback var2) {
      AsyncHttpClient.FutureAsyncHttpResponse var3 = new AsyncHttpClient.FutureAsyncHttpResponse(null);
      this.execute(var1, 0, var3, var2);
      return var3;
   }

   @Deprecated
   public Future<File> execute(AsyncHttpRequest var1, String var2, AsyncHttpClient.FileCallback var3) {
      return this.executeFile(var1, var2, var3);
   }

   public Future<AsyncHttpResponse> execute(String var1, HttpConnectCallback var2) {
      return this.execute((AsyncHttpRequest)(new AsyncHttpGet(URI.create(var1))), (HttpConnectCallback)var2);
   }

   public Future<AsyncHttpResponse> execute(URI var1, HttpConnectCallback var2) {
      return this.execute((AsyncHttpRequest)(new AsyncHttpGet(var1)), (HttpConnectCallback)var2);
   }

   public Future<ByteBufferList> executeByteBufferList(AsyncHttpRequest var1, AsyncHttpClient.DownloadCallback var2) {
      return this.execute(var1, (AsyncParser)(new ByteBufferListParser()), (RequestCallback)var2);
   }

   public Future<File> executeFile(AsyncHttpRequest var1, String var2) {
      return this.executeFile(var1, var2, (AsyncHttpClient.FileCallback)null);
   }

   public Future<File> executeFile(AsyncHttpRequest var1, String var2, final AsyncHttpClient.FileCallback var3) {
      final Handler var4 = var1.getHandler();
      final File var5 = new File(var2);
      var5.getParentFile().mkdirs();

      final BufferedOutputStream var7;
      try {
         var7 = new BufferedOutputStream(new FileOutputStream(var5), 8192);
      } catch (FileNotFoundException var13) {
         SimpleFuture var12 = new SimpleFuture();
         var12.setComplete((Exception)var13);
         return var12;
      }

      final AsyncHttpClient.FutureAsyncHttpResponse var8 = new AsyncHttpClient.FutureAsyncHttpResponse(null);
      final SimpleFuture var9 = new SimpleFuture() {
         public void cancelCleanup() {
            try {
               ((AsyncHttpResponse)var8.get()).setDataCallback(new NullDataCallback());
               ((AsyncHttpResponse)var8.get()).close();
            } catch (Exception var4) {
               ;
            }

            try {
               var7.close();
            } catch (Exception var3) {
               ;
            }

            var5.delete();
         }
      };
      var9.setParent(var8);
      this.execute(var1, 0, var8, new HttpConnectCallback() {
         int mDownloaded = 0;

         public void onConnectCompleted(Exception var1, final AsyncHttpResponse var2) {
            if(var1 != null) {
               try {
                  var7.close();
               } catch (IOException var5x) {
                  ;
               }

               var5.delete();
               AsyncHttpClient.this.invoke(var4, var3, var9, var2, var1, (Object)null);
            } else {
               AsyncHttpClient.this.invokeConnect(var3, var2);
               final int var3x = var2.getHeaders().getContentLength();
               var2.setDataCallback(new OutputStreamDataCallback(var7) {
                  public void onDataAvailable(DataEmitter var1, ByteBufferList var2x) {
                     <undefinedtype> var3xx = <VAR_NAMELESS_ENCLOSURE>;
                     var3xx.mDownloaded += var2x.remaining();
                     super.onDataAvailable(var1, var2x);
                     AsyncHttpClient.this.invokeProgress(var3, var2, mDownloaded, var3x);
                  }
               });
               var2.setEndCallback(new CompletedCallback() {
                  public void onCompleted(Exception var1) {
                     try {
                        var7.close();
                     } catch (IOException var3x) {
                        var1 = var3x;
                     }

                     if(var1 != null) {
                        var5.delete();
                        AsyncHttpClient.this.invoke(var4, var3, var9, var2, (Exception)var1, (Object)null);
                     } else {
                        AsyncHttpClient.this.invoke(var4, var3, var9, var2, (Exception)null, var5);
                     }
                  }
               });
            }
         }
      });
      return var9;
   }

   public Future<JSONObject> executeJSONObject(AsyncHttpRequest var1) {
      return this.executeJSONObject(var1, (AsyncHttpClient.JSONObjectCallback)null);
   }

   public Future<JSONObject> executeJSONObject(AsyncHttpRequest var1, AsyncHttpClient.JSONObjectCallback var2) {
      return this.execute(var1, (AsyncParser)(new JSONObjectParser()), (RequestCallback)var2);
   }

   public Future<String> executeString(AsyncHttpRequest var1) {
      return this.executeString(var1, (AsyncHttpClient.StringCallback)null);
   }

   public Future<String> executeString(AsyncHttpRequest var1, AsyncHttpClient.StringCallback var2) {
      return this.execute(var1, (AsyncParser)(new StringParser()), (RequestCallback)var2);
   }

   @Deprecated
   public Future<ByteBufferList> get(String var1, AsyncHttpClient.DownloadCallback var2) {
      return this.getByteBufferList(var1, var2);
   }

   @Deprecated
   public Future<JSONObject> get(String var1, AsyncHttpClient.JSONObjectCallback var2) {
      return this.executeJSONObject(new AsyncHttpGet(var1), var2);
   }

   @Deprecated
   public Future<String> get(String var1, AsyncHttpClient.StringCallback var2) {
      return this.executeString(new AsyncHttpGet(var1), var2);
   }

   @Deprecated
   public Future<File> get(String var1, String var2, AsyncHttpClient.FileCallback var3) {
      return this.executeFile(new AsyncHttpGet(var1), var2, var3);
   }

   public Future<ByteBufferList> getByteBufferList(String var1) {
      return this.getByteBufferList(var1, (AsyncHttpClient.DownloadCallback)null);
   }

   public Future<ByteBufferList> getByteBufferList(String var1, AsyncHttpClient.DownloadCallback var2) {
      return this.executeByteBufferList(new AsyncHttpGet(var1), var2);
   }

   public Future<File> getFile(String var1, String var2) {
      return this.getFile(var1, var2, (AsyncHttpClient.FileCallback)null);
   }

   public Future<File> getFile(String var1, String var2, AsyncHttpClient.FileCallback var3) {
      return this.executeFile(new AsyncHttpGet(var1), var2, var3);
   }

   public Future<JSONObject> getJSONObject(String var1) {
      return this.getJSONObject(var1, (AsyncHttpClient.JSONObjectCallback)null);
   }

   public Future<JSONObject> getJSONObject(String var1, AsyncHttpClient.JSONObjectCallback var2) {
      return this.executeJSONObject(new AsyncHttpGet(var1), var2);
   }

   public ArrayList<AsyncHttpClientMiddleware> getMiddleware() {
      return this.mMiddleware;
   }

   public AsyncSSLSocketMiddleware getSSLSocketMiddleware() {
      return this.sslSocketMiddleware;
   }

   public AsyncServer getServer() {
      return this.mServer;
   }

   public AsyncSocketMiddleware getSocketMiddleware() {
      return this.socketMiddleware;
   }

   public Future<String> getString(String var1) {
      return this.executeString(new AsyncHttpGet(var1), (AsyncHttpClient.StringCallback)null);
   }

   public Future<String> getString(String var1, AsyncHttpClient.StringCallback var2) {
      return this.executeString(new AsyncHttpGet(var1), var2);
   }

   public void insertMiddleware(AsyncHttpClientMiddleware var1) {
      this.mMiddleware.add(0, var1);
   }

   public Future<WebSocket> websocket(final AsyncHttpRequest var1, String var2, final AsyncHttpClient.WebSocketConnectCallback var3) {
      WebSocketImpl.addWebSocketUpgradeHeaders(var1, var2);
      final SimpleFuture var4 = new SimpleFuture();
      var4.setParent(this.execute(var1, new HttpConnectCallback() {
         public void onConnectCompleted(Exception var1x, AsyncHttpResponse var2) {
            if(var1x != null) {
               if(var4.setComplete(var1x) && var3 != null) {
                  var3.onCompleted(var1x, (WebSocket)null);
               }
            } else {
               WebSocket var3x = WebSocketImpl.finishHandshake(var1.getHeaders().getHeaders(), var2);
               if(var3x == null) {
                  if(!var4.setComplete(new Exception("Unable to complete websocket handshake"))) {
                     return;
                  }
               } else if(!var4.setComplete((Object)var3x)) {
                  return;
               }

               if(var3 != null) {
                  var3.onCompleted(var1x, var3x);
                  return;
               }
            }

         }
      }));
      return var4;
   }

   public Future<WebSocket> websocket(String var1, String var2, AsyncHttpClient.WebSocketConnectCallback var3) {
      if(!$assertionsDisabled && var3 == null) {
         throw new AssertionError();
      } else {
         return this.websocket((AsyncHttpRequest)(new AsyncHttpGet(var1)), var2, var3);
      }
   }

   public abstract static class DownloadCallback extends AsyncHttpClient.RequestCallbackBase<ByteBufferList> {
   }

   public abstract static class FileCallback extends AsyncHttpClient.RequestCallbackBase<File> {
   }

   private class FutureAsyncHttpResponse extends SimpleFuture<AsyncHttpResponse> {
      public Object scheduled;
      public AsyncSocket socket;
      public Runnable timeoutRunnable;

      private FutureAsyncHttpResponse() {
      }

      // $FF: synthetic method
      FutureAsyncHttpResponse(Object var2) {
         this();
      }

      public boolean cancel() {
         if(!super.cancel()) {
            return false;
         } else {
            if(this.socket != null) {
               this.socket.close();
            }

            if(this.scheduled != null) {
               AsyncHttpClient.this.mServer.removeAllCallbacks(this.scheduled);
            }

            return true;
         }
      }
   }

   public abstract static class JSONObjectCallback extends AsyncHttpClient.RequestCallbackBase<JSONObject> {
   }

   public abstract static class RequestCallbackBase<T> implements RequestCallback<T> {
      public void onConnect(AsyncHttpResponse var1) {
      }

      public void onProgress(AsyncHttpResponse var1, int var2, int var3) {
      }
   }

   public abstract static class StringCallback extends AsyncHttpClient.RequestCallbackBase<String> {
   }

   public interface WebSocketConnectCallback {
      void onCompleted(Exception var1, WebSocket var2);
   }
}
