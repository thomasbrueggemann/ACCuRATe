package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

public class AgentHealthException extends HarvestableArray {
   private final AtomicLong count;
   private String exceptionClass;
   private Map<String, String> extras;
   private String message;
   private StackTraceElement[] stackTrace;
   private String threadName;

   public AgentHealthException(Exception var1) {
      this(var1, Thread.currentThread().getName());
   }

   public AgentHealthException(Exception var1, String var2) {
      this(var1.getClass().getName(), var1.getMessage(), var2, var1.getStackTrace());
   }

   public AgentHealthException(String var1, String var2, String var3, StackTraceElement[] var4) {
      this(var1, var2, var3, var4, (Map)null);
   }

   public AgentHealthException(String var1, String var2, String var3, StackTraceElement[] var4, Map<String, String> var5) {
      this.count = new AtomicLong(1L);
      this.exceptionClass = var1;
      this.message = var2;
      this.threadName = var3;
      this.stackTrace = var4;
      this.extras = var5;
   }

   private JsonObject extrasToJson() {
      JsonObject var1 = new JsonObject();
      if(this.extras != null) {
         Iterator var2 = this.extras.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var1.add((String)var3.getKey(), SafeJsonPrimitive.factory((String)var3.getValue()));
         }
      }

      return var1;
   }

   private JsonArray stackTraceToJson() {
      JsonArray var1 = new JsonArray();
      StackTraceElement[] var2 = this.stackTrace;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var1.add(SafeJsonPrimitive.factory(var2[var4].toString()));
      }

      return var1;
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      var1.add(SafeJsonPrimitive.factory(this.exceptionClass));
      String var2;
      if(this.message == null) {
         var2 = "";
      } else {
         var2 = this.message;
      }

      var1.add(SafeJsonPrimitive.factory(var2));
      var1.add(SafeJsonPrimitive.factory(this.threadName));
      var1.add(this.stackTraceToJson());
      var1.add(SafeJsonPrimitive.factory((Number)Long.valueOf(this.count.get())));
      var1.add(this.extrasToJson());
      return var1;
   }

   public long getCount() {
      return this.count.get();
   }

   public String getExceptionClass() {
      return this.exceptionClass;
   }

   public Map<String, String> getExtras() {
      return this.extras;
   }

   public String getMessage() {
      return this.message;
   }

   public String getSourceClass() {
      return this.stackTrace[0].getClassName();
   }

   public String getSourceMethod() {
      return this.stackTrace[0].getMethodName();
   }

   public StackTraceElement[] getStackTrace() {
      return this.stackTrace;
   }

   public String getThreadName() {
      return this.threadName;
   }

   public void increment() {
      this.count.getAndIncrement();
   }

   public void increment(long var1) {
      this.count.getAndAdd(var1);
   }
}
