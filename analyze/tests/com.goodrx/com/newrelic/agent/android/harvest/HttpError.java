package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpErrorMeasurement;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Map;

public class HttpError extends HarvestableArray {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private String appData;
   private long count;
   private String digest;
   private int httpStatusCode;
   private Map<String, String> params;
   private String responseBody;
   private String stackTrace;
   private Long timestamp;
   private String url;

   public HttpError() {
   }

   public HttpError(HttpErrorMeasurement var1) {
      this(var1.getUrl(), var1.getHttpStatusCode(), var1.getResponseBody(), var1.getStackTrace(), var1.getParams());
      this.setTimestamp(Long.valueOf(var1.getStartTime()));
   }

   public HttpError(String var1, int var2, String var3, String var4, Map<String, String> var5) {
      this.url = var1;
      this.httpStatusCode = var2;
      this.responseBody = var3;
      this.stackTrace = var4;
      this.params = var5;
      this.count = 1L;
      this.digest = this.computeHash();
   }

   private String computeHash() {
      MessageDigest var2;
      try {
         var2 = MessageDigest.getInstance("SHA-1");
      } catch (NoSuchAlgorithmException var3) {
         log.error("Unable to initialize SHA-1 hash algorithm");
         return null;
      }

      var2.update(this.url.getBytes());
      var2.update(ByteBuffer.allocate(8).putInt(this.httpStatusCode).array());
      if(this.stackTrace != null && this.stackTrace.length() > 0) {
         var2.update(this.stackTrace.getBytes());
      }

      return new String(var2.digest());
   }

   public JsonArray asJsonArray() {
      int var1 = Harvest.getHarvestConfiguration().getResponse_body_limit();
      JsonArray var2 = new JsonArray();
      var2.add(SafeJsonPrimitive.factory(this.url));
      var2.add(SafeJsonPrimitive.factory((Number)Integer.valueOf(this.httpStatusCode)));
      var2.add(SafeJsonPrimitive.factory((Number)Long.valueOf(this.count)));
      String var3 = "";
      if(FeatureFlag.featureEnabled(FeatureFlag.HttpResponseBodyCapture)) {
         var3 = this.optional(this.responseBody);
         if(var3.length() > var1) {
            log.warning("HTTP Error response BODY is too large. Truncating to " + var1 + " bytes.");
            var3 = var3.substring(0, var1);
         }
      } else {
         log.warning("not enabled");
      }

      var2.add(SafeJsonPrimitive.factory(Agent.getEncoder().encode(var3.getBytes())));
      var2.add(SafeJsonPrimitive.factory(this.optional(this.stackTrace)));
      JsonObject var4 = new JsonObject();
      if(this.params == null) {
         this.params = Collections.emptyMap();
      }

      var4.add("custom_params", HarvestableObject.fromMap(this.params).asJson());
      var2.add(var4);
      var2.add(SafeJsonPrimitive.factory(this.optional(this.appData)));
      return var2;
   }

   public void digest() {
      this.digest = this.computeHash();
   }

   public String getHash() {
      return this.digest;
   }

   public Map<String, String> getParams() {
      return this.params;
   }

   public Long getTimestamp() {
      return this.timestamp;
   }

   public void incrementCount() {
      ++this.count;
   }

   public void setAppData(String var1) {
      this.appData = var1;
   }

   public void setCount(long var1) {
      this.count = var1;
   }

   public void setHttpStatusCode(int var1) {
      this.httpStatusCode = var1;
   }

   public void setParams(Map<String, String> var1) {
      this.params = var1;
   }

   public void setResponseBody(String var1) {
      this.responseBody = var1;
   }

   public void setStackTrace(String var1) {
      this.stackTrace = var1;
   }

   public void setTimestamp(Long var1) {
      this.timestamp = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }
}
