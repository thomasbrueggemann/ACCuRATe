package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.retrofit.ContentBufferingTypedInput;
import com.newrelic.agent.android.instrumentation.retrofit.RetrofitTransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.util.ArrayList;
import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;

public class ClientExtension implements Client {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private Client impl;
   private Request request;
   private TransactionState transactionState;

   public ClientExtension(Client var1) {
      this.impl = var1;
   }

   private void checkResponse(Response var1) {
      if(!this.getTransactionState().isComplete()) {
         RetrofitTransactionStateUtil.inspectAndInstrumentResponse(this.getTransactionState(), var1);
      }

   }

   private void error(Exception var1) {
      log.debug("handling exception: " + var1.toString());
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
         RetrofitTransactionStateUtil.inspectAndInstrument(this.transactionState, this.request);
      }

      return this.transactionState;
   }

   private Request setCrossProcessHeader(Request var1) {
      String var2 = Agent.getCrossProcessId();
      if(var2 != null) {
         ArrayList var3 = new ArrayList(var1.getHeaders());
         var3.add(new Header("X-NewRelic-ID", var2));
         var1 = new Request(var1.getMethod(), var1.getUrl(), var3, var1.getBody());
      }

      return var1;
   }

   public Response execute(Request var1) throws IOException {
      this.request = var1;
      this.getTransactionState();
      Request var3 = this.setCrossProcessHeader(var1);

      Response var6;
      label20: {
         IOException var4;
         label19: {
            Response var5;
            try {
               var5 = this.impl.execute(var3);
            } catch (IOException var8) {
               var4 = var8;
               break label19;
            }

            try {
               var6 = new Response(var5.getUrl(), var5.getStatus(), var5.getReason(), var5.getHeaders(), new ContentBufferingTypedInput(var5.getBody()));
               break label20;
            } catch (IOException var7) {
               var4 = var7;
            }
         }

         this.error(var4);
         throw var4;
      }

      this.checkResponse(var6);
      return var6;
   }
}
