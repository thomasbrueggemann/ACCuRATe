package com.koushikdutta.async.http;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.NullDataCallback;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.filter.ChunkedOutputFilter;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.async.http.libcore.ResponseHeaders;
import java.nio.ByteBuffer;

abstract class AsyncHttpResponseImpl extends FilteredDataEmitter implements AsyncHttpResponse {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   boolean mCompleted = false;
   private boolean mFirstWrite = true;
   LineEmitter.StringCallback mHeaderCallback = new LineEmitter.StringCallback() {
      private RawHeaders mRawHeaders = new RawHeaders();

      public void onStringAvailable(String var1) {
         try {
            if(this.mRawHeaders.getStatusLine() == null) {
               this.mRawHeaders.setStatusLine(var1);
            } else if(!"\r".equals(var1)) {
               this.mRawHeaders.addLine(var1);
            } else {
               AsyncHttpResponseImpl.this.mHeaders = new ResponseHeaders(AsyncHttpResponseImpl.this.mRequest.getUri(), this.mRawHeaders);
               AsyncHttpResponseImpl.this.onHeadersReceived();
               if(AsyncHttpResponseImpl.this.mSocket != null) {
                  DataEmitter var3 = HttpUtil.getBodyDecoder(AsyncHttpResponseImpl.this.mSocket, this.mRawHeaders, false);
                  AsyncHttpResponseImpl.this.setDataEmitter(var3);
               }

            }
         } catch (Exception var4) {
            AsyncHttpResponseImpl.this.report(var4);
         }
      }
   };
   ResponseHeaders mHeaders;
   private CompletedCallback mReporter = new CompletedCallback() {
      public void onCompleted(Exception var1) {
         if(var1 != null && !AsyncHttpResponseImpl.this.mCompleted) {
            AsyncHttpResponseImpl.this.report(new Exception("connection closed before response completed."));
         } else {
            AsyncHttpResponseImpl.this.report(var1);
         }
      }
   };
   private AsyncHttpRequest mRequest;
   DataSink mSink;
   private AsyncSocket mSocket;
   private AsyncHttpRequestBody mWriter;

   static {
      boolean var0;
      if(!AsyncHttpResponseImpl.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public AsyncHttpResponseImpl(AsyncHttpRequest var1) {
      this.mRequest = var1;
   }

   private void assertContent() {
      if(this.mFirstWrite) {
         this.mFirstWrite = false;
         if(!$assertionsDisabled && this.mRequest.getHeaders().getHeaders().get("Content-Type") == null) {
            throw new AssertionError();
         }

         if(!$assertionsDisabled && this.mRequest.getHeaders().getHeaders().get("Transfer-Encoding") == null && this.mRequest.getHeaders().getContentLength() == -1) {
            throw new AssertionError();
         }
      }

   }

   public void close() {
      this.mSink.close();
   }

   public void end() {
      this.write(ByteBuffer.wrap(new byte[0]));
   }

   public CompletedCallback getClosedCallback() {
      return this.mSink.getClosedCallback();
   }

   public ResponseHeaders getHeaders() {
      return this.mHeaders;
   }

   public AsyncHttpRequest getRequest() {
      return this.mRequest;
   }

   public AsyncServer getServer() {
      return this.mSocket.getServer();
   }

   public AsyncSocket getSocket() {
      return this.mSocket;
   }

   public WritableCallback getWriteableCallback() {
      return this.mSink.getWriteableCallback();
   }

   public boolean isOpen() {
      return this.mSink.isOpen();
   }

   protected abstract void onHeadersReceived();

   protected void onRequestCompleted(Exception var1) {
   }

   protected void report(Exception var1) {
      super.report(var1);
      this.mSocket.setDataCallback(new NullDataCallback() {
         public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
            super.onDataAvailable(var1, var2);
            AsyncHttpResponseImpl.this.mSocket.close();
         }
      });
      this.mSocket.setWriteableCallback((WritableCallback)null);
      this.mSocket.setClosedCallback((CompletedCallback)null);
      this.mSocket.setEndCallback((CompletedCallback)null);
      this.mCompleted = true;
   }

   public void setClosedCallback(CompletedCallback var1) {
      this.mSink.setClosedCallback(var1);
   }

   void setSocket(AsyncSocket var1) {
      this.mSocket = var1;
      if(this.mSocket != null) {
         this.mWriter = this.mRequest.getBody();
         if(this.mWriter != null) {
            this.mRequest.getHeaders().setContentType(this.mWriter.getContentType());
            if(this.mWriter.length() != -1) {
               this.mRequest.getHeaders().setContentLength(this.mWriter.length());
               this.mSink = this.mSocket;
            } else {
               this.mRequest.getHeaders().getHeaders().set("Transfer-Encoding", "Chunked");
               this.mSink = new ChunkedOutputFilter(this.mSocket);
            }
         } else {
            this.mSink = this.mSocket;
         }

         this.mSocket.setEndCallback(this.mReporter);
         this.mSocket.setClosedCallback(new CompletedCallback() {
            public void onCompleted(Exception var1) {
            }
         });
         Util.writeAll(var1, (byte[])this.mRequest.getRequestString().getBytes(), new CompletedCallback() {
            public void onCompleted(Exception var1) {
               if(AsyncHttpResponseImpl.this.mWriter != null) {
                  AsyncHttpResponseImpl.this.mWriter.write(AsyncHttpResponseImpl.this.mRequest, AsyncHttpResponseImpl.this, new CompletedCallback() {
                     public void onCompleted(Exception var1) {
                        AsyncHttpResponseImpl.this.onRequestCompleted(var1);
                     }
                  });
               } else {
                  AsyncHttpResponseImpl.this.onRequestCompleted((Exception)null);
               }
            }
         });
         LineEmitter var2 = new LineEmitter();
         var1.setDataCallback(var2);
         var2.setLineCallback(this.mHeaderCallback);
      }
   }

   public void setWriteableCallback(WritableCallback var1) {
      this.mSink.setWriteableCallback(var1);
   }

   public void write(ByteBufferList var1) {
      this.assertContent();
      this.mSink.write(var1);
   }

   public void write(ByteBuffer var1) {
      this.assertContent();
      this.mSink.write(var1);
   }
}
