package com.newrelic.agent.android.util;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;

public enum NetworkFailure {
   BadServerResponse(-1011),
   BadURL(-1000),
   CannotConnectToHost(-1004),
   DNSLookupFailed(-1006),
   SecureConnectionFailed(-1200),
   TimedOut(-1001),
   Unknown(-1);

   private static final AgentLog log;
   private int errorCode;

   static {
      NetworkFailure[] var0 = new NetworkFailure[]{Unknown, BadURL, TimedOut, CannotConnectToHost, DNSLookupFailed, BadServerResponse, SecureConnectionFailed};
      log = AgentLogManager.getAgentLog();
   }

   private NetworkFailure(int var3) {
      this.errorCode = var3;
   }

   public static int exceptionToErrorCode(Exception var0) {
      return exceptionToNetworkFailure(var0).getErrorCode();
   }

   public static NetworkFailure exceptionToNetworkFailure(Exception var0) {
      log.error("NetworkFailure.exceptionToNetworkFailure: Attempting to convert network exception " + var0.getClass().getName() + " to error code.");
      NetworkFailure var1 = Unknown;
      if(var0 instanceof UnknownHostException) {
         var1 = DNSLookupFailed;
         return var1;
      } else if(!(var0 instanceof SocketTimeoutException) && !(var0 instanceof ConnectTimeoutException)) {
         if(var0 instanceof ConnectException) {
            return CannotConnectToHost;
         } else if(var0 instanceof MalformedURLException) {
            return BadURL;
         } else if(var0 instanceof SSLException) {
            return SecureConnectionFailed;
         } else if(!(var0 instanceof HttpResponseException) && !(var0 instanceof ClientProtocolException)) {
            return var1;
         } else {
            return BadServerResponse;
         }
      } else {
         return TimedOut;
      }
   }

   public static NetworkFailure fromErrorCode(int var0) {
      log.debug("fromErrorCode invoked with errorCode: " + var0);
      NetworkFailure[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         NetworkFailure var4 = var1[var3];
         if(var4.getErrorCode() == var0) {
            log.debug("fromErrorCode found matching failure: " + var4);
            return var4;
         }
      }

      return Unknown;
   }

   public int getErrorCode() {
      return this.errorCode;
   }
}
