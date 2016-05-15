package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.instrumentation.ReplaceCallSite;
import com.newrelic.agent.android.instrumentation.retrofit.RestAdapterBuilderExtension;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import retrofit.RestAdapter.Builder;
import retrofit.client.Client;

public final class RetrofitInstrumentation {
   private static final AgentLog log = AgentLogManager.getAgentLog();

   @ReplaceCallSite
   public static Builder setClient(Builder var0, Client var1) {
      return (new RestAdapterBuilderExtension(var0)).setClient(var1);
   }
}
