package com.koushikdutta.ion;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import com.koushikdutta.ion.ProgressCallback;
import java.nio.ByteBuffer;

class RequestBodyUploadObserver implements AsyncHttpRequestBody {
   AsyncHttpRequestBody body;
   ProgressCallback callback;

   public RequestBodyUploadObserver(AsyncHttpRequestBody var1, ProgressCallback var2) {
      this.body = var1;
      this.callback = var2;
   }

   public Object get() {
      return this.body.get();
   }

   public String getContentType() {
      return this.body.getContentType();
   }

   public int length() {
      return this.body.length();
   }

   public void parse(DataEmitter var1, CompletedCallback var2) {
      this.body.parse(var1, var2);
   }

   public boolean readFullyOnRequest() {
      return this.body.readFullyOnRequest();
   }

   public void write(AsyncHttpRequest var1, final DataSink var2, CompletedCallback var3) {
      final int var4 = this.body.length();
      this.body.write(var1, new DataSink() {
         int totalWritten;

         public void close() {
            var2.close();
         }

         public void end() {
            var2.end();
         }

         public CompletedCallback getClosedCallback() {
            return var2.getClosedCallback();
         }

         public AsyncServer getServer() {
            return var2.getServer();
         }

         public WritableCallback getWriteableCallback() {
            return var2.getWriteableCallback();
         }

         public boolean isOpen() {
            return var2.isOpen();
         }

         public void setClosedCallback(CompletedCallback var1) {
            var2.setClosedCallback(var1);
         }

         public void setWriteableCallback(WritableCallback var1) {
            var2.setWriteableCallback(var1);
         }

         public void write(ByteBufferList var1) {
            int var2x = var1.remaining();
            var2.write(var1);
            this.totalWritten += var2x - var1.remaining();
            RequestBodyUploadObserver.this.callback.onProgress(this.totalWritten, var4);
         }

         public void write(ByteBuffer var1) {
            int var2x = var1.remaining();
            var2.write(var1);
            this.totalWritten += var2x - var1.remaining();
            RequestBodyUploadObserver.this.callback.onProgress(this.totalWritten, var4);
         }
      }, var3);
   }
}
