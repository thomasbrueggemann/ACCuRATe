package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.okhttp2.CallbackExtension;
import com.newrelic.agent.android.instrumentation.okhttp2.OkHttp2TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class CallExtension extends Call {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private OkHttpClient client;
   private Call impl;
   private Request request;
   private TransactionState transactionState;

   CallExtension(OkHttpClient var1, Request var2, Call var3) {
      super(var1, var2);
      this.client = var1;
      this.request = var2;
      this.impl = var3;
   }

   private Response checkResponse(Response var1) {
      if(!this.getTransactionState().isComplete()) {
         var1 = OkHttp2TransactionStateUtil.inspectAndInstrumentResponse(this.getTransactionState(), var1);
      }

      return var1;
   }

   private void error(Exception var1) {
      TransactionState var2 = this.getTransactionState();
      TransactionStateUtil.setErrorCodeFromException(var2, var1);
      if(!var2.isComplete()) {
         TransactionData var3 = var2.end();
         if(var3 != null) {
            TaskQueue.queue(new HttpTransactionMeasurement(var3.getUrl(), var3.getHttpMethod(), var3.getStatusCode(), var3.getErrorCode(), var3.getTimestamp(), (double)var3.getTime(), var3.getBytesSent(), var3.getBytesReceived(), var3.getAppData()));
         }
      }

   }

   private TransactionState getTransactionState() {
      if(this.transactionState == null) {
         this.transactionState = new TransactionState();
         OkHttp2TransactionStateUtil.inspectAndInstrument(this.transactionState, this.request);
      }

      return this.transactionState;
   }

   public void cancel() {
      this.impl.cancel();
   }

   public void enqueue(Callback var1) {
      this.getTransactionState();
      this.impl.enqueue(new CallbackExtension(var1, this.transactionState));
   }

   public Response execute() throws IOException {
      this.getTransactionState();

      Response var3;
      try {
         var3 = this.impl.execute();
      } catch (IOException var4) {
         this.error(var4);
         throw var4;
      }

      return this.checkResponse(var3);
   }

   public boolean isCanceled() {
      return this.impl.isCanceled();
   }
}
