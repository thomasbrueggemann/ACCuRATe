package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.io.CountingOutputStream;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListener;
import com.newrelic.agent.android.instrumentation.io.StreamCompleteListenerSource;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class HttpResponseEntityImpl implements StreamCompleteListener, HttpEntity {
   private static final String ENCODING_CHUNKED = "chunked";
   private static final String TRANSFER_ENCODING_HEADER = "Transfer-Encoding";
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private final long contentLengthFromHeader;
   private CountingInputStream contentStream;
   private final HttpEntity impl;
   private final TransactionState transactionState;

   public HttpResponseEntityImpl(HttpEntity var1, TransactionState var2, long var3) {
      this.impl = var1;
      this.transactionState = var2;
      this.contentLengthFromHeader = var3;
   }

   private void addTransactionAndErrorData(TransactionState var1) {
      TransactionData var2 = var1.end();
      if(var2 != null) {
         TaskQueue.queue(new HttpTransactionMeasurement(var2.getUrl(), var2.getHttpMethod(), var2.getStatusCode(), var2.getErrorCode(), var2.getTimestamp(), (double)var2.getTime(), var2.getBytesSent(), var2.getBytesReceived(), var2.getAppData()));
         if((long)var1.getStatusCode() >= 400L) {
            StringBuilder var3 = new StringBuilder();

            try {
               InputStream var9 = this.getContent();
               if(var9 instanceof CountingInputStream) {
                  var3.append(((CountingInputStream)var9).getBufferAsString());
               }
            } catch (Exception var10) {
               log.error(var10.toString());
            }

            Header var5 = this.impl.getContentType();
            TreeMap var6 = new TreeMap();
            if(var5 != null && var5.getValue() != null && !"".equals(var5.getValue())) {
               var6.put("content_type", var5.getValue());
            }

            var6.put("content_length", var1.getBytesReceived() + "");
            Measurements.addHttpError(var2, var3.toString(), var6);
            return;
         }
      }

   }

   private void handleException(Exception var1) {
      this.handleException(var1, (Long)null);
   }

   private void handleException(Exception var1, Long var2) {
      TransactionStateUtil.setErrorCodeFromException(this.transactionState, var1);
      if(!this.transactionState.isComplete()) {
         if(var2 != null) {
            this.transactionState.setBytesReceived(var2.longValue());
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
      // $FF: Couldn't be decompiled
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
      if(!this.transactionState.isComplete()) {
         if(this.contentLengthFromHeader >= 0L) {
            this.transactionState.setBytesReceived(this.contentLengthFromHeader);
         } else {
            this.transactionState.setBytesReceived(var1.getBytes());
         }

         this.addTransactionAndErrorData(this.transactionState);
      }

   }

   public void streamError(StreamCompleteEvent var1) {
      ((StreamCompleteListenerSource)var1.getSource()).removeStreamCompleteListener(this);
      TransactionStateUtil.setErrorCodeFromException(this.transactionState, var1.getException());
      if(!this.transactionState.isComplete()) {
         this.transactionState.setBytesReceived(var1.getBytes());
      }

   }

   public void writeTo(OutputStream var1) throws IOException {
      if(!this.transactionState.isComplete()) {
         CountingOutputStream var2 = new CountingOutputStream(var1);

         try {
            this.impl.writeTo(var2);
         } catch (IOException var4) {
            this.handleException(var4, Long.valueOf(var2.getCount()));
            var4.printStackTrace();
            throw var4;
         }

         if(!this.transactionState.isComplete()) {
            if(this.contentLengthFromHeader >= 0L) {
               this.transactionState.setBytesReceived(this.contentLengthFromHeader);
            } else {
               this.transactionState.setBytesReceived(var2.getCount());
            }

            this.addTransactionAndErrorData(this.transactionState);
         }

      } else {
         this.impl.writeTo(var1);
      }
   }
}
