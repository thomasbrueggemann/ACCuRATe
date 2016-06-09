package com.koushikdutta.async.http.server;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.BufferedDataSink;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.filter.ChunkedOutputFilter;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.async.http.libcore.ResponseHeaders;
import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequestImpl;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public class AsyncHttpServerResponseImpl implements AsyncHttpServerResponse {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   ChunkedOutputFilter mChunker;
   private int mContentLength = -1;
   boolean mEnded;
   boolean mHasWritten;
   private boolean mHeadWritten;
   private ResponseHeaders mHeaders;
   private RawHeaders mRawHeaders = new RawHeaders();
   AsyncHttpServerRequestImpl mRequest;
   BufferedDataSink mSink;
   AsyncSocket mSocket;

   static {
      boolean var0;
      if(!AsyncHttpServerResponseImpl.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   AsyncHttpServerResponseImpl(AsyncSocket var1, AsyncHttpServerRequestImpl var2) {
      this.mHeaders = new ResponseHeaders((URI)null, this.mRawHeaders);
      this.mHasWritten = false;
      this.mHeadWritten = false;
      this.mSocket = var1;
      this.mSink = new BufferedDataSink(var1);
      this.mRequest = var2;
      this.mRawHeaders.set("Connection", "Keep-Alive");
   }

   private void writeInternal(ByteBufferList var1) {
      if(!$assertionsDisabled && this.mEnded) {
         throw new AssertionError();
      } else {
         this.initFirstWrite();
         this.mChunker.write(var1);
      }
   }

   private void writeInternal(ByteBuffer var1) {
      this.initFirstWrite();
      this.mChunker.write(var1);
   }

   public void close() {
      this.end();
      if(this.mChunker != null) {
         this.mChunker.close();
      } else {
         this.mSink.close();
      }
   }

   public void end() {
      if(this.mRawHeaders.get("Transfer-Encoding") == null) {
         this.send("text/html", "");
         this.onEnd();
      } else {
         this.initFirstWrite();
         this.mChunker.setMaxBuffer(Integer.MAX_VALUE);
         this.mChunker.write(new ByteBufferList());
         this.onEnd();
      }
   }

   public CompletedCallback getClosedCallback() {
      return this.mSink.getClosedCallback();
   }

   public ResponseHeaders getHeaders() {
      return this.mHeaders;
   }

   public AsyncServer getServer() {
      return this.mSocket.getServer();
   }

   public AsyncSocket getSocket() {
      return this.mSocket;
   }

   public WritableCallback getWriteableCallback() {
      this.initFirstWrite();
      return this.mChunker.getWriteableCallback();
   }

   void initFirstWrite() {
      if(!this.mHasWritten) {
         if(!$assertionsDisabled && this.mContentLength >= 0) {
            throw new AssertionError();
         } else if(!$assertionsDisabled && this.mRawHeaders.getStatusLine() == null) {
            throw new AssertionError();
         } else {
            this.mRawHeaders.set("Transfer-Encoding", "Chunked");
            this.writeHead();
            this.mSink.setMaxBuffer(0);
            this.mHasWritten = true;
            this.mChunker = new ChunkedOutputFilter(this.mSink);
         }
      }
   }

   public boolean isOpen() {
      return this.mSink.isOpen();
   }

   public void onCompleted(Exception var1) {
      if(var1 != null) {
         var1.printStackTrace();
      }

      this.end();
   }

   protected void onEnd() {
      this.mEnded = true;
   }

   public void redirect(String var1) {
      this.responseCode(302);
      this.mRawHeaders.set("Location", var1);
      this.end();
   }

   protected void report(Exception var1) {
   }

   public void responseCode(int var1) {
      String var2 = AsyncHttpServer.getResponseCodeDescription(var1);
      RawHeaders var3 = this.mRawHeaders;
      Object[] var4 = new Object[]{Integer.valueOf(var1), var2};
      var3.setStatusLine(String.format("HTTP/1.1 %d %s", var4));
   }

   public void send(String var1) {
      this.responseCode(200);
      this.send("text/html", var1);
   }

   public void send(String var1, String var2) {
      try {
         if(this.mRawHeaders.getStatusLine() == null) {
            this.responseCode(200);
         }

         if(!$assertionsDisabled && this.mContentLength >= 0) {
            throw new AssertionError();
         }

         byte[] var4 = var2.getBytes("UTF-8");
         this.mContentLength = var4.length;
         this.mRawHeaders.set("Content-Length", Integer.toString(var4.length));
         this.mRawHeaders.set("Content-Type", var1);
         this.writeHead();
         this.mSink.write(ByteBuffer.wrap(var2.getBytes()));
         this.onEnd();
      } catch (UnsupportedEncodingException var5) {
         if(!$assertionsDisabled) {
            throw new AssertionError();
         }
      }

   }

   public void send(JSONObject var1) {
      this.send("application/json", var1.toString());
   }

   public void sendFile(File var1) {
      try {
         FileInputStream var2 = new FileInputStream(var1);
         this.mRawHeaders.set("Content-Type", AsyncHttpServer.getContentType(var1.getAbsolutePath()));
         this.responseCode(200);
         Util.pump((InputStream)var2, this, new CompletedCallback() {
            public void onCompleted(Exception var1) {
               AsyncHttpServerResponseImpl.this.end();
            }
         });
      } catch (FileNotFoundException var4) {
         this.responseCode(404);
         this.end();
      }
   }

   public void setClosedCallback(CompletedCallback var1) {
      this.mSink.setClosedCallback(var1);
   }

   public void setContentType(String var1) {
      if(!$assertionsDisabled && this.mHeadWritten) {
         throw new AssertionError();
      } else {
         this.mRawHeaders.set("Content-Type", var1);
      }
   }

   public void setWriteableCallback(WritableCallback var1) {
      this.initFirstWrite();
      this.mChunker.setWriteableCallback(var1);
   }

   public void write(ByteBufferList var1) {
      if(var1.remaining() != 0) {
         this.writeInternal(var1);
      }
   }

   public void write(ByteBuffer var1) {
      if(var1.remaining() != 0) {
         this.writeInternal(var1);
      }
   }

   public void writeHead() {
      if(!$assertionsDisabled && this.mHeadWritten) {
         throw new AssertionError();
      } else {
         this.mHeadWritten = true;
         this.mSink.write(ByteBuffer.wrap(this.mRawHeaders.toHeaderString().getBytes()));
      }
   }
}
