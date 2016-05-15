package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.io.CountingOutputStream;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListenerSource;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class HttpRequestEntityImpl implements StreamCompleteListener, HttpEntity {
   private final HttpEntity impl;
   private final TransactionState transactionState;

   public HttpRequestEntityImpl(HttpEntity var1, TransactionState var2) {
      this.impl = var1;
      this.transactionState = var2;
   }

   private void handleException(Exception var1) {
      this.handleException(var1, (Long)null);
   }

   private void handleException(Exception var1, Long var2) {
      TransactionStateUtil.setErrorCodeFromException(this.transactionState, var1);
      if(!this.transactionState.isComplete()) {
         if(var2 != null) {
            this.transactionState.setBytesSent(var2.longValue());
         }

         TransactionData var3 = this.transactionState.end();
         if(var3 != null) {
            TaskQueue.queue(new HttpTransactionMeasurement(var3.getUrl(), var3.getHttpMethod(), var3.getStatusCode(), var3.getErrorCode(), var3.getTimestamp(), (double)var3.getTime(), var3.getBytesSent(), var3.getBytesReceived(), var3.getAppData()));
         }
      }

   }

   public void consumeContent() throws IOException {
      try {
         this.impl.consumeContent();
      } catch (IOException var2) {
         this.handleException(var2);
         throw var2;
      }
   }

   public InputStream getContent() throws IOException, IllegalStateException {
      try {
         if(!this.transactionState.isSent()) {
            CountingInputStream var3 = new CountingInputStream(this.impl.getContent());
            var3.addStreamCompleteListener(this);
            return var3;
         } else {
            InputStream var4 = this.impl.getContent();
            return var4;
         }
      } catch (IOException var5) {
         this.handleException(var5);
         throw var5;
      } catch (IllegalStateException var6) {
         this.handleException(var6);
         throw var6;
      }
   }

   public Header getContentEncoding() {
      return this.impl.getContentEncoding();
   }

   public long getContentLength() {
      return this.impl.getContentLength();
   }

   public Header getContentType() {
      return this.impl.getContentType();
   }

   public boolean isChunked() {
      return this.impl.isChunked();
   }

   public boolean isRepeatable() {
      return this.impl.isRepeatable();
   }

   public boolean isStreaming() {
      return this.impl.isStreaming();
   }

   public void streamComplete(StreamCompleteEvent var1) {
      ((StreamCompleteListenerSource)var1.getSource()).removeStreamCompleteListener(this);
      this.transactionState.setBytesSent(var1.getBytes());
   }

   public void streamError(StreamCompleteEvent var1) {
      ((StreamCompleteListenerSource)var1.getSource()).removeStreamCompleteListener(this);
      this.handleException(var1.getException(), Long.valueOf(var1.getBytes()));
   }

   public void writeTo(OutputStream var1) throws IOException {
      try {
         if(!this.transactionState.isSent()) {
            CountingOutputStream var3 = new CountingOutputStream(var1);
            this.impl.writeTo(var3);
            this.transactionState.setBytesSent(var3.getCount());
         } else {
            this.impl.writeTo(var1);
         }
      } catch (IOException var4) {
         this.handleException(var4);
         throw var4;
      }
   }
}
