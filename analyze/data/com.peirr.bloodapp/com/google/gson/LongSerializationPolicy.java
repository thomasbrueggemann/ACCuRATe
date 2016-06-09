package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public enum LongSerializationPolicy {
   DEFAULT {
      public JsonElement serialize(Long var1) {
         return new JsonPrimitive(var1);
      }
   },
   STRING {
      public JsonElement serialize(Long var1) {
         return new JsonPrimitive(String.valueOf(var1));
      }
   };

   static {
      LongSerializationPolicy[] var0 = new LongSerializationPolicy[]{DEFAULT, STRING};
   }

   private LongSerializationPolicy() {
   }

   // $FF: synthetic method
   LongSerializationPolicy(Object var3) {
      this();
   }

   public abstract JsonElement serialize(Long var1);
}
