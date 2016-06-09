package com.newrelic.agent.android.util;

import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.AgentHealthException;
import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;

public class ExceptionHelper implements HarvestErrorCodes {
   private static final AgentLog log = AgentLogManager.getAgentLog();

   public static int exceptionToErrorCode(Exception var0) {
      short var1 = -1;
      log.debug("ExceptionHelper: exception " + var0.getClass().getName() + " to error code.");
      if(var0 instanceof ClientProtocolException) {
         var1 = -1011;
      } else {
         if(var0 instanceof UnknownHostException) {
            return -1006;
         }

         if(var0 instanceof SocketTimeoutException) {
            return -1001;
         }

         if(var0 instanceof ConnectTimeoutException) {
            return -1001;
         }

         if(var0 instanceof ConnectException) {
            return -1004;
         }

         if(var0 instanceof MalformedURLException) {
            return -1000;
         }

         if(var0 instanceof SSLException) {
            return -1200;
         }

         if(var0 instanceof FileNotFoundException) {
            recordSupportabilityMetric(var0, "FileNotFoundException");
            return -1100;
         }

         if(var0 instanceof EOFException) {
            recordSupportabilityMetric(var0, "EOFException");
            return var1;
         }

         if(var0 instanceof IOException) {
            recordSupportabilityMetric(var0, "IOException");
            return var1;
         }

         if(var0 instanceof RuntimeException) {
            recordSupportabilityMetric(var0, "RuntimeException");
            return var1;
         }
      }

      return var1;
   }

   public static void recordSupportabilityMetric(Exception var0, String var1) {
      AgentHealthException var2 = new AgentHealthException(var0);
      StackTraceElement var3 = var2.getStackTrace()[0];
      AgentLog var4 = log;
      Object[] var5 = new Object[]{var2.getSourceClass(), var2.getSourceMethod(), var3.getFileName(), Integer.valueOf(var3.getLineNumber()), var1, var2.getExceptionClass(), var2.getMessage()};
      var4.error(String.format("ExceptionHelper: %s:%s(%s:%s) %s[%s] %s", var5));
      AgentHealth.noticeException(var2, var1);
   }
}
