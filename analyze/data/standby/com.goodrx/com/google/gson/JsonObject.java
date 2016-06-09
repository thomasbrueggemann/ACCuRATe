package com.google.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Set;
import java.util.Map.Entry;

public final class JsonObject extends JsonElement {
   private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap();

   public void add(String var1, JsonElement var2) {
      if(var2 == null) {
         var2 = JsonNull.INSTANCE;
      }

      this.members.put(var1, var2);
   }

   public Set<Entry<String, JsonElement>> entrySet() {
      return this.members.entrySet();
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof JsonObject && ((JsonObject)var1).members.equals(this.members);
   }

   public JsonArray getAsJsonArray(String var1) {
      return (JsonArray)this.members.get(var1);
   }

   public JsonObject getAsJsonObject(String var1) {
      return (JsonObject)this.members.get(var1);
   }

   public JsonPrimitive getAsJsonPrimitive(String var1) {
      return (JsonPrimitive)this.members.get(var1);
   }

   public boolean has(String var1) {
      return this.members.containsKey(var1);
   }

   public int hashCode() {
      return this.members.hashCode();
   }
}
