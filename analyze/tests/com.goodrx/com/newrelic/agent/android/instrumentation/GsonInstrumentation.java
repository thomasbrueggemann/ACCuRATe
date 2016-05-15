package com.newrelic.agent.android.instrumentation;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.instrumentation.ReplaceCallSite;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class GsonInstrumentation {
   private static final ArrayList<String> categoryParams;

   static {
      String[] var0 = new String[]{"category", MetricCategory.class.getName(), "JSON"};
      categoryParams = new ArrayList(Arrays.asList(var0));
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static <T> T fromJson(Gson var0, JsonElement var1, Class<T> var2) throws JsonSyntaxException {
      TraceMachine.enterMethod("Gson#fromJson", categoryParams);
      Object var3 = var0.fromJson(var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static <T> T fromJson(Gson var0, JsonElement var1, Type var2) throws JsonSyntaxException {
      TraceMachine.enterMethod("Gson#fromJson", categoryParams);
      Object var3 = var0.fromJson(var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static <T> T fromJson(Gson var0, JsonReader var1, Type var2) throws JsonIOException, JsonSyntaxException {
      TraceMachine.enterMethod("Gson#fromJson", categoryParams);
      Object var3 = var0.fromJson(var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static <T> T fromJson(Gson var0, Reader var1, Class<T> var2) throws JsonSyntaxException, JsonIOException {
      TraceMachine.enterMethod("Gson#fromJson", categoryParams);
      Object var3 = var0.fromJson(var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static <T> T fromJson(Gson var0, Reader var1, Type var2) throws JsonIOException, JsonSyntaxException {
      TraceMachine.enterMethod("Gson#fromJson", categoryParams);
      Object var3 = var0.fromJson(var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static <T> T fromJson(Gson var0, String var1, Class<T> var2) throws JsonSyntaxException {
      TraceMachine.enterMethod("Gson#fromJson", categoryParams);
      Object var3 = var0.fromJson(var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static <T> T fromJson(Gson var0, String var1, Type var2) throws JsonSyntaxException {
      TraceMachine.enterMethod("Gson#fromJson", categoryParams);
      Object var3 = var0.fromJson(var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static String toJson(Gson var0, JsonElement var1) {
      TraceMachine.enterMethod("Gson#toJson", categoryParams);
      String var2 = var0.toJson(var1);
      TraceMachine.exitMethod();
      return var2;
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static String toJson(Gson var0, Object var1) {
      TraceMachine.enterMethod("Gson#toJson", categoryParams);
      String var2 = var0.toJson(var1);
      TraceMachine.exitMethod();
      return var2;
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static String toJson(Gson var0, Object var1, Type var2) {
      TraceMachine.enterMethod("Gson#toJson", categoryParams);
      String var3 = var0.toJson(var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static void toJson(Gson var0, JsonElement var1, JsonWriter var2) throws JsonIOException {
      TraceMachine.enterMethod("Gson#toJson", categoryParams);
      var0.toJson(var1, var2);
      TraceMachine.exitMethod();
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static void toJson(Gson var0, JsonElement var1, Appendable var2) throws JsonIOException {
      TraceMachine.enterMethod("Gson#toJson", categoryParams);
      var0.toJson(var1, var2);
      TraceMachine.exitMethod();
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static void toJson(Gson var0, Object var1, Appendable var2) throws JsonIOException {
      TraceMachine.enterMethod("Gson#toJson", categoryParams);
      var0.toJson(var1, var2);
      TraceMachine.exitMethod();
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static void toJson(Gson var0, Object var1, Type var2, JsonWriter var3) throws JsonIOException {
      TraceMachine.enterMethod("Gson#toJson", categoryParams);
      var0.toJson(var1, var2, var3);
      TraceMachine.exitMethod();
   }

   @ReplaceCallSite(
      scope = "com.google.gson.Gson"
   )
   public static void toJson(Gson var0, Object var1, Type var2, Appendable var3) throws JsonIOException {
      TraceMachine.enterMethod("Gson#toJson", categoryParams);
      var0.toJson(var1, var2, var3);
      TraceMachine.exitMethod();
   }
}
