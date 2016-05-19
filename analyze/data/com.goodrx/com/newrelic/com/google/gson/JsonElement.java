package com.newrelic.com.google.gson;

import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonNull;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import com.newrelic.com.google.gson.internal.Streams;
import com.newrelic.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonElement {
   abstract JsonElement deepCopy();

   public BigDecimal getAsBigDecimal() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public BigInteger getAsBigInteger() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public boolean getAsBoolean() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   Boolean getAsBooleanWrapper() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public byte getAsByte() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public char getAsCharacter() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public double getAsDouble() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public float getAsFloat() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public int getAsInt() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public JsonArray getAsJsonArray() {
      if(this.isJsonArray()) {
         return (JsonArray)this;
      } else {
         throw new IllegalStateException("This is not a JSON Array.");
      }
   }

   public JsonNull getAsJsonNull() {
      if(this.isJsonNull()) {
         return (JsonNull)this;
      } else {
         throw new IllegalStateException("This is not a JSON Null.");
      }
   }

   public JsonObject getAsJsonObject() {
      if(this.isJsonObject()) {
         return (JsonObject)this;
      } else {
         throw new IllegalStateException("Not a JSON Object: " + this);
      }
   }

   public JsonPrimitive getAsJsonPrimitive() {
      if(this.isJsonPrimitive()) {
         return (JsonPrimitive)this;
      } else {
         throw new IllegalStateException("This is not a JSON Primitive.");
      }
   }

   public long getAsLong() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public Number getAsNumber() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public short getAsShort() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public String getAsString() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public boolean isJsonArray() {
      return this instanceof JsonArray;
   }

   public boolean isJsonNull() {
      return this instanceof JsonNull;
   }

   public boolean isJsonObject() {
      return this instanceof JsonObject;
   }

   public boolean isJsonPrimitive() {
      return this instanceof JsonPrimitive;
   }

   public String toString() {
      try {
         StringWriter var1 = new StringWriter();
         JsonWriter var2 = new JsonWriter(var1);
         var2.setLenient(true);
         Streams.write(this, var2);
         String var4 = var1.toString();
         return var4;
      } catch (IOException var5) {
         throw new AssertionError(var5);
      }
   }
}
