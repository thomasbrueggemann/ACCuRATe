package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.JsonElement;

public final class JsonNull extends JsonElement {
   public static final JsonNull INSTANCE = new JsonNull();

   JsonNull deepCopy() {
      return INSTANCE;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof JsonNull;
   }

   public int hashCode() {
      return JsonNull.class.hashCode();
   }
}
