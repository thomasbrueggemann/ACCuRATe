package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;

public class ExceptionInfo extends HarvestableObject {
   private String className;
   private String message;

   public ExceptionInfo() {
   }

   public ExceptionInfo(Throwable var1) {
      if(var1.getClass().getName().equalsIgnoreCase("com.newrelic.agent.android.unity.UnityException")) {
         this.className = var1.toString();
      } else {
         this.className = var1.getClass().getName();
      }

      if(var1.getMessage() != null) {
         this.message = var1.getMessage();
      } else {
         this.message = "";
      }
   }

   public static ExceptionInfo newFromJson(JsonObject var0) {
      ExceptionInfo var1 = new ExceptionInfo();
      String var2;
      if(var0.has("name")) {
         var2 = var0.get("name").getAsString();
      } else {
         var2 = "";
      }

      var1.className = var2;
      String var3;
      if(var0.has("cause")) {
         var3 = var0.get("cause").getAsString();
      } else {
         var3 = "";
      }

      var1.message = var3;
      return var1;
   }

   public JsonObject asJsonObject() {
      JsonObject var1 = new JsonObject();
      String var2;
      if(this.className != null) {
         var2 = this.className;
      } else {
         var2 = "";
      }

      var1.add("name", new JsonPrimitive(var2));
      String var3;
      if(this.message != null) {
         var3 = this.message;
      } else {
         var3 = "";
      }

      var1.add("cause", new JsonPrimitive(var3));
      return var1;
   }

   public String getClassName() {
      return this.className;
   }

   public String getMessage() {
      return this.message;
   }
}
