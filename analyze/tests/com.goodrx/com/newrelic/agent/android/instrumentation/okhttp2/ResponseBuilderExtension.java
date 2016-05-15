package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Response.Builder;

public class ResponseBuilderExtension extends Builder {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private Builder impl;

   public ResponseBuilderExtension(Builder var1) {
      this.impl = var1;
   }

   public Builder addHeader(String var1, String var2) {
      return this.impl.addHeader(var1, var2);
   }

   public Builder body(ResponseBody param1) {
      // $FF: Couldn't be decompiled
   }

   public Response build() {
      return this.impl.build();
   }

   public Builder cacheResponse(Response var1) {
      return this.impl.cacheResponse(var1);
   }

   public Builder code(int var1) {
      return this.impl.code(var1);
   }

   public Builder handshake(Handshake var1) {
      return this.impl.handshake(var1);
   }

   public Builder header(String var1, String var2) {
      return this.impl.header(var1, var2);
   }

   public Builder headers(Headers var1) {
      return this.impl.headers(var1);
   }

   public Builder message(String var1) {
      return this.impl.message(var1);
   }

   public Builder networkResponse(Response var1) {
      return this.impl.networkResponse(var1);
   }

   public Builder priorResponse(Response var1) {
      return this.impl.priorResponse(var1);
   }

   public Builder protocol(Protocol var1) {
      return this.impl.protocol(var1);
   }

   public Builder removeHeader(String var1) {
      return this.impl.removeHeader(var1);
   }

   public Builder request(Request var1) {
      return this.impl.request(var1);
   }
}
