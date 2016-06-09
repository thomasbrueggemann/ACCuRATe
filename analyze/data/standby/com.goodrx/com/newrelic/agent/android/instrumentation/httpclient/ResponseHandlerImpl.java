package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

public final class ResponseHandlerImpl<T> implements ResponseHandler<T> {
   private final ResponseHandler<T> impl;
   private final TransactionState transactionState;

   private ResponseHandlerImpl(ResponseHandler<T> var1, TransactionState var2) {
      this.impl = var1;
      this.transactionState = var2;
   }

   public static <T> ResponseHandler<? extends T> wrap(ResponseHandler<? extends T> var0, TransactionState var1) {
      return new ResponseHandlerImpl(var0, var1);
   }

   public T handleResponse(HttpResponse var1) throws ClientProtocolException, IOException {
      TransactionStateUtil.inspectAndInstrument(this.transactionState, var1);
      return this.impl.handleResponse(var1);
   }
}
