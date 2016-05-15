package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class ThreadInfo extends HarvestableObject {
   private boolean crashed;
   private StackTraceElement[] stackTrace;
   private String state;
   private long threadId;
   private String threadName;
   private int threadPriority;

   private ThreadInfo() {
   }

   public ThreadInfo(Thread var1, StackTraceElement[] var2) {
      this.crashed = false;
      this.threadId = var1.getId();
      this.threadName = var1.getName();
      this.threadPriority = var1.getPriority();
      this.stackTrace = var2;
      this.state = var1.getState().toString();
   }

   public ThreadInfo(Throwable var1) {
      this.crashed = true;
      this.threadId = Thread.currentThread().getId();
      this.threadName = Thread.currentThread().getName();
      this.threadPriority = Thread.currentThread().getPriority();
      this.stackTrace = var1.getStackTrace();
      this.state = Thread.currentThread().getState().toString();
   }

   public static List<ThreadInfo> extractThreads(Throwable var0) {
      ArrayList var1 = new ArrayList();
      ThreadInfo var2 = new ThreadInfo(var0);
      long var3 = var2.getThreadId();
      var1.add(var2);
      Iterator var6 = Thread.getAllStackTraces().entrySet().iterator();

      while(var6.hasNext()) {
         Entry var7 = (Entry)var6.next();
         Thread var8 = (Thread)var7.getKey();
         StackTraceElement[] var9 = (StackTraceElement[])var7.getValue();
         if(var8.getId() != var3) {
            var1.add(new ThreadInfo(var8, var9));
         }
      }

      return var1;
   }

   private JsonArray getStackAsJson() {
      JsonArray var1 = new JsonArray();
      StackTraceElement[] var2 = this.stackTrace;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         StackTraceElement var5 = var2[var4];
         JsonObject var6 = new JsonObject();
         if(var5.getFileName() != null) {
            var6.add("fileName", SafeJsonPrimitive.factory(var5.getFileName()));
         }

         var6.add("className", SafeJsonPrimitive.factory(var5.getClassName()));
         var6.add("methodName", SafeJsonPrimitive.factory(var5.getMethodName()));
         var6.add("lineNumber", SafeJsonPrimitive.factory((Number)Integer.valueOf(var5.getLineNumber())));
         var1.add(var6);
      }

      return var1;
   }

   public static ThreadInfo newFromJson(JsonObject var0) {
      ThreadInfo var1 = new ThreadInfo();
      var1.crashed = var0.get("crashed").getAsBoolean();
      var1.state = var0.get("state").getAsString();
      var1.threadId = var0.get("threadNumber").getAsLong();
      var1.threadName = var0.get("threadId").getAsString();
      var1.threadPriority = var0.get("priority").getAsInt();
      var1.stackTrace = stackTraceFromJson(var0.get("stack").getAsJsonArray());
      return var1;
   }

   public static List<ThreadInfo> newListFromJson(JsonArray var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         var1.add(newFromJson(((JsonElement)var2.next()).getAsJsonObject()));
      }

      return var1;
   }

   public static StackTraceElement[] stackTraceFromJson(JsonArray var0) {
      StackTraceElement[] var1 = new StackTraceElement[var0.size()];
      int var2 = 0;

      int var7;
      for(Iterator var3 = var0.iterator(); var3.hasNext(); var2 = var7) {
         JsonElement var4 = (JsonElement)var3.next();
         String var5 = "unknown";
         if(var4.getAsJsonObject().get("fileName") != null) {
            var5 = var4.getAsJsonObject().get("fileName").getAsString();
         }

         StackTraceElement var6 = new StackTraceElement(var4.getAsJsonObject().get("className").getAsString(), var4.getAsJsonObject().get("methodName").getAsString(), var5, var4.getAsJsonObject().get("lineNumber").getAsInt());
         var7 = var2 + 1;
         var1[var2] = var6;
      }

      return var1;
   }

   public JsonObject asJsonObject() {
      JsonObject var1 = new JsonObject();
      var1.add("crashed", SafeJsonPrimitive.factory(Boolean.valueOf(this.crashed)));
      var1.add("state", SafeJsonPrimitive.factory(this.state));
      var1.add("threadNumber", SafeJsonPrimitive.factory((Number)Long.valueOf(this.threadId)));
      var1.add("threadId", SafeJsonPrimitive.factory(this.threadName));
      var1.add("priority", SafeJsonPrimitive.factory((Number)Integer.valueOf(this.threadPriority)));
      var1.add("stack", this.getStackAsJson());
      return var1;
   }

   public long getThreadId() {
      return this.threadId;
   }
}
