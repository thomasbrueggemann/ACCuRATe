package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.instrumentation.retrofit.ClientExtension;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.concurrent.Executor;
import retrofit.Endpoint;
import retrofit.ErrorHandler;
import retrofit.Profiler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Builder;
import retrofit.RestAdapter.Log;
import retrofit.RestAdapter.LogLevel;
import retrofit.client.Client;
import retrofit.client.Client.Provider;
import retrofit.converter.Converter;

public class RestAdapterBuilderExtension extends Builder {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private Builder impl;

   public RestAdapterBuilderExtension(Builder var1) {
      this.impl = var1;
   }

   public RestAdapter build() {
      return this.impl.build();
   }

   public Builder setClient(Provider var1) {
      return this.impl.setClient(var1);
   }

   public Builder setClient(Client var1) {
      log.debug("RestAdapterBuilderExtension.setClient() wrapping client " + var1 + " with new ClientExtension.");
      return this.impl.setClient(new ClientExtension(var1));
   }

   public Builder setConverter(Converter var1) {
      return this.impl.setConverter(var1);
   }

   public Builder setEndpoint(String var1) {
      return this.impl.setEndpoint(var1);
   }

   public Builder setEndpoint(Endpoint var1) {
      return this.impl.setEndpoint(var1);
   }

   public Builder setErrorHandler(ErrorHandler var1) {
      return this.impl.setErrorHandler(var1);
   }

   public Builder setExecutors(Executor var1, Executor var2) {
      return this.impl.setExecutors(var1, var2);
   }

   public Builder setLog(Log var1) {
      return this.impl.setLog(var1);
   }

   public Builder setLogLevel(LogLevel var1) {
      return this.impl.setLogLevel(var1);
   }

   public Builder setProfiler(Profiler var1) {
      return this.impl.setProfiler(var1);
   }

   public Builder setRequestInterceptor(RequestInterceptor var1) {
      return this.impl.setRequestInterceptor(var1);
   }
}
