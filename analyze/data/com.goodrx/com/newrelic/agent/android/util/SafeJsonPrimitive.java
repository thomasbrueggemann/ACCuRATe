package com.newrelic.agent.android.util;

import com.newrelic.com.google.gson.JsonPrimitive;

public class SafeJsonPrimitive {
   public static final Boolean NULL_BOOL;
   public static final char NULL_CHAR = ' ';
   public static final Number NULL_NUMBER = Float.valueOf(Float.NaN);
   public static final String NULL_STRING = "null";

   static {
      NULL_BOOL = Boolean.FALSE;
   }

   public static Boolean checkNull(Boolean var0) {
      if(var0 == null) {
         var0 = NULL_BOOL;
      }

      return var0;
   }

   public static Character checkNull(Character var0) {
      char var1;
      if(var0 == null) {
         var1 = 32;
      } else {
         var1 = var0.charValue();
      }

      return Character.valueOf(var1);
   }

   public static Number checkNull(Number var0) {
      if(var0 == null) {
         var0 = NULL_NUMBER;
      }

      return var0;
   }

   public static String checkNull(String var0) {
      if(var0 == null) {
         var0 = "null";
      }

      return var0;
   }

   public static JsonPrimitive factory(Boolean var0) {
      return new JsonPrimitive(checkNull(var0));
   }

   public static JsonPrimitive factory(Character var0) {
      return new JsonPrimitive(checkNull(var0));
   }

   public static JsonPrimitive factory(Number var0) {
      return new JsonPrimitive(checkNull(var0));
   }

   public static JsonPrimitive factory(String var0) {
      return new JsonPrimitive(checkNull(var0));
   }
}
