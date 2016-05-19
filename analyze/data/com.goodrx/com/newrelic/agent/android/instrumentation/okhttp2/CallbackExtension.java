package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.okhttp2.OkHttp2TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class CallbackExtension implements Callback {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private Callback impl;
   private TransactionState transactionState;

   public CallbackExtension(Callback var1, TransactionState var2) {
      this.impl = var1;
      this.transactionState = var2;
   }

   private Response checkResponse(Response var1) {
      if(!this.getTransactionState().isComplete()) {
         if(log.getLevel() >= 4) {
            log.verbose("CallbackExtension.checkResponse() - transaction is not complete.  Inspecting and instrumenting response.");
         }

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
      return this.transactionState;
   }

   public void onFailure(Request var1, IOException var2) {
      if(log.getLevel() >= 4) {
         log.verbose("CallbackExtension.onFailure() - logging error.");
      }

      this.error(var2);
      this.impl.onFailure(var1, var2);
   }

   public void onResponse(Response var1) throws IOException {
      if(log.getLevel() >= 4) {
         log.verbose("CallbackExtension.onResponse() - checking response.");
      }

      Response var2 = this.checkResponse(var1);
      this.impl.onResponse(var2);
   }
}
