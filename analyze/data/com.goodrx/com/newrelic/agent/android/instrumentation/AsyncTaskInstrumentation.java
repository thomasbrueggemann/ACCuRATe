package com.newrelic.agent.android.instrumentation;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.ReplaceCallSite;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.tracing.TracingInactiveException;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.util.concurrent.Executor;

public class AsyncTaskInstrumentation {
   private static final AgentLog log = AgentLogManager.getAgentLog();

   @ReplaceCallSite
   public static final <Params, Progress, Result> AsyncTask execute(AsyncTask<Params, Progress, Result> var0, Params... var1) {
      try {
         ((TraceFieldInterface)var0)._nr_setTrace(TraceMachine.getCurrentTrace());
      } catch (ClassCastException var5) {
         ExceptionHelper.recordSupportabilityMetric(var5, "TraceFieldInterface");
         log.error("Not a TraceFieldInterface: " + var5.getMessage());
      } catch (TracingInactiveException var6) {
         ;
      } catch (NoSuchFieldError var7) {
         ;
      }

      return var0.execute(var1);
   }

   @TargetApi(11)
   @ReplaceCallSite
   public static final <Params, Progress, Result> AsyncTask executeOnExecutor(AsyncTask<Params, Progress, Result> var0, Executor var1, Params... var2) {
      try {
         ((TraceFieldInterface)var0)._nr_setTrace(TraceMachine.getCurrentTrace());
      } catch (ClassCastException var6) {
         ExceptionHelper.recordSupportabilityMetric(var6, "TraceFieldInterface");
         log.error("Not a TraceFieldInterface: " + var6.getMessage());
      } catch (TracingInactiveException var7) {
         ;
      } catch (NoSuchFieldError var8) {
         ;
      }

      return var0.executeOnExecutor(var1, var2);
   }
}
