package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Request.Builder;
import java.net.URL;

public class RequestBuilderExtension extends Builder {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private Builder impl;
   private TransactionState transactionState;

   public RequestBuilderExtension(Builder var1) {
      this.impl = var1;
      this.setCrossProcessHeader();
   }

   private void setCrossProcessHeader() {
      String var1 = Agent.getCrossProcessId();
      if(var1 != null) {
         this.impl.removeHeader("X-NewRelic-ID");
         this.impl.addHeader("X-NewRelic-ID", var1);
      }

   }

   public Builder addHeader(String var1, String var2) {
      return this.impl.addHeader(var1, var2);
   }

   public Request build() {
      return this.impl.build();
   }

   public Builder cacheControl(CacheControl var1) {
      return this.impl.cacheControl(var1);
   }

   public Builder delete() {
      return this.impl.delete();
   }

   public Builder get() {
      return this.impl.get();
   }

   public Builder head() {
      return this.impl.head();
   }

   public Builder header(String var1, String var2) {
      return this.impl.header(var1, var2);
   }

   public Builder headers(Headers var1) {
      return this.impl.headers(var1);
   }

   public Builder method(String var1, RequestBody var2) {
      return this.impl.method(var1, var2);
   }

   public Builder patch(RequestBody var1) {
      return this.impl.patch(var1);
   }

   public Builder post(RequestBody var1) {
      return this.impl.post(var1);
   }

   public Builder put(RequestBody var1) {
      return this.impl.put(var1);
   }

   public Builder removeHeader(String var1) {
      return this.impl.removeHeader(var1);
   }

   public Builder tag(Object var1) {
      return this.impl.tag(var1);
   }

   public Builder url(String var1) {
      return this.impl.url(var1);
   }

   public Builder url(URL var1) {
      return this.impl.url(var1);
   }
}
